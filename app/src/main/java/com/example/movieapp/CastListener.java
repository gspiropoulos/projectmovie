package com.example.movieapp;

public interface CastListener {
    void onSuccessResponse(JsonCastR data);

    void onErrorResponse(String data);
}
