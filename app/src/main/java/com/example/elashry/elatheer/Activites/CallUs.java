package com.example.elashry.elatheer.Activites;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.elashry.elatheer.Controller;
import com.example.elashry.elatheer.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.net.ssl.SSLContext;

public class CallUs extends AppCompatActivity {
    ImageView face, whats, gmail;
    EditText cname,cphone,cmail,cmessage;
    AlertDialog.Builder mdialog;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_us);

        face = (ImageView) findViewById(R.id.facebook);
        whats = (ImageView) findViewById(R.id.whats);
        gmail = (ImageView) findViewById(R.id.gmail);

        cname= (EditText) findViewById(R.id.cname);
        cphone= (EditText) findViewById(R.id.cphone);
        cmail= (EditText) findViewById(R.id.cmail);
        cmessage= (EditText) findViewById(R.id.cmassege);


        face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=1478663585679350"));
                startActivity(intent);


            }
        });

        whats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent sendIntent = new Intent("android.intent.action.MAIN");
                sendIntent.setComponent(new ComponentName("com.whatsapp","com.whatsapp.Conversation"));
                sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators("01091121486")+"@s.whatsapp.net");
                startActivity(sendIntent);
            }
        });


        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                try {
//                    Intent intent = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:it.alatheertech@gmail.com"));
//                    startActivity(intent);
//                } catch (Exception e) {
//
//
//                }

sendEmail();            }
        });
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
        String client_mail      = cmail.getText().toString();
        String client_message          = cmessage.getText().toString();



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
        else if (!client_phone.matches("^(010|011|012)[0-9]{8}$"))
        {
            mdialog.setMessage("تاكد من ادخال رقم المحمول بشكل صحيح");
            mdialog.show();
        }
        else if (TextUtils.isEmpty(client_mail))
        {
            mdialog.setMessage("تاكد من ادخال الايميل ");
            mdialog.show();
        }
        else if (TextUtils.isEmpty(client_message))
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
                String date = new SimpleDateFormat("EEE ,dd MMM yyyy HH:mm aa", new Locale("ar","SA")).format(Calendar.getInstance().getTime());
                Add_call(client_name,client_phone,client_mail,client_message);
            }
            else
            {
                progressDialog.dismiss();
                mdialog.setMessage("تحقق من الاتصال بالانترنت");
                mdialog.setNegativeButton("موافق", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(CallUs.this, "موافق", Toast.LENGTH_SHORT).show();
                    }
                });
                mdialog.show();
            }
        }
    }
    private void Add_call(final String c_name, final String c_phone, final String c_mail, final String c_message)
    {
        try {
            SSLContext.getInstance("TLSv1.2");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        StringRequest strReq = new StringRequest(Request.Method.POST,
                "http://alatheertech.com/api/contact", new Response.Listener<String>() {

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
                                Toast.makeText(CallUs.this, "موافق", Toast.LENGTH_SHORT).show();
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

            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();
                params.put("name",c_name);
                params.put("phone",c_phone);
                params.put("email",c_mail);
                params.put("msg",c_message);
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
        startActivity(new Intent(CallUs.this,MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }





    protected void sendEmail() {
        Log.i("Send email", "");

        String[] TO = {"it.alatheertech@gmail.com","alatheertech@gmail.com","hr2.alatheertech@gmail.com"};
        String[] CC = {"alatheertech@gmail.com"};


        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finish sending email..", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(CallUs.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
    /*public static void initializeSSLContext(Context mContext){
        try {
            SSLContext.getInstance("TLSv1.2");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            ProviderInstaller.installIfNeeded(mContext.getApplicationContext());
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }*/



}
