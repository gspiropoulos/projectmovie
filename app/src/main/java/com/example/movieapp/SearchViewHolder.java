package com.example.movieapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.ItemClickListener;
import com.example.movieapp.MovieModel;
import com.example.movieapp.R;




public class SearchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private ItemClickListener itemClickListener;
    public SearchViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    public void bind(MovieModel data) {
        ImageView poster = itemView.findViewById(R.id.poster);
        String url="http://image.tmdb.org/t/p/w500"+data.getPoster();
        Glide.with(itemView.getContext()).load(url).into(poster);
        TextView title=itemView.findViewById(R.id.poster_title);
        title.setText(data.getTitle());
        TextView year =itemView.findViewById(R.id.poster_year);
        year.setText(data.getYear());

    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());
    }
    public void setItemClickListener(ItemClickListener pc){
        this.itemClickListener= pc;
    }
}



