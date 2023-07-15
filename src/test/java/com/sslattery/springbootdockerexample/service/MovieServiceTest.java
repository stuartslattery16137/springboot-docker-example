package com.sslattery.springbootdockerexample.service;

import com.sslattery.springbootdockerexample.dao.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.openMocks;

class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    public void test() {
        MovieService movieService = new MovieService(movieRepository);
    }
}