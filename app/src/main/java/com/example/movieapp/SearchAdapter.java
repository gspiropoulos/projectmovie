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

import com.example.movieapp.DiffUtilsItems;
import com.example.movieapp.ItemClickListener;
import com.example.movieapp.MovieDetailsActivity;
import com.example.movieapp.MovieModel;
import com.example.movieapp.R;

import java.util.Locale;

public class SearchAdapter extends ListAdapter<MovieModel, SearchViewHolder> {


    public SearchAdapter() {
        super(new DiffUtilsItems());
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_poster, parent, false);

        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        MovieModel movieModel = getItem(position);
        holder.bind(movieModel);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(v.getContext(), MovieDetailsActivity.class);
                Bundle parameter = new Bundle();
                ImageView img = v.findViewById(R.id.poster);
                int id = getItem(position).getiD();
                Log.d("Click", String.valueOf(id));
                parameter.putInt("Movie id", id);
                intent.putExtras(parameter);
                v.getContext().startActivity(intent);
            }
        });

    }



}