package com.example.movieapp;

import com.example.movieapp.JsonResponse;
import com.example.movieapp.JsonResultsResponse;

public interface SearchListener {

    void onSuccessResponse(JsonResponse data);

    void onErrorResponse(String data);
}
