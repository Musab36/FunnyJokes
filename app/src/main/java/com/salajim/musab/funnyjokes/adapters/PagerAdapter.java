package com.salajim.musab.funnyjokes.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.salajim.musab.funnyjokes.fragments.DetailFragment;
import com.salajim.musab.funnyjokes.models.AddJokes;

import java.util.ArrayList;

/**
 * Created by Musab on 1/24/2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<AddJokes> mAddJokes = new ArrayList<>();

    public PagerAdapter(FragmentManager fm, ArrayList<AddJokes> jokes) {
        super(fm);
        mAddJokes = jokes;
    }

    @Override
    public Fragment getItem(int position) {
        return DetailFragment.newInstance(mAddJokes.get(position));
    }

    @Override
    public int getCount() {
        return mAddJokes.size();
    }
}
