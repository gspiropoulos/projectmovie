package com.example.movieapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ResponseActivity extends AppCompatActivity {

    private final String url = "https://api.themoviedb.org/3/movie/popular?api_key=3545652a5f9a12aa802c1fadad60d345&language=en-US&page=1";
   private  String poster ;
    private String title;
    private String releaseDate;
    private String overview;
    private double vote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


//                    JsonResponse response = gson.fromJson(data, JsonResponse.class);

                    List<JsonResultsResponse> array=data.getResults();

                    for(JsonResultsResponse item : array){
                        String poster = item.getPoster_path();
                        String title = item.getTitle();
                        String  releaseDate = item.getRelease_date();
                        String overview = item.getOverview();
                        double vote = item.getVote_average();
                        movie.add(new MovieModel(poster, title, overview, releaseDate, vote));
                    }

//                    for (int i = 0; i <array.size(); i++) {
//                       String poster = data.getResults().get(i).getPoster_path();
//                        String title = data.getResults().get(i).getTitle();
//                        String  releaseDate = data.getResults().get(i).getRelease_date();
//                        String overview = data.getResults().get(i).getOverview();
//                        double vote = data.getResults().get(i).getVote_average();
//                        movie.add(new MovieModel(poster, title, releaseDate, overview, vote));
//                    }

                    movieAdapter.submitList(movie);

                }



                @Override
                public void onErrorResponse(String data) {

                }
            });




    }

//    private List<MovieModel> getMockUserList() {
//
//        List<MovieModel> movieList = new ArrayList<MovieModel>();
//
//        movieList.add(new MovieModel("Once Upon a Time in Holywood", "", "", "", 7.2));
//        return movieList;
//    }
}

