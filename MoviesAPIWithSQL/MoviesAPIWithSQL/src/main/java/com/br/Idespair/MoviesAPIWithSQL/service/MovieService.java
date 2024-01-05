package com.br.Idespair.MoviesAPIWithSQL.service;

import com.br.Idespair.MoviesAPIWithSQL.model.Movie;
import com.br.Idespair.MoviesAPIWithSQL.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private IMovieRepository movieRepository;

    public List<Movie> AllMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }

}
