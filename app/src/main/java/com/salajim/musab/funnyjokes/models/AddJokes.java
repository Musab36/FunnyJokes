package com.salajim.musab.funnyjokes.models;

import org.parceler.Parcel;

/**
 * Created by Musab on 1/18/2018.
 */
@Parcel
public class AddJokes {
    String jokeId;
    String joke;

    public AddJokes() {}

    public AddJokes(String jokeId, String joke) {
        this.jokeId = jokeId;
        this.joke = joke;
    }

    public String getJokeId() {
        return jokeId;
    }

    public String getJoke() {
        return joke;
    }
}
