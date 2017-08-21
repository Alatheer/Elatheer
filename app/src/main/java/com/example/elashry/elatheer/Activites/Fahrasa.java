package com.example.elashry.elatheer.Activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.elashry.elatheer.Adapters.AdapterDept;
import com.example.elashry.elatheer.Adapters.AdapterFhrsa;
import com.example.elashry.elatheer.Models.DesignModel;
import com.example.elashry.elatheer.Models.FhrsaModel;
import com.example.elashry.elatheer.NetworkController;
import com.example.elashry.elatheer.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Fahrasa extends AppCompatActivity {
Button tasnef,head,fhrsa;
    TextView t1,t2,dt1,dt2;

    RequestQueue queue;
    String url = "https://alatheertech.com/api/find/department_services";
    RecyclerView recyclerView;
    List<FhrsaModel> fhrsaList = new ArrayList<FhrsaModel>();
    AdapterFhrsa adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fahrasa);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new AdapterFhrsa(this, fhrsaList,this);
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
                        FhrsaModel feeds = new FhrsaModel( obj.getString("content"),obj.getString("img"));

                        if (obj.getString("dep_id_fk").equals("5")){

                            // adding movie to movies array
                            fhrsaList.add(feeds);}

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



        tasnef=(Button)findViewById(R.id.tasnef);
        head=(Button)findViewById(R.id.head);
        fhrsa=(Button)findViewById(R.id.fhrsa);

        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        dt1=(TextView)findViewById(R.id.dt1);
        dt2=(TextView)findViewById(R.id.dt2);


        tasnef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText("ديوي");
                t2.setText("كونجرسي");
                dt1.setText("ديوي ديوي ديوي ديوي ديوي ديوي ديوي ديوي ديوي");
                dt2.setText("كونجرسي كونجرسي كونجرسي كونجرسي كونجرسي كونجرسي كونجرسي كونجرسي");
                t2.setVisibility(View.VISIBLE);
                dt2.setVisibility(View.VISIBLE);


            }
        });

        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText("قائمة رؤوس الموضعات العربيه");
                t2.setVisibility(View.GONE);
                dt1.setText("قائمة رؤوس الموضعات العربيه قائمة رؤوس الموضعات العربيه قائمة رؤوس الموضعات العربيه قائمة رؤوس الموضعات العربيه قائمة رؤوس الموضعات العربيه");
                dt2.setVisibility(View.GONE);
            }
        });

        fhrsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText("فهرسة مارك");
                t2.setText("فهرسة RED");
                dt1.setText("فهرسة مارك فهرسة مارك فهرسة مارك فهرسة مارك فهرسة مارك فهرسة مارك فهرسة مارك فهرسة مارك");
                dt2.setText("فهرسة RED فهرسة RED فهرسة RED فهرسة RED فهرسة RED فهرسة RED فهرسة REDفهرسة RED فهرسة REDفهرسة RED");
                t2.setVisibility(View.VISIBLE);
                dt2.setVisibility(View.VISIBLE);
            }
        });

    }
}

