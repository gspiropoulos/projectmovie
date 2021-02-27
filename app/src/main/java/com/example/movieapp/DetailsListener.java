package com.example.movieapp;

public interface DetailsListener {
    void onSuccessResponse(JsonResultsResponse data);

    void onErrorResponse(String data);
}
