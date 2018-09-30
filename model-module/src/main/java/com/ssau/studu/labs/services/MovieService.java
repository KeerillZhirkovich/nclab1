package com.ssau.studu.labs.services;

import com.ssau.studu.labs.model.Movie;

import java.util.List;

public interface MovieService {

  void addMovie(Movie movie);

  void updateMovie(Movie movie);

  void removeMovie(int id);

  Movie getMovieById(int id);

  List<Movie> getMovieList();
}
