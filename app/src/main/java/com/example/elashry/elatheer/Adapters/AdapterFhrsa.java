package com.example.elashry.elatheer.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elashry.elatheer.Activites.Fahrasa;
import com.example.elashry.elatheer.Activites.media;
import com.example.elashry.elatheer.Models.FhrsaModel;
import com.example.elashry.elatheer.Models.FhrsaModel;
import com.example.elashry.elatheer.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by AndroidNovice on 6/5/2016.
 */
public class AdapterFhrsa extends RecyclerView.Adapter<AdapterFhrsa.MyViewHolder> {

    private List<FhrsaModel> fhrsaList;
    private Context context;
    Fahrasa fhrsa;

    private LayoutInflater inflater;

    public AdapterFhrsa(Context context, List<FhrsaModel> fhrsaList, Fahrasa fhrsa) {

        this.context = context;
        this.fhrsaList = fhrsaList;
        this.fhrsa = fhrsa;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = inflater.inflate(R.layout.fhrsa_item, parent, false);
        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FhrsaModel feeds = fhrsaList.get(position);
        //Pass the values of feeds object to Views
      //  holder.cardView.setTag(position);

        holder.title.setText(feeds.getFtitle());

     //   holder.date.setText(feeds.getDimage());
        Picasso.with(context).load("https://alatheertech.com/uploads/images/"+feeds.getFimage()).into(holder.fhrsaimg);

    }

    @Override
    public int getItemCount() {
        return fhrsaList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
      //  CardView cardView;

        private TextView title;
        private ImageView fhrsaimg;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.content);
            fhrsaimg=(ImageView) itemView.findViewById(R.id.imgfhrsa);
        //    cardView = (CardView) itemView.findViewById(R.id.Card);

//            cardView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {




        }
    }

}