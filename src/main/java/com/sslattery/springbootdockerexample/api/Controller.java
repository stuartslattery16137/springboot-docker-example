package com.sslattery.springbootdockerexample.api;

import com.sslattery.springbootdockerexample.model.Movie;
import com.sslattery.springbootdockerexample.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/controller/")
public class Controller {

    private final MovieService movieService;

    public Controller(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello there";
    }

    @GetMapping("/movies")
    public List<Movie> getMovies(){
        return movieService.getAllMovies();
    }

    @PostMapping("/movie")
    public void saveMovie(@RequestBody Movie movie) {
        movieService.saveMovie(movie);
    }
}
