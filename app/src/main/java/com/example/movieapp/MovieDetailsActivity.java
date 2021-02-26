package com.example.movieapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;


import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailsActivity extends AppCompatActivity {
    private int movieId;
    private String MOVIE_DETAILS_URL;
    MovieDetailsModel movie = new MovieDetailsModel();
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_card);
        Intent intent = getIntent();
        Bundle parameters = getIntent().getExtras();


        int id = parameters.getInt("Movie id");
        String url = setMovieId(id);
        ArrayList<MovieModel> details = new ArrayList<>();

        DetailsViewModel detailsViewModel = new ViewModelProvider(this).get(DetailsViewModel.class);

        detailsViewModel.retrieveData(url, new DetailsListener() {
            @Override
            public void onSuccessResponse(JsonResponse2 data) {
                String poster = data.getPoster_path();

                String overview = data.getOverview();
                double vote = data.getVote_average();
                int runtime = data.getRuntime();
                ImageView poster1 = findViewById(R.id.movieposter);
                String url = "http://image.tmdb.org/t/p/w500" + poster;
                Glide.with(getApplicationContext()).load(url).into(poster1);
                TextView textViewTitle = findViewById(R.id.title);
                textViewTitle.setText(data.getTitle());
                TextView year = findViewById(R.id.year);
                year.setText("Release date : " + "" + data.getRelease_date());
                TextView duration = findViewById(R.id.duration);
                duration.setText("Runtime :" + "" + data.getRuntime());

                TextView synopsis = findViewById(R.id.synopsis);
                synopsis.setText("Synopsis:" + "/" + data.getOverview());
            }

            @Override
            public void onErrorResponse(String data) {

            }


        });


    }


    private String setMovieId(int movieId) {
        this.movieId = movieId;

        return MOVIE_DETAILS_URL = "https://api.themoviedb.org/3/movie/" + movieId + "h?api_key=3545652a5f9a12aa802c1fadad60d345&language=en-US";
    }
}







