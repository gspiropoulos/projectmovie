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
import android.widget.ImageButton;
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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
        toolbar.setNavigationIcon(R.drawable.abc_vector_test);
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
                if(data.getPoster_path()!=null){

                    String url = "http://image.tmdb.org/t/p/w500" + poster;
                Glide.with(getApplicationContext()).load(url).into(poster1);}
                TextView textViewTitle = findViewById(R.id.title);
                if(data.getTitle()!=null){
                textViewTitle.setText("Title :" + data.getTitle());}
                TextView year = findViewById(R.id.year);
                if(data.getRelease_date()!=null){
                year.setText("Release date : " + "" + data.getRelease_date());}
                TextView duration = findViewById(R.id.duration);
                if(data.getRuntime()!=0){
                duration.setText("Runtime :" + "" + data.getRuntime() + "min");}
                TextView synopsis = findViewById(R.id.synopsis);
                if(data.getOverview()!=null){
                synopsis.setText("Synopsis:" + "" + data.getOverview());}
                TextView rate = findViewById(R.id.rate);
                if(data.getVote_average()!=0){
                rate.setText("Rating :" + data.getVote_average() + "/10");}

                Button fab = findViewById(R.id.button);
                fab.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.themoviedb.org/movie/" + data.getId()));
                        v.getContext().startActivity(intent, null);
                    }
                });
                Button shareBtn = findViewById(R.id.share_button);
                shareBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_SEND);
                        intent.setType("text/plain"); // gia eikona "image/*"


                        intent.putExtra(Intent.EXTRA_TEXT, "https://www.themoviedb.org/movie/" + data.getId());
                        Intent shareIntent = Intent.createChooser(intent, null);
                        v.getContext().startActivity(shareIntent, null);
                    }
                });
            }
            @Override
            public void onErrorResponse(String data) {


            }


        });




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







