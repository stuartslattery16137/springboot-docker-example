package com.sslattery.springbootdockerexample.api;

import com.sslattery.springbootdockerexample.model.Movie;
import com.sslattery.springbootdockerexample.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomUtils.nextInt;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ControllerTest {

    private MockMvc mvc;

    private Controller testee;

    @Mock
    private MovieService movieService;

    @BeforeEach
    void setUp() {
        openMocks(this);
        testee = new Controller(movieService);
        mvc = MockMvcBuilders.standaloneSetup(testee).build();
    }

    @Test
    void getsMovies() throws Exception {
        Movie movie = new Movie(nextInt(), randomAlphanumeric(10), nextInt());
        when(movieService.getAllMovies()).thenReturn(Collections.singletonList(movie));

         mvc.perform(get("/api/v1/controller/movies"))
                 .andDo(print())
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("[0].id", is(movie.getId())))
                 .andExpect(jsonPath("[0].title",  is(movie.getTitle())))
                 .andExpect(jsonPath("[0].runtimeMinutes", is(movie.getRuntimeMinutes())));

    }
}
