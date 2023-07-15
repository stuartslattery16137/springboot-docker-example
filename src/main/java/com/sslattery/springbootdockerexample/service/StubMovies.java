package com.sslattery.springbootdockerexample.service;

import com.sslattery.springbootdockerexample.model.Movie;

import java.util.Arrays;
import java.util.List;

class StubMovies {

    static final List<Movie> movies = Arrays.asList(
            generateMovie("Blade Runner", 117),
            generateMovie("Blade Runner 2049", 163),
            generateMovie("Star Wars", 121));

    private static Movie generateMovie(String title, int runtime) {
        return Movie.builder().title(title).runtimeMinutes(runtime).build();
    }

}
