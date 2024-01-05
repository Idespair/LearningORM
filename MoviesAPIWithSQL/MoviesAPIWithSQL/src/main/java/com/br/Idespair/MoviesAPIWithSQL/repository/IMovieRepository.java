package com.br.Idespair.MoviesAPIWithSQL.repository;

import com.br.Idespair.MoviesAPIWithSQL.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface IMovieRepository extends JpaRepository<Movie,String> {

    Optional<Movie> findMovieByImdbId(String imdbId);

}
