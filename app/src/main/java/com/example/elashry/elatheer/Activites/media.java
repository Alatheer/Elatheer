package com.example.elashry.elatheer.Activites;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.elashry.elatheer.Adapters.AdapterDept;
import com.example.elashry.elatheer.Adapters.Adapteroffer;
import com.example.elashry.elatheer.Models.DesignModel;
import com.example.elashry.elatheer.Models.NewsFeeds;
import com.example.elashry.elatheer.NetworkController;
import com.example.elashry.elatheer.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class media extends AppCompatActivity {

    RequestQueue queue;
    String url = "https://alatheertech.com/api/find/department_services";
    RecyclerView recyclerView;
    List<DesignModel> designList = new ArrayList<DesignModel>();
    AdapterDept adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);
        //Initialize RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new AdapterDept(this, designList,this);
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
                        DesignModel feeds = new DesignModel( obj.getString("content"),obj.getString("img"));

                        if (obj.getString("dep_id_fk").equals("1")){

                        // adding movie to movies array
                        designList.add(feeds);}

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
    private void Network_aviliabled()
    {
        ConnectivityManager cm = (ConnectivityManager)media.this.getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
        boolean data = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();

        if (!wifi && !data)
        {
            startActivity(new Intent(this, Check_Internet_connection.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

        }
        else {
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        Network_aviliabled();
    }

}
