package com.example.movieapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(MovieModel data) {
        ImageView poster = itemView.findViewById(R.id.movieposter1);
        String url=" https://image.tmdb.org/t/p/w185"+data.getPoster();
        Picasso.get().load(url).into(poster);

        //poster.setText(movieModel.getPoster());
    }
}
