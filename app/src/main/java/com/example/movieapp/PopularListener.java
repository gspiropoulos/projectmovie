package com.example.movieapp;

public interface PopularListener {

    void onSuccessResponse(JsonResponse data);

    void onErrorResponse(String data);
}