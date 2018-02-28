package com.simple.model;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by songyigui on 2018/2/28.
 */
public class Director {
    @NotNull
    private String name;

    private List<Movie> movies;

    public Director() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                ", movies=" + movies +
                '}';
    }
}
