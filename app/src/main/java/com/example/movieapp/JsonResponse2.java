package com.example.movieapp;

import java.util.Objects;

public class JsonResponse2 {
 private String poster_path;
 private String release_date;
 private int runtime;
 private String title;
 private double vote_average;
 private String overview;

 public String getPoster_path() {
  return poster_path;
 }

 public void setPoster_path(String poster_path) {
  this.poster_path = poster_path;
 }

 public String getOverview() {
  return overview;
 }

 public void setOverview(String overview) {
  this.overview = overview;
 }

 public String getRelease_date() {
  return release_date;
 }

 public void setRelease_date(String release_date) {
  this.release_date = release_date;
 }

 public int getRuntime() {
  return runtime;
 }

 public void setRuntime(int runtime) {
  this.runtime = runtime;
 }

 public String getTitle() {
  return title;
 }

 public void setTitle(String title) {
  this.title = title;
 }

 public double getVote_average() {
  return vote_average;
 }

 @Override
 public boolean equals(Object o) {
  if (this == o) return true;
  if (!(o instanceof JsonResponse2)) return false;
  JsonResponse2 that = (JsonResponse2) o;
  return runtime == that.runtime &&
          Double.compare(that.vote_average, vote_average) == 0 &&
          Objects.equals(poster_path, that.poster_path) &&
          Objects.equals(release_date, that.release_date) &&
          Objects.equals(title, that.title) &&
          Objects.equals(overview, that.overview);
 }

 @Override
 public int hashCode() {
  return Objects.hash(poster_path, release_date, runtime, title, vote_average, overview);
 }

 @Override
 public String toString() {
  return "JsonResponse2{" +
          "poster_path='" + poster_path + '\'' +
          ", release_date='" + release_date + '\'' +
          ", runtime=" + runtime +
          ", title='" + title + '\'' +
          ", vote_average=" + vote_average +
          ", overview='" + overview + '\'' +
          '}';
 }

 public void setVote_average(double vote_average) {
  this.vote_average = vote_average;
 }
}
