package com.example.movieapp;
import java.io.Serializable;
public class MovieDetailsModel {
    public class Movie implements Serializable {


        private String image;
        private String title;
        private String rating;
        private String releaseDate;
        private String overview;
//        private ArrayList<Genre> genres = new ArrayList<>();
//        private Cast cast = new Cast();

        public Movie() {

        }

        public Movie(int id, String image, String title, String rating, String releaseDate) {

            this.title = title;
            this.rating = rating;
            this.releaseDate = releaseDate;

        }


        public String getImage() {
            return image;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getRating() {
            return rating;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getReleaseDate() {
            return releaseDate;
        }



        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

//        public void setGenres(ArrayList<Genre> genres) {
//            this.genres = genres;
//        }
//
//
//
//
//
//
//
//        public ArrayList<Genre> getGenres() {
//            return genres;
//        }
//
//
//
//
//
//        public void addGenre(Genre genre) {
//            genres.add(genre);
//        }
//
//        public void setCast(Cast cast) {
//            this.cast = cast;
//        }
//
//        public Cast getCast() {
//            return cast;
//        }
    }
}
