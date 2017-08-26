package com.example.elashry.elatheer.Activites;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.MailTo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.elashry.elatheer.R;

public class CallUs extends AppCompatActivity {
    ImageView face, whats, gmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_us);

        face = (ImageView) findViewById(R.id.facebook);
        whats = (ImageView) findViewById(R.id.whats);
        gmail = (ImageView) findViewById(R.id.gmail);


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



}
