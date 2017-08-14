package com.example.elashry.elatheer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gjiazhe.scrollparallaximageview.ScrollParallaxImageView;
import com.gjiazhe.scrollparallaximageview.parallaxstyle.VerticalMovingStyle;

public class Offer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter());
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private VerticalMovingStyle verticalMovingStyle = new VerticalMovingStyle();
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.item_offer, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.iv.setParallaxStyles(verticalMovingStyle);
            switch (position % 5) {
                case 0 : holder.iv.setImageResource(R.drawable.img1); break;
                case 1 : holder.iv.setImageResource(R.drawable.img1); break;
                case 2 : holder.iv.setImageResource(R.drawable.img3); break;
                case 3 : holder.iv.setImageResource(R.drawable.img1); break;
                case 4 : holder.iv.setImageResource(R.drawable.img1); break;
            }

            switch (position % 5) {
                case 0 : holder.T.setText("خصم 50% علي عروضنا في تصاميم المواقع "); break;
                case 1 : holder.T.setText("خصم يصل إلى (20%) من للمؤسسات الجديدة"); break;
                case 2 : holder.T.setText("نقدم لكم أرقي التصميمات التى تناسب جميع الأجهزة"); break;
                case 3 : holder.T.setText("خصم يصل إلى (20%) من للمؤسسات الجديدة"); break;
                case 4 : holder.T.setText("خصم 50% علي عروضنا في تصاميم المواقع"); break;
            }




        }

        @Override
        public int getItemCount() {
            return 25;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ScrollParallaxImageView iv;
            TextView T;
            ViewHolder(View itemView) {
                super(itemView);
                iv = (ScrollParallaxImageView) itemView.findViewById(R.id.img);
                T=(TextView)itemView.findViewById(R.id.T);
            }
        }
    }
}
