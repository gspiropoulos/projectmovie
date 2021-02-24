package com.example.movieapp;

import java.util.List;
import java.util.Objects;

public class JsonResultsResponse {
    private String title;
    private  String poster_path;
    private String release_date;
    private String overview;
    private double vote_average;





    public String getTitle() {
        return title;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getVote_average() {
        return vote_average;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JsonResultsResponse)) return false;
        JsonResultsResponse that = (JsonResultsResponse) o;
        return
                Objects.equals(title, that.title) &&
                Objects.equals(poster_path, that.poster_path) &&
                Objects.equals(release_date, that.release_date) &&
                Objects.equals(overview, that.overview) &&
                Objects.equals(vote_average, that.vote_average);
    }

    @Override
    public int hashCode() {
        return Objects.hash( title, poster_path, release_date, overview, vote_average);
    }

    @Override
    public String toString() {
        return "JsonResultsResponse{" +
                "genre_ids=" +
                ", title='" + title + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", release_date='" + release_date + '\'' +
                ", overview='" + overview + '\'' +
                ", vote_average='" + vote_average + '\'' +
                '}';
    }


}
