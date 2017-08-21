package com.example.elashry.elatheer.Activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.elashry.elatheer.R;

public class Details_News extends AppCompatActivity {
TextView date,content,title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details__news);

        date=(TextView)findViewById(R.id.date);
        content=(TextView)findViewById(R.id.content);
        title=(TextView)findViewById(R.id.title);

        Intent intent=getIntent();

        date.setText(intent.getStringExtra("date"));
        content.setText(intent.getStringExtra("content"));
        title.setText(intent.getStringExtra("title"));


    }
}
