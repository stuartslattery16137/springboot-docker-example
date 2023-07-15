package com.sslattery.springbootdockerexample.service;

import com.sslattery.springbootdockerexample.dao.MovieRepository;
import com.sslattery.springbootdockerexample.model.Movie;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;

        movieRepository.saveAll(StubMovies.movies);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }
}
