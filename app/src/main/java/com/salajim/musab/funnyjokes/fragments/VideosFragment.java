package com.salajim.musab.funnyjokes.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salajim.musab.funnyjokes.R;
import com.salajim.musab.funnyjokes.adapters.VideosAdapter;
import com.salajim.musab.funnyjokes.models.Videos;

import java.util.Vector;

/**
 * Created by Musab on 1/17/2018.
 */

public class VideosFragment extends Fragment {
    public static final String TAG = "VideosFragment";

    RecyclerView recyclerView;
    Vector<Videos> funnyVideos = new Vector<Videos>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.favorite_jokes, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //funnyVideos.add(new Videos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/0Q68KwoXG3s\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        funnyVideos.add(new Videos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/gwqjdExeChs\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        funnyVideos.add(new Videos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/8O-lk8_MsvQ\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        funnyVideos.add(new Videos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/GS0GH0xmUzc\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        funnyVideos.add(new Videos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Ucq4FQ-3vqk\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        funnyVideos.add(new Videos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/SwbjGaslS40\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        funnyVideos.add(new Videos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/FeLlcyBOl_o\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        funnyVideos.add(new Videos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/OPa0qr69KpM\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        funnyVideos.add(new Videos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/2tJym-KVdms\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        funnyVideos.add(new Videos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/gG_p5wv00eE\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        funnyVideos.add(new Videos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/LfvKNIf5l6U\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        funnyVideos.add(new Videos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/eTRFkoUSgyo\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        funnyVideos.add(new Videos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/kj1BQxIGfrc\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));

        VideosAdapter videosAdapter = new VideosAdapter(funnyVideos);
        recyclerView.setAdapter(videosAdapter);

        return view;
    }
}
