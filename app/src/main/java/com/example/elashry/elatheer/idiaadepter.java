package com.example.elashry.elatheer;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class idiaadepter extends RecyclerView.Adapter<idiaadepter.IndanMovieHolder> {

    List<idieslist> moviesList ;

    public idiaadepter(List<idieslist> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public IndanMovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.idieaitem,parent,false);
        IndanMovieHolder holder = new IndanMovieHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(IndanMovieHolder holder, int position) {

        idieslist movie = moviesList.get(position);
        holder.movietitle.setText(movie.movieName);
        holder.moviedesc.setText(movie.movieStory);
        holder.movierate.setText(movie.movieRate);
        holder.poster.setImageResource(movie.posterImage);

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    class IndanMovieHolder extends RecyclerView.ViewHolder {
        TextView movietitle,movierate,moviedesc ;
        ImageView poster;

        public IndanMovieHolder(View itemView) {
            super(itemView);
            movietitle = (TextView) itemView.findViewById(R.id.movietitleTV);
            movierate = (TextView) itemView.findViewById(R.id.movieratTV);
            moviedesc = (TextView) itemView.findViewById(R.id.moviedescTV);
            poster = (ImageView) itemView.findViewById(R.id.movieposteIMG);
        }
    }

}



