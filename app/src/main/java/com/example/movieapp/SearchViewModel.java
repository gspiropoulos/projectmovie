package com.example.movieapp;

import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.movieapp.JsonResponse;
import com.example.movieapp.JsonResultsResponse;
import com.example.movieapp.SearchListener;
import com.google.gson.Gson;

import java.lang.reflect.Type;

public class SearchViewModel extends AndroidViewModel {
    private String query;

    @NonNull
    private RequestQueue queue;

    public SearchViewModel(@NonNull Application application) {
        super(application);
        queue = Volley.newRequestQueue(application);
    }




    void retrieveData(String query,SearchListener search) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://api.themoviedb.org/3/search/movie?api_key=3545652a5f9a12aa802c1fadad60d345&query=" + Uri.encode(query)  + "&page=1&include_adult=false",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        Gson gson = new Gson();

                        JsonResponse responseS = gson.fromJson(response,JsonResponse.class);


                        search.onSuccessResponse(responseS);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        search.onErrorResponse("That didn't work!");

                    }
                });


        queue.add(stringRequest);
    }


}
