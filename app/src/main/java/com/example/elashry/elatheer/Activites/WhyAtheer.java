package com.example.elashry.elatheer.Activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.elashry.elatheer.Adapters.AdapterAds;
import com.example.elashry.elatheer.Adapters.AdapterFhrsa;
import com.example.elashry.elatheer.Models.AdsModel;
import com.example.elashry.elatheer.NetworkController;
import com.example.elashry.elatheer.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WhyAtheer extends AppCompatActivity {
    RequestQueue queue;
    String url = "https://alatheertech.com/api/find/department_services";
    RecyclerView recyclerView;
    List<AdsModel> adslist = new ArrayList<AdsModel>();
    AdapterAds adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_why_atheer);


            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            adapter = new AdapterAds(this, adslist,this);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            recyclerView.setAdapter(adapter);
            //Getting Instance of Volley Request Queue
            queue = NetworkController.getInstance(this).getRequestQueue();
            //Volley's inbuilt class to make Json array request
            JsonArrayRequest newsReq = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject obj = response.getJSONObject(i);
                            AdsModel feeds = new AdsModel( obj.getString("img"),obj.getString("content"),obj.getString("title"));

                            if (obj.getString("dep_id_fk").equals("4")){

                                // adding movie to movies array
                                adslist.add(feeds);}

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        } finally {
                            //Notify adapter about data changes
                            adapter.notifyItemChanged(i);
                        }
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println(error.getMessage());
                }
            });
            //Adding JsonArrayRequest to Request Queue
            queue.add(newsReq);
    }
}
