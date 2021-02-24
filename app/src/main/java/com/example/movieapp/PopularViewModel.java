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
    private final String url="https://api.themoviedb.org/3/movie/popular?api_key=3545652a5f9a12aa802c1fadad60d345&language=en-US&page=1";
    @NonNull
    private RequestQueue queue;

    public PopularViewModel (@NonNull Application application) {
        super(application);
        queue = Volley.newRequestQueue(application);
    }

    void retrieveData(PopularListener popular) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                   public void onResponse(String response) {
//
//
                        Gson gson = new Gson();

                        JsonResponse response1 = gson.fromJson(response, JsonResponse.class);
//                        String strResponse = gson.toJson(response1);

                        popular.onSuccessResponse(response1);
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



    @Override
    protected void onCleared() {
        super.onCleared();
    }
}


