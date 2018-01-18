package com.salajim.musab.funnyjokes.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salajim.musab.funnyjokes.R;

/**
 * Created by Musab on 1/17/2018.
 */

public class FavoriteJokesFragment extends Fragment {
    public static final String TAG = "FavoriteJokesFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.favorite_jokes, container, false);
    }
}
