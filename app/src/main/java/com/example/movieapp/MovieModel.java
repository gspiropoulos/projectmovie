package com.example.movieapp;

import java.util.Objects;

public class MovieModel {
    private String poster;
    private String title;
    private String overview;
    private String year;
    private double vote;

    public MovieModel(String poster, String title, String overview,  String year, double vote) {
        this.poster = poster;

        this.title = title;
        this.overview = overview;
        this.year = year;
    }

    public double getVote() {
        return vote;
    }

    public void setVote(double vote) {
        this.vote = vote;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String duration) {
        this.overview = duration;
    }


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieModel)) return false;
        MovieModel that = (MovieModel) o;
        return Double.compare(that.vote, vote) == 0 &&
                Objects.equals(poster, that.poster) &&
                Objects.equals(title, that.title) &&
                Objects.equals(overview, that.overview) &&
                Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(poster, title, overview, year, vote);
    }

    @Override
    public String toString() {
        return "MovieModel{" +
                "poster='" + poster + '\'' +
                ", title='" + title + '\'' +
                ", duration='" + overview + '\'' +
                ", year='" + year + '\'' +
                ", vote=" + vote +
                '}';
    }
}
