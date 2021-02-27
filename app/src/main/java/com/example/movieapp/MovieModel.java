package com.example.movieapp;

import java.util.Objects;

public class MovieModel {
    private String poster;
    private String title;
    private String overview;
    private String year;
    private float vote;
    private int iD;

    public MovieModel(String poster, String title, String overview,  String year, float vote , int iD) {
        this.poster = poster;
        this.vote=vote;
        this.title = title;
        this.overview = overview;
        this.year = year;
        this.iD=iD;
    }

    public int getiD() {
        return iD;
    }

    public float getVote() {
        return vote;
    }

    public void setVote(float vote) {
        this.vote = vote;
    }

    public void setiD(int iD) {
        this.iD = iD;
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
                iD == that.iD &&
                Objects.equals(poster, that.poster) &&
                Objects.equals(title, that.title) &&
                Objects.equals(overview, that.overview) &&
                Objects.equals(year, that.year);
    }

    @Override
    public String toString() {
        return "MovieModel{" +
                "poster='" + poster + '\'' +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", year='" + year + '\'' +
                ", vote=" + vote +
                ", iD=" + iD +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(poster, title, overview, year, vote, iD);
    }

}
