package com.salajim.musab.funnyjokes.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.salajim.musab.funnyjokes.R;

/**
 * Created by Musab on 1/17/2018.
 */

public class TopJokesFragment extends Fragment {
    public static final String TAG = "TopJokesFragment";

    //private ArrayList<AddJokes> mAddJokes = new ArrayList<>();
    //private FavoritesAdapter mAdapter;

    //RecyclerView recyclerView;
    TextView mJokesTextView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_jokes, container, false);

        //recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mJokesTextView = (TextView) view.findViewById(R.id.jokesTextView);

        SharedPreferences sharedPref = this.getActivity().getSharedPreferences("favorites", Context.MODE_PRIVATE);
        String favs = sharedPref.getString("favorites", "");
        mJokesTextView.setText(favs);

        /*
        mAdapter = new FavoritesAdapter(getActivity(), mAddJokes);
        recyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        */

        return view;
    }
}
