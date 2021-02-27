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


    public class CastViewModel extends AndroidViewModel {

        @NonNull
        private RequestQueue queue;

        public CastViewModel (@NonNull Application application) {
            super(application);
            queue = Volley.newRequestQueue(application);
        }

        void retrieveData(String url ,CastListener details) {

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {


                            Gson gson = new Gson();

                            JsonCastR response3 = gson.fromJson(response, JsonCastR.class);

                            details.onSuccessResponse(response3);
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

