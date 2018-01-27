package com.salajim.musab.funnyjokes.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.salajim.musab.funnyjokes.R;
import com.salajim.musab.funnyjokes.models.AddJokes;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.salajim.musab.funnyjokes.R.id.jokesTextView;

/**
 * Created by Musab on 1/27/2018.
 */

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>{
    private ArrayList<AddJokes> mAddJokes = new ArrayList<>();
    private Context mContext;

    public FavoritesAdapter(Context context, ArrayList<AddJokes> jokes) {
        mContext = context;
        mAddJokes = jokes;
    }

    @Override
    public FavoritesAdapter.FavoritesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorites, parent, false);
        FavoritesViewHolder viewHolder = new FavoritesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FavoritesAdapter.FavoritesViewHolder holder, int position) {
        holder.bindJokes(mAddJokes.get(position));
    }

    @Override
    public int getItemCount() {
        return mAddJokes.size();
    }

    public class FavoritesViewHolder extends RecyclerView.ViewHolder {
        @Bind(jokesTextView) TextView mJokesTextView;
        private Context mContext;

        public FavoritesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindJokes(AddJokes addJokes) {
            SharedPreferences sharedPref = mContext.getSharedPreferences("favorites", Context.MODE_PRIVATE);
            String favs = sharedPref.getString("favorites", "");
            mJokesTextView.setText(favs);
        }
    }
}
