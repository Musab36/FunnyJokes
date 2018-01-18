package com.salajim.musab.funnyjokes.models;

/**
 * Created by Musab on 1/18/2018.
 */

public class AddJokes {
    private String jokeId;
    private String joke;

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
