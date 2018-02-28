package com.simple.web;

import com.simple.model.Movie;
import com.simple.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by songyigui on 2018/2/28.
 */
@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/movie/add")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie newMovie) {
        Movie savedMovie = movieService.addMovie(newMovie);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(savedMovie.getId()).toUri();
        return ResponseEntity.ok(savedMovie).created(location).build();
    }

    @DeleteMapping("/movie/{id}/delete")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long movieId) {
        movieService.deleteMovie(movieId);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/movie/get-by-name")
    public ResponseEntity<List<Movie>> findMovieByName(@RequestParam("name") String movieName) {
        List<Movie> fetchedMovie = movieService.getByName(movieName);
        return ResponseEntity.ok(fetchedMovie);
    }
}
