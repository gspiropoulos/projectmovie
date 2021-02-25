package com.example.movieapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;

public class MovieAdapter extends ListAdapter<MovieModel, MovieViewHolder> {


    public MovieAdapter() {
        super(new DiffUtilsItems());
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_poster, parent, false);

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MovieModel movieModel = getItem(position);
        holder.bind(movieModel);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(v.getContext(), MovieDetailsActivity.class);
                Bundle parameter = new Bundle();
                ImageView img=v.findViewById(R.id.movieposter1);
                int id = getItem(position).getiD();
                Log.d("Click", String.valueOf(id));
                parameter.putInt("Movie id", id);
                intent.putExtras(parameter);
                v.getContext().startActivity(intent);
            }
        });

    }
}
