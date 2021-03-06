package com.salajim.musab.funnyjokes.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.salajim.musab.funnyjokes.R;
import com.salajim.musab.funnyjokes.activities.JokesActivity;
import com.salajim.musab.funnyjokes.models.AddJokes;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Musab on 1/18/2018.
 */

public class JokesAdapter extends RecyclerView.Adapter<JokesAdapter.JokesViewHolder> {
    private ArrayList<AddJokes> mAddJokes = new ArrayList<>();
    private Context mContext;
    FirebaseDatabase database;
    DatabaseReference mRef;

    public JokesAdapter(Context context, ArrayList<AddJokes> jokes) {
        mContext = context;
        mAddJokes = jokes;
    }

    @Override
    public JokesAdapter.JokesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        JokesViewHolder viewHolder = new JokesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(JokesAdapter.JokesViewHolder holder, int position) {
        holder.bindJokes(mAddJokes.get(position));
    }

    @Override
    public int getItemCount() {
        return mAddJokes.size();
    }

    public class JokesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.jokesTextView)
        TextView mJokesTextView;
        private Context mContext;

        public JokesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();//Retrieves the position of the specific list item clicked
            Intent intent = new Intent(mContext, JokesActivity.class);
            intent.putExtra("addJokes", itemPosition);
            intent.putExtra("addJokes", Parcels.wrap(mAddJokes));
            mContext.startActivity(intent);
        }

        public void bindJokes(AddJokes addJokes) {

            mJokesTextView.setText(addJokes.getJoke());
        }
    }

}
