package com.example.elashry.elatheer.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.elashry.elatheer.Activites.Details_News;
import com.example.elashry.elatheer.Activites.News;
import com.example.elashry.elatheer.Models.NewsFeeds;
import com.example.elashry.elatheer.NetworkController;
import com.example.elashry.elatheer.R;

import java.util.List;

/**
 * Created by AndroidNovice on 6/5/2016.
 */
public class Adapternews extends RecyclerView.Adapter<Adapternews.MyViewHolder> implements View.OnClickListener{

    private List<NewsFeeds> feedsList;
    private Context context;
    News news;

    private LayoutInflater inflater;

    public Adapternews(Context context, List<NewsFeeds> feedsList,News news) {

        this.context = context;
        this.feedsList = feedsList;
        this.news = news;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = inflater.inflate(R.layout.item_news, parent, false);
        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NewsFeeds feeds = feedsList.get(position);
        //Pass the values of feeds object to Views
        holder.cardView.setTag(position);

        holder.content.setText(feeds.getContent_new());
        holder.title.setText(feeds.getTitle_new());

        holder.date.setText(feeds.getDate_new());

    }

    @Override
    public int getItemCount() {
        return feedsList.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cardView;

        private TextView content, title,date;

        public MyViewHolder(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.content);
            title = (TextView) itemView.findViewById(R.id.title);
            date = (TextView) itemView.findViewById(R.id.date);
            cardView = (CardView) itemView.findViewById(R.id.Card);

            cardView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {

                    int position = (int) view.getTag();

                    NewsFeeds   feeds = feedsList.get(position);

                    Intent intent = new Intent(news, Details_News.class);

                    intent.putExtra("title", feeds.getTitle_new());
                    intent.putExtra("content", feeds.getContent_new());
                    intent.putExtra("date", feeds.getDate_new());

                    news.startActivity(intent);



        }
    }

}