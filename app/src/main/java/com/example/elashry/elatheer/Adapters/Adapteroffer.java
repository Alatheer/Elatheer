package com.example.elashry.elatheer.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.elashry.elatheer.Models.NewsFeeds;
import com.example.elashry.elatheer.NetworkController;
import com.example.elashry.elatheer.R;

import java.util.List;

/**
 * Created by AndroidNovice on 6/5/2016.
 */
public class Adapteroffer extends RecyclerView.Adapter<Adapteroffer.MyViewHolder> {

    private List<NewsFeeds> feedsList;
    private Context context;
    private LayoutInflater inflater;

    public Adapteroffer(Context context, List<NewsFeeds> feedsList) {

        this.context = context;
        this.feedsList = feedsList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = inflater.inflate(R.layout.item_offer, parent, false);
        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NewsFeeds feeds = feedsList.get(position);
        //Pass the values of feeds object to Views
        holder.imageview.setImageUrl("https://alatheertech.com/uploads/images/"+feeds.getImg(), NetworkController.getInstance(context).getImageLoader());

        holder.title.setText(feeds.getTitle());
        //     holder.content.setText(feeds.getContent());
    }

    @Override
    public int getItemCount() {
        return feedsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView content, title;
        private NetworkImageView imageview;
        private ProgressBar ratingbar;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageview = (NetworkImageView) itemView.findViewById(R.id.img);

            title = (TextView) itemView.findViewById(R.id.title);
            //    content = (TextView) itemView.findViewById(R.id.content_view);
            // Volley's NetworkImageView which will load Image from URL


        }
    }

}