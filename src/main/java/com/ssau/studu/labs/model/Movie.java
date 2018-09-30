package com.ssau.studu.labs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIE")
public class Movie {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "MOVIE_TITLE")
  private String movieTitle;

  @Column(name = "INCEPTION_YEAR")
  private int inceptionYear;

  @Column(name = "COUNTRY")
  private String country;

  @Column(name = "DIRECTOR")
  private String director;

  @Column(name = "GENRE")
  private String genre;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getMovieTitle() {
    return movieTitle;
  }

  public void setMovieTitle(String movieTitle) {
    this.movieTitle = movieTitle;
  }

  public int getInceptionYear() {
    return inceptionYear;
  }

  public void setInceptionYear(int inceptionYear) {
    this.inceptionYear = inceptionYear;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  @Override
  public String toString() {
    return "Movie{" +
        "id=" + id +
        ", movieTitle='" + movieTitle + '\'' +
        ", inceptionYear=" + inceptionYear +
        ", country='" + country + '\'' +
        ", director='" + director + '\'' +
        ", genre='" + genre + '\'' +
        '}';
  }
}
