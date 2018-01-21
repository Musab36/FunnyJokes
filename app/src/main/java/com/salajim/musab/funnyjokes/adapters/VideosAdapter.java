package com.salajim.musab.funnyjokes.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.salajim.musab.funnyjokes.R;
import com.salajim.musab.funnyjokes.models.Videos;

import java.util.List;

/**
 * Created by Musab on 1/21/2018.
 */

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.VideosViewHolder> {

    List<Videos> videosList;

    public VideosAdapter() {

    }

    @Override
    public VideosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.videos, parent, false);

        return new VideosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideosViewHolder holder, int position) {
        holder.videosWeb.loadData(videosList.get(position).getVideoUrl(), "text/html", "utf-8");
    }

    public VideosAdapter(List<Videos> videos) {
        this.videosList = videos;
    }



    @Override
    public int getItemCount() {
        return videosList.size();
    }

    public class VideosViewHolder extends RecyclerView.ViewHolder {
        WebView videosWeb;

        public VideosViewHolder(View itemView) {
            super(itemView);

            videosWeb = (WebView) itemView.findViewById(R.id.web);

            videosWeb.getSettings().setJavaScriptEnabled(true);
            videosWeb.setWebChromeClient(new WebChromeClient() {

            });
        }
    }
}
