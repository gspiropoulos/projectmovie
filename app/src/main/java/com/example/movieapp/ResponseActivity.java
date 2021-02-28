package com.example.movieapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;

import android.view.Menu;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.internal.bind.util.ISO8601Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class ResponseActivity extends AppCompatActivity {
    SearchView searchView;

    private String poster;
    private String title;
    private String releaseDate;
    private String overview;
    private double vote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.topAppBar));
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        RecyclerView mvRecyclerView = findViewById(R.id.recycler);
        MovieAdapter movieAdapter = new MovieAdapter();
        mvRecyclerView.setAdapter(movieAdapter);
        ArrayList<MovieModel> movie = new ArrayList<>();


        PopularViewModel popularViewModel = new ViewModelProvider(this).get(PopularViewModel.class);

        popularViewModel.retrieveData(new PopularListener() {
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

                movieAdapter.submitList(movie);

            }


            @Override
            public void onErrorResponse(String data) {

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_app_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setQueryHint("Search Movie");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(ResponseActivity.this, SearchResultActivity.class);
                Bundle parameter = new Bundle();
                parameter.putString("Search", query);
                intent.putExtras(parameter);
                startActivity(intent);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                return false;
            }
        });
        return super.onPrepareOptionsMenu(menu);
    }
}

