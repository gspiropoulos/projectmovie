package com.example.movieapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saearch_act);
        setSupportActionBar(findViewById(R.id.search));
        Intent intent = getIntent();
        Bundle parameters = getIntent().getExtras();
        String query = parameters.getString("Search");


        RecyclerView sRecyclerView = findViewById(R.id.recycler_s);
        SearchAdapter searchAdapter = new SearchAdapter();
        sRecyclerView.setAdapter(searchAdapter);
        ArrayList<MovieModel> movie = new ArrayList<>();


        SearchViewModel searchViewModel = new ViewModelProvider(this).get(SearchViewModel.class);

        searchViewModel.retrieveData(query, new SearchListener() {
            @Override
            public void onSuccessResponse(JsonResponse data) {

                List<JsonResultsResponse> array = data.getResults();

                for (JsonResultsResponse item : array) {
                    String poster = item.getPoster_path();
                    String title = item.getTitle();
                    String releaseDate = item.getRelease_date();
                    String overview = item.getOverview();
                    float vote = item.getVote_average();
                    int id = item.getId();
                    movie.add(new MovieModel(poster, title, overview, releaseDate, vote, id));
                }

                searchAdapter.submitList(movie);

            }


            @Override
            public void onErrorResponse(String data) {

            }
        });
    }
}
