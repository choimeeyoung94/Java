package chap06_gson;

import java.util.List;

public class Movie {
  private String director;
  private String title;
  private List<String> actors;
  private double stars;
  
  public Movie() {
    
  }

  public Movie(String director, String title, List<String> actors, double stars) {
    this.director = director;
    this.title = title;
    this.actors = actors;
    this.stars = stars;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<String> getActors() {
    return actors;
  }

  public void setActors(List<String> actors) {
    this.actors = actors;
  }

  public double getStars() {
    return stars;
  }

  public void setStars(double stars) {
    this.stars = stars;
  }

  @Override
  public String toString() {
    return "Movie [director=" + director + ", title=" + title + ", actors=" + actors + ", stars=" + stars + "]";
  }
}
