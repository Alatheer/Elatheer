package com.example.elashry.elatheer.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.elashry.elatheer.Activites.Details_News;
import com.example.elashry.elatheer.Activites.News;
import com.example.elashry.elatheer.Activites.media;
import com.example.elashry.elatheer.Models.DesignModel;
import com.example.elashry.elatheer.Models.NewsFeeds;
import com.example.elashry.elatheer.NetworkController;
import com.example.elashry.elatheer.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by AndroidNovice on 6/5/2016.
 */
public class AdapterDept extends RecyclerView.Adapter<AdapterDept.MyViewHolder> {

    private List<DesignModel> designList;
    private Context context;
    media media;

    private LayoutInflater inflater;

    public AdapterDept(Context context, List<DesignModel> designList,media media) {

        this.context = context;
        this.designList = designList;
        this.media = media;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = inflater.inflate(R.layout.design_item, parent, false);
        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DesignModel feeds = designList.get(position);
        //Pass the values of feeds object to Views
      //  holder.cardView.setTag(position);

        holder.title.setText(feeds.getDtitle());

     //   holder.date.setText(feeds.getDimage());
        Picasso.with(context).load("https://alatheertech.com/uploads/images/"+feeds.getDimage()).into(holder.designimg);

    }

    @Override
    public int getItemCount() {
        return designList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
      //  CardView cardView;

        private TextView title;
        private ImageView designimg;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.titledesign);
            designimg=(ImageView) itemView.findViewById(R.id.imgdesign);
        //    cardView = (CardView) itemView.findViewById(R.id.Card);

//            cardView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {




        }
    }

}