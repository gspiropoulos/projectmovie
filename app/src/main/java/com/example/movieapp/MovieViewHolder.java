package com.example.movieapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
   private ItemClickListener itemClickListener;
    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    public void bind(MovieModel data) {
        ImageView poster = itemView.findViewById(R.id.movieposter1);
        if(data.getPoster()!=null){

            String url="http://image.tmdb.org/t/p/w500"+data.getPoster();
        Glide.with(itemView.getContext()).load(url).into(poster);}

        TextView title=itemView.findViewById(R.id.title);
        if(data.getTitle()!=null){

            title.setText(data.getTitle());}

//        TextView date= itemView.findViewById(R.id.date);
//        if(data.getYear()!=null){
//
//            date.setText("Release date: "+   data.getYear());}


    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());
    }
    public void setItemClickListener(ItemClickListener pc){
        this.itemClickListener= pc;
    }
}
