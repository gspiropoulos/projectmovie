package com.example.movieapp;

public interface DetailsListener {
    void onSuccessResponse(JsonResponse2 data);

    void onErrorResponse(String data);
}
