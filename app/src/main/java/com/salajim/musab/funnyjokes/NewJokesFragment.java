package com.salajim.musab.funnyjokes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Musab on 1/17/2018.
 */

public class NewJokesFragment extends Fragment {
    public static final String TAG = "NewJokesFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.new_jokes, container, false);
    }
}
