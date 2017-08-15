package com.example.elashry.elatheer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class idieaactivity extends AppCompatActivity {
    Button b;
    TextView t1,t2,t3;
    public static final int GET_FROM_GALLERY = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idia);
     //   setSupportActionBar(toolbar);



        List<idieslist> movies = new ArrayList<>();

        int posters[] = {R.drawable.idea1,R.drawable.idea1,
                R.drawable.idea1};

        String movienames[] = {"اعلان لمنتجات ألبان بشكل ابداعي" , "اعلان لمنتجات ألبان بشكل ابداعي", "اعلان لمنتجات ألبان بشكل ابداعي"};


        String moviesRates[] = {"2016", "2017", "2014"};

        String moviesStories[] = {"إن أهم ما يرتكز عليه عمل دعاية وإعلان لمنتج أو لخدمة هي الابتكار والإبداع في الإعلان نفسه فلابد أن يتميز بأنه غير تقليدي ( إعلان مبتكر ) به فكرة إعلانية مجنونة تجذب الانتباه ومن الممكن أن تثير الدهشة والاستغراب لكن لا بأس المهم",
                "إن أهم ما يرتكز عليه عمل دعاية وإعلان لمنتج أو لخدمة هي الابتكار والإبداع في الإعلان نفسه فلابد أن يتميز بأنه غير تقليدي ( إعلان مبتكر ) به فكرة إعلانية مجنونة تجذب الانتباه ومن الممكن أن تثير الدهشة والاستغراب لكن لا بأس المهم هو تحقيق الهدف بمعنى توصيل الرسالة الإعلانية للمنتج أو للخدمة بصورة جذابة ترسخ في الأذهان","إن أهم ما يرتكز عليه عمل دعاية وإعلان لمنتج أو لخدمة هي الابتكار والإبداع في الإعلان نفسه فلابد أن يتميز بأنه غير تقليدي ( إعلان مبتكر ) به فكرة إعلانية مجنونة تجذب الانتباه ومن الممكن أن تثير الدهشة والاستغراب لكن لا بأس المهم ه"};


        for (int i = 0; i < posters.length; i++) {

            idieslist movie =
                    new idieslist(movienames[i], moviesRates[i], moviesStories[i], posters[i]);

            movies.add(movie);


        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        idiaadepter adapter = new idiaadepter(movies);
        recyclerView.setAdapter(adapter);




        b = (Button) findViewById(R.id.b1);
        //t1=(TextView)findViewById(R.id.t1)


        t2=(TextView)findViewById(R.id.t2) ;t3=(TextView)findViewById(R.id.t3) ;

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), GET_FROM_GALLERY);
                // Toast.makeText(idia.this,, Toast.LENGTH_SHORT).show();


                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select picture"), GET_FROM_GALLERY );


            }


        });



    }



    @Override
    protected void onActivityResult(int reqCode, int resCode, Intent data) {
        if(resCode == Activity.RESULT_OK && data != null){
            String realPath;
            // SDK < API11
            if (Build.VERSION.SDK_INT < 11)
                realPath = RealPathUtil.getRealPathFromURI_BelowAPI11(this, data.getData());

                // SDK >= 11 && SDK < 19
            else if (Build.VERSION.SDK_INT < 19)
                realPath = RealPathUtil.getRealPathFromURI_API11to18(this, data.getData());

                // SDK > 19 (Android 4.4)
            else
                realPath = RealPathUtil.getRealPathFromURI_API19(this, data.getData());


            setTextViews(Build.VERSION.SDK_INT, data.getData().getPath(),realPath);
        }
    }

    private void setTextViews(int sdk, String uriPath,String realPath){

//        this.t1.setText("Build.VERSION.SDK_INT: "+sdk);
        this.t2.setText("URI Path: "+uriPath);
        this.t3.setText("Real Path: "+realPath);

        Uri uriFromPath = Uri.fromFile(new File(realPath));

        // you have two ways to display selected image

        // ( 1 ) imageView.setImageURI(uriFromPath);

        // ( 2 ) imageView.setImageBitmap(bitmap);
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uriFromPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Log.d("HMKCODE", "Build.VERSION.SDK_INT:"+sdk);
        Log.d("HMKCODE", "URI Path:"+uriPath);
        Log.d("HMKCODE", "Real Path: "+realPath);
    }

}