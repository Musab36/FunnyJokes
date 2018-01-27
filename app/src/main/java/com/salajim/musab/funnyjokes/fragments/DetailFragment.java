package com.salajim.musab.funnyjokes.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.salajim.musab.funnyjokes.R;
import com.salajim.musab.funnyjokes.models.AddJokes;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements View.OnClickListener{
    @Bind(R.id.heartImageView) ImageView mHeartImageView;
    @Bind(R.id.jokesTextView) TextView mJokesTextView;

    FirebaseDatabase database;
    DatabaseReference mRef;

    private AddJokes mAddJokes;

    // newInstance(), is used instead of a constructor and returns a new instance of ProductDetailFragment
    public static DetailFragment newInstance(AddJokes jokes) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("addJokes", Parcels.wrap(jokes));
        detailFragment.setArguments(args);
        return detailFragment;
    }
    //onCreate(), is called when the fragment is created. Here, we unwrap our product object from the arguments we added in the newInstance()
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAddJokes = Parcels.unwrap(getArguments().getParcelable("addJokes"));
    }

    // onCreateView(), this product object is then used to set our ImageView and TextViews
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, view);

        mJokesTextView.setText(mAddJokes.getJoke());

        mHeartImageView.setOnClickListener(this);

        return view;
    }

    public void onClick(View v) {
        if(v == mHeartImageView) {
            SharedPreferences sharedPref = this.getActivity().getSharedPreferences("favorites", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("favorites", mAddJokes.getJoke());
            editor.apply();
            Toast.makeText(getActivity(), "Joke saved to favorites", Toast.LENGTH_SHORT).show();
        }
    }

}
