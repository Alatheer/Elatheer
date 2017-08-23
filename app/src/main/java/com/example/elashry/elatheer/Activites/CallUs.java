package com.example.elashry.elatheer.Activites;

import android.content.Intent;
import android.net.MailTo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

                openWhatsApp();
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

    private void openWhatsApp() {
        String smsNumber = "01091121486"; //without '+'
        try {
            Intent sendIntent = new Intent("android.intent.action.MAIN");
            //sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.setType("text/plain");
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
            sendIntent.putExtra("jid", smsNumber + "@s.whatsapp.net"); //phone number without "+" prefix
            sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Error/n" + e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    protected void sendEmail() {


        Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:it.alatheertech@gmail.com"));

        email.setType("message/rfc822");


        try {

            startActivity(Intent.createChooser(email, "Choose an email client from..."));

        } catch (android.content.ActivityNotFoundException ex) {

            Toast.makeText(CallUs.this, "No email client installed.",

                    Toast.LENGTH_LONG).show();

        }

    }



}
