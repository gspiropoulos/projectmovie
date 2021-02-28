package com.example.movieapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class PopularViewModel extends AndroidViewModel {
    private  String url="https://api.themoviedb.org/3/movie/popular?api_key=3545652a5f9a12aa802c1fadad60d345&language=en-US";
    @NonNull
    private RequestQueue queue;
    private int page;

    public PopularViewModel (@NonNull Application application) {
        super(application);
        queue = Volley.newRequestQueue(application);
        page=0;
        url="https://api.themoviedb.org/3/movie/popular?api_key=3545652a5f9a12aa802c1fadad60d345&language=en-US";
    }

    void retrieveData(PopularListener popular) {

        page = page + 1;
         url = url + "&page=" + page;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                   public void onResponse(String response) {


                        Gson gson = new Gson();

                        JsonResponse response1 = gson.fromJson(response, JsonResponse.class);

                        popular.onSuccessResponse(response1);
                        if(page<=response1.getTotal_pages()){retrieveData(popular);}
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        popular.onErrorResponse("That didn't work!");

                    }
                });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
    void retrieveDataDetails(String url ,DetailsListener details) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        Gson gson = new Gson();

                        JsonResultsResponse response2 = gson.fromJson(response, JsonResultsResponse.class);

                        details.onSuccessResponse(response2);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        details.onErrorResponse("That didn't work!");

                    }
                });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }






    @Override
    protected void onCleared() {
        super.onCleared();
    }
}


