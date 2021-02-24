package com.example.movieapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(MovieModel data) {
        ImageView poster = itemView.findViewById(R.id.movieposter1);
        String url="http://image.tmdb.org/t/p/w500"+data.getPoster();
        Glide.with(itemView.getContext()).load(url).into(poster);


    }
}
