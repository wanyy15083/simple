package com.simple.service;

import com.simple.model.Director;
import com.simple.model.Movie;
import com.simple.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by songyigui on 2018/2/28.
 */
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getByName(String name) {
        return movieRepository.findByName(name);
    }

    public List<Movie> getByRatingInterval(Double start, Double end) {
        return movieRepository.findByRatingBetween(start, end);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.delete(id);
    }

    public List<Movie> findByDirector(Director director) {
        return movieRepository.findByDirector(director);
    }
}
