package com.example.elashry.elatheer.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elashry.elatheer.Activites.Fahrasa;
import com.example.elashry.elatheer.Activites.WhyAtheer;
import com.example.elashry.elatheer.Models.AdsModel;
import com.example.elashry.elatheer.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by AndroidNovice on 6/5/2016.
 */
public class AdapterAds extends RecyclerView.Adapter<AdapterAds.MyViewHolder> {

    private List<AdsModel> adsmodel;
    private Context context;
    WhyAtheer whyatheer;

    private LayoutInflater inflater;

    public AdapterAds(Context context, List<AdsModel> adsmodel, WhyAtheer whyatheer) {

        this.context = context;
        this.adsmodel = adsmodel;
        this.whyatheer = whyatheer;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = inflater.inflate(R.layout.ads_item, parent, false);
        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        AdsModel feeds = adsmodel.get(position);
        //Pass the values of feeds object to Views
      //  holder.cardView.setTag(position);

        holder.content.setText(feeds.getAdscontent());
        holder.title.setText(feeds.getAdsTitle());

     //   holder.date.setText(feeds.getDimage());
        Picasso.with(context).load("https://alatheertech.com/uploads/images/"+feeds.getAdsimage()).into(holder.adsaimg);

    }

    @Override
    public int getItemCount() {
        return adsmodel.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
      //  CardView cardView;

        private TextView title,content;
        private ImageView adsaimg;

        public MyViewHolder(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.adscontent);
            title=(TextView)itemView.findViewById(R.id.adstitle);
            adsaimg=(ImageView) itemView.findViewById(R.id.adsimg);
        //    cardView = (CardView) itemView.findViewById(R.id.Card);

//            cardView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {




        }
    }

}