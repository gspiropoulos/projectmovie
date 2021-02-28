package com.example.movieapp;

import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

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

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

public class SearchViewModel extends AndroidViewModel {
    private String query;
    private String query1;
    private int page;
    String url;
    @NonNull
    private RequestQueue queue;

    public SearchViewModel(@NonNull Application application) {
        super(application);
        queue = Volley.newRequestQueue(application);
        page=0;
       url= "https://api.themoviedb.org/3/search/movie?api_key=3545652a5f9a12aa802c1fadad60d345&query=";
    }




    void retrieveData(String query,SearchListener search) {
        page=page +1;
             url = url +"&query=" + Uri.encode(query) + "&page=" + page;



        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Gson gson = new Gson();

                        JsonResponse responseS = gson.fromJson(response,JsonResponse.class);
                        if(responseS.getTotal_results()==0 || responseS.getTotal_results()<0){
                            Toast toast = Toast.makeText(getApplication(), "No results found", Toast.LENGTH_LONG);
                            toast.show();
                        }
                        search.onSuccessResponse(responseS);
                        if(page<=responseS.getTotal_pages()){retrieveData(query,search);}
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
