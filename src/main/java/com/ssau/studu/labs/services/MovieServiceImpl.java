package com.ssau.studu.labs.services;

import com.ssau.studu.labs.dao.MovieDao;
import com.ssau.studu.labs.model.Movie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

  private MovieDao movieDao;

  @Override
  @Transactional
  public void addMovie(Movie movie) {
    movieDao.addMovie(movie);
  }

  @Override
  @Transactional
  public void updateMovie(Movie movie) {
    movieDao.updateMovie(movie);
  }

  @Override
  @Transactional
  public void removeMovie(int id) {
    movieDao.removeMovie(id);
  }

  @Override
  @Transactional
  public Movie getMovieById(int id) {
    return movieDao.getMovieById(id);
  }

  @Override
  @Transactional
  public List<Movie> getMovieList() {
    return movieDao.getMovieList();
  }

  public void setMovieDao(MovieDao movieDao) {
    this.movieDao = movieDao;
  }
}
