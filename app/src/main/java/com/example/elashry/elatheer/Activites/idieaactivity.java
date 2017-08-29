package com.example.elashry.elatheer.Activites;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.elashry.elatheer.Adapters.idiaadepter;
import com.example.elashry.elatheer.Controller;
import com.example.elashry.elatheer.R;
import com.example.elashry.elatheer.RealPathUtil;
import com.example.elashry.elatheer.Models.idieslist;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class idieaactivity extends AppCompatActivity {
    Button b;
    TextView t1,t2,t3;
    public static final int GET_FROM_GALLERY = 3;
    EditText cname,cphone,cmail,idea_title,idea_explain;
    AlertDialog.Builder mdialog;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idia);
     //   setSupportActionBar(toolbar);

        cname= (EditText) findViewById(R.id.cname);
        cphone = (EditText) findViewById(R.id.cname);
        cmail = (EditText) findViewById(R.id.cmail);
        idea_title= (EditText) findViewById(R.id.idea_title);
        idea_explain= (EditText) findViewById(R.id.idea_explain);



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


     //   b = (Button) findViewById(R.id.b1);
        //t1=(TextView)findViewById(R.id.t1)


        t2=(TextView)findViewById(R.id.t2) ;t3=(TextView)findViewById(R.id.t3) ;

       /* b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), GET_FROM_GALLERY);
                // Toast.makeText(idia.this,, Toast.LENGTH_SHORT).show();


                Intent intent = new Intent();
                intent.setType("image*//*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select picture"), GET_FROM_GALLERY );


            }


        });
*/
        mdialog       = new AlertDialog.Builder(this);
        mdialog.setCancelable(false);
        mdialog.setNegativeButton("إلغاء", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);


    }

    public void registerOrder(View view) {
        String client_name          = cname.getText().toString();
        String client_phone         = cphone.getText().toString();
        String client_mail        = cmail.getText().toString();
        String ititle      = idea_title.getText().toString();
        String iexplain          = idea_explain.getText().toString();



        if(TextUtils.isEmpty(client_name))
        {
            mdialog.setMessage("تاكد من ادخال الاسم");
            mdialog.show();
        }
        else if (TextUtils.isEmpty(client_phone))
        {
            mdialog.setMessage("تاكد من ادخال رقم المحمول");
            mdialog.show();
        }
     /*   else if (!client_phone.matches("^(010|011|012)[0-9]{8}$"))
        {
            mdialog.setMessage("تاكد من ادخال رقم المحمول بشكل صحيح");
            mdialog.show();
        }*/
        else if (TextUtils.isEmpty(client_mail))
        {
            mdialog.setMessage("تاكد من ادخال رقم الايميل");
            mdialog.show();
        }
     /*   else if (!client_mail.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+"))
        {
            mdialog.setMessage("تاكد من ادخال رقم الايميل بشكل صحيح");
            mdialog.show();
        }*/
        else if (TextUtils.isEmpty(ititle))
        {
            mdialog.setMessage("تاكد من ادخال hguk,hk ");
            mdialog.show();
        }
        else if (TextUtils.isEmpty(iexplain))
        {
            mdialog.setMessage("تاكد من ادخال رسالتك");
            mdialog.show();
        }

        else
        {

            boolean isConnected = Check_Network();
            if (isConnected==true)

            {
                progressDialog.setMessage("sending "+ cname.getText().toString()+" data to server");
                progressDialog.show();
                Add_call(client_name,client_phone,client_mail,ititle,iexplain);
            }
            else
            {
                progressDialog.dismiss();
                mdialog.setMessage("تحقق من الاتصال بالانترنت");
                mdialog.setNegativeButton("موافق", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(idieaactivity.this, "موافق", Toast.LENGTH_SHORT).show();
                    }
                });
                mdialog.show();
            }
        }
    }
    private void Add_call(final String c_name, final String c_phone,final String c_mail, final String idea_title, final String idea_explain)
    {

        StringRequest strReq = new StringRequest(Request.Method.POST,
                "https://alatheertech.com/api/idea", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    String msg = jsonResponse.get("message").toString();
                    if (msg.equals("1"))
                    {
                        progressDialog.dismiss();
                        mdialog.setMessage("تم ارسال الطلب بنجاح");
                        mdialog.setNegativeButton("موافق", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
                        mdialog.show();

                    }
                    else
                    {
                        progressDialog.dismiss();
                        mdialog.setMessage("خطا اثناء ارسال البيانات ");
                        mdialog.setNegativeButton("موافق", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(idieaactivity.this, "موافق", Toast.LENGTH_SHORT).show();
                            }
                        });
                        mdialog.show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    progressDialog.dismiss();
                }
                Log.e("response",response.toString());

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("MMM",error.getMessage().toString());

                mdialog.setMessage(error.getMessage() );
                mdialog.setNegativeButton("موافق", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(idieaactivity.this, "موافق", Toast.LENGTH_SHORT).show();
                    }
                });
                mdialog.show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();
                params.put("client_name",c_name);
                params.put("client_phone",c_phone);
                params.put("client_mail",c_mail);
                params.put("idea_title",idea_title);
                params.put("idea_explain",idea_explain);
                return params;
            }

        };
        // Adding request to request queue
        Controller.getInstance().addToRequestQueue(strReq,"re");
    }
    private boolean Check_Network()
    {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
        boolean mobile_data = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();

        if (!wifi&&!mobile_data)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(idieaactivity.this,MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }




 /*   @Override
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
    }*/

 /*   private void setTextViews(int sdk, String uriPath,String realPath){

//        this.t1.setText("Build.VERSION.SDK_INT: "+sdk);
        this.t2.setText("URI Path: "+uriPath);
        this.t3.setText("Real Path: ");

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
    }*/

}