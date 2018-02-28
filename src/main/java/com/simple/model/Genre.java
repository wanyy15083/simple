package com.simple.model;

import javax.validation.constraints.NotNull;

/**
 * Created by songyigui on 2018/2/28.
 */
public class Genre {
    @NotNull
    private String name;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "name='" + name + '\'' +
                '}';
    }
}
