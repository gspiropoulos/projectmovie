package com.example.movieapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;


import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
    private String detailsUrl;
    private String creditsUrl;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_card);
        Intent intent = getIntent();
        Bundle parameters = getIntent().getExtras();
        Toolbar toolbar = (Toolbar) findViewById(R.id.topAppBar2);
        toolbar.setNavigationIcon(R.drawable.abc_vector_test); // your drawable
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        int id = parameters.getInt("Movie id");
        detailsUrl = setMovieId(id);
        creditsUrl = setCastUrl(id);


        PopularViewModel detailsViewModel = new ViewModelProvider(this).get(PopularViewModel.class);

        detailsViewModel.retrieveDataDetails(detailsUrl, new DetailsListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onSuccessResponse(JsonResultsResponse data) {
                String poster = data.getPoster_path();
                ImageView poster1 = findViewById(R.id.movieposter);
                String url = "http://image.tmdb.org/t/p/w500" + poster;
                Glide.with(getApplicationContext()).load(url).into(poster1);
                TextView textViewTitle = findViewById(R.id.title);
                textViewTitle.setText("Title :" + data.getTitle());
                TextView year = findViewById(R.id.year);
                year.setText("Release date : " + "" + data.getRelease_date());
                TextView duration = findViewById(R.id.duration);
                duration.setText("Runtime :" + "" + data.getRuntime());
                TextView synopsis = findViewById(R.id.synopsis);
                synopsis.setText("Synopsis:" + "" + data.getOverview());
                TextView rate=findViewById(R.id.rate);
                rate.setText("Rating :" + data.getVote_average() +"/10");
                Button btn = findViewById(R.id.share_button);
                btn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.themoviedb.org/movie/" +data.getId()));
                        v.getContext().startActivity( intent, null);
                    }
                });
            }

            @Override
            public void onErrorResponse(String data) {


            }


        });


//        CastViewModel castViewModel = new ViewModelProvider(this).get(CastViewModel.class);
//        castViewModel.retrieveData(creditsUrl, new CastListener() {
//
//
//
//            @Override
//            public void onSuccessResponse(JsonCastR data) {
//                List<JsonResponseCast> array = data.getCast();
//                List<JsonResponseCrew> array2=data.getCrew();
//                 TextView director = findViewById(R.id.director);
//                TextView cast = findViewById(R.id.cast);
//                for (int i=0;i<array2.size();i++) {
//                    director1 =data.getCrew().get(i).getKnown_for_department();
//                    if (director1.contains("Directing") ) {
//                        director.setText("Director : " +data.getCast().get(i).getName());
//                    }
//
//                    }
//
//
//                }
//
//                @Override
//                public void onErrorResponse (String data){
//
//                }
//
//        });

    }
        private String setMovieId ( int movieId){
            this.movieId = movieId;

            return detailsUrl = "https://api.themoviedb.org/3/movie/" + movieId + "h?api_key=3545652a5f9a12aa802c1fadad60d345&language=en-US";
        }
        private String setCastUrl ( int movieId){
            this.movieId = movieId;
            return creditsUrl = "https://api.themoviedb.org/3/movie/" + movieId + "/credits?api_key=3545652a5f9a12aa802c1fadad60d345&language=en-US";
        }
    }







