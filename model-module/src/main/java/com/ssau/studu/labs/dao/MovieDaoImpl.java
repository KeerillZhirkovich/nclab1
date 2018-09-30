package com.ssau.studu.labs.dao;

import com.ssau.studu.labs.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDaoImpl implements MovieDao {

  private final String COULD_NOT_FIND_MOVIE_BY_ID
      = "Could not find movie by ID: ";

  private final Logger logger = LoggerFactory.getLogger(MovieDaoImpl.class);

  private SessionFactory sessionFactory;

  @Override
  public void addMovie(Movie movie) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(movie);
    logger.info("Movie successfully added: " + movie);
  }

  @Override
  public void updateMovie(Movie movie) {
    Session session = sessionFactory.getCurrentSession();
    session.update(movie);
    logger.info("Movie successfully updated: " + movie);
  }

  @Override
  public void removeMovie(int id) {
    Session session = sessionFactory.getCurrentSession();
    Movie movie = (Movie) session.load(Movie.class, id);

    if (movie != null) {
      session.delete(movie);
      logger.info("Movie successfully removed: " + movie);
    } else {
      logger.info(COULD_NOT_FIND_MOVIE_BY_ID  + id );
    }
  }

  @Override
  public Movie getMovieById(int id) {
    Session session = sessionFactory.getCurrentSession();
    Movie movie = (Movie) session.load(Movie.class, id);

    if (movie != null) {
      logger.info("Movie successfully removed: " + movie);
    } else {
      logger.info(COULD_NOT_FIND_MOVIE_BY_ID + id );
    }

    return movie;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Movie> getMovieList() {
    Session session = sessionFactory.getCurrentSession();
    List<Movie> movieList
        = (List<Movie>) session.createQuery("from BOOK").list();

    for (Movie movie : movieList) {
      logger.info("Movie: " + movie);
    }

    return movieList;
  }

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }
}
