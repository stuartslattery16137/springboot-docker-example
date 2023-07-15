package com.sslattery.springbootdockerexample.dao;

import com.sslattery.springbootdockerexample.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomUtils.nextInt;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MovieRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void movieRepoBeanIsAvailable(){
        assertThat(movieRepository).isNotNull();
    }

    @Test
    void storeAndRetrieveMovie() {
        Movie movie = new Movie();
//        movie.setId(nextInt());  <-- need to ensure that we don't manually change the ID either via setter or constructor
        movie.setTitle(randomAlphanumeric(10)); // since it is supposed to be auto generated it causes issues
        movie.setRuntimeMinutes(nextInt());

        movieRepository.save(movie);

        List<Movie> movies = movieRepository.findAllById(singletonList(movie.getId()));
        assertThat(movies).contains(movie);
    }
}