package edu.uci.ics.fabflixmobile;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String id;
    private String title;
    private int year;
    private String director;
    private List<String> genres = new ArrayList<>();
    private List<String> actors = new ArrayList<>();

    public Movie() {

    }

    public Movie(String id, String title, int year, String director, ArrayList<String> genres) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.director = director;
        this.genres = genres;
    }

    public String getId() {
        return id;
    }

    public void setId(String newId) {
        id = newId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int newYear) {
        year = newYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String newDirector) {
        director = newDirector;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void addGenre(String genre) {
        genres.add(genre);
    }

    public List<String> getActors() {
        return actors;
    }

    public void addActor(String actor) {
        actors.add(actor);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Movie Details - ");
        sb.append("Id: " + getId());
        sb.append(", ");
        sb.append("Title: " + getTitle());
        sb.append(", ");
        sb.append("Year: " + getYear());
        sb.append(", ");
        sb.append("Director: " + getDirector());
        sb.append(", ");
        sb.append("Genres: " + genres.toString());
        sb.append(".");

        return sb.toString();

    }
}
