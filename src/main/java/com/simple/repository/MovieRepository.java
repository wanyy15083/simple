package com.simple.repository;

import com.simple.model.Director;
import com.simple.model.Movie;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songyigui on 2018/2/28.
 */
@Repository
public interface MovieRepository extends ElasticsearchRepository<Movie, Long> {
    List<Movie> findByName(String name);
    List<Movie> findByRatingBetween(Double start, Double end);
    List<Movie> findByDirector(Director director);
}
