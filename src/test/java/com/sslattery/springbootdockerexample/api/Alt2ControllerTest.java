package com.sslattery.springbootdockerexample.api;

import com.sslattery.springbootdockerexample.model.Movie;
import com.sslattery.springbootdockerexample.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Collections;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomUtils.nextInt;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Alt2ControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Value(value="${local.server.port}")
    private int port;

    @MockBean
    private MovieService movieService;

    @Test
    void getsMovies() {
        Movie movie = new Movie(nextInt(), randomAlphanumeric(10), nextInt());
        when(movieService.getAllMovies()).thenReturn(Collections.singletonList(movie));

        assertThat(restTemplate.getForObject("http://localhost:" + port + "/api/v1/controller/movies", String.class))
                .isEqualTo("[{" +
                        "\"id\":" + movie.getId() +"," +
                        "\"title\":\"" + movie.getTitle() +"\"," +
                        "\"runtimeMinutes\":"+ movie.getRuntimeMinutes() + "}]");
    }
}
