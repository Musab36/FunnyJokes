package com.salajim.musab.funnyjokes.models;

/**
 * Created by Musab on 1/21/2018.
 */

public class Videos {
    String videoUrl;

    public Videos(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
