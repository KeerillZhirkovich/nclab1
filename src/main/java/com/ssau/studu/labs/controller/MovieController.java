package com.ssau.studu.labs.controller;

import com.ssau.studu.labs.model.Movie;
import com.ssau.studu.labs.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MovieController {

  private final String MOVIE = "movie";
  private final String MOVIES = "movies";
  private final String LIST_MOVIES = "listMovies";
  private final String ID = "id";
  private final String REDIRECT_MOVIES = "redirect:/movies";

  private MovieService movieService;

  @Autowired
  @Qualifier(value = "movieService")
  public void setMovieService(MovieService movieService) {
    this.movieService = movieService;
  }

  @RequestMapping(value = MOVIES, method = RequestMethod.GET)
  public String listMovies(Model model) {
    model.addAttribute(MOVIE, new Movie());
    model.addAttribute(LIST_MOVIES, movieService.getMovieList());

    return "movies";
  }

  @RequestMapping(value = "/movies/add", method = RequestMethod.POST)
  public String addMovie(@ModelAttribute(MOVIE) Movie movie) {
    if (movie.getId() == 0) {
      movieService.addMovie(movie);
    } else {
      movieService.updateMovie(movie);
    }

    return REDIRECT_MOVIES;
  }

  @RequestMapping(value = "/remove/{id}")
  public String removeMovie(@PathVariable(ID) int id) {
    movieService.removeMovie(id);

    return REDIRECT_MOVIES;
  }

  @RequestMapping(value = "/edit/{id}")
  public String editMovie(@PathVariable(ID) int id, Model model) {
    model.addAttribute(MOVIE, movieService.getMovieById(id));
    model.addAttribute(LIST_MOVIES, movieService.getMovieList());

    return MOVIES;
  }

  @RequestMapping(value = "moviedata/{id}")
  public String movieData(@PathVariable(ID) int id, Model model) {
    model.addAttribute(MOVIE, movieService.getMovieById(id));

    return "moviedata";
  }
}
