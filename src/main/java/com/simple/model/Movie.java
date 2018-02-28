package com.simple.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

/**
 * Created by songyigui on 2018/2/28.
 */
@Document(indexName = "movie-store", type = "movie", shards = 1, replicas = 0)
public class Movie {
    @Id
    private Long id;

    private String name;

    @Field(type = FieldType.Nested)
    private List<Genre> genre;

    private Double rating;

    @Field(type = FieldType.Nested)
    private Director director;

    public Movie() {
    }

    public Movie(Long id, String name, List<Genre> genre, Double rating, Director director) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.rating = rating;
        this.director = director;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", rating=" + rating +
                ", director=" + director +
                '}';
    }
}
