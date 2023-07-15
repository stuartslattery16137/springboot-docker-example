package com.sslattery.springbootdockerexample.dao;

import com.sslattery.springbootdockerexample.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
