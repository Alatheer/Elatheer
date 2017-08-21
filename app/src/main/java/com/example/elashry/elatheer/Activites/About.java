package com.example.elashry.elatheer.Activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elashry.elatheer.R;

public class About extends AppCompatActivity {
    Button Menof;
    Button Alex;
    Button Sudia,ahmedali,eslamsami,mohamedeelashry;
    TextView call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Menof=(Button)findViewById(R.id.menof);
        Alex=(Button)findViewById(R.id.alex);
        Sudia=(Button)findViewById(R.id.sudia);
        call=(TextView)findViewById(R.id.call);

        ahmedali=(Button)findViewById(R.id.ahmedali);
        eslamsami=(Button)findViewById(R.id.eslmsami);
        mohamedeelashry=(Button)findViewById(R.id.mohamedelashry);

        ahmedali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(About.this, ahmedali);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.poupup_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                About.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        return true;
                    }
                });


                popup.show(); //showing popup menu
            }
        });

        Menof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call.setText("لاثير تك هى شركة دولية تمتد عبر الوطن العربى هى شركة متخصصة فى البرمجيات والتسويق الالكترونى ونظم الأمان وتطبيقات الموبايل و التى تركز على تطوير مواقع الانترنت و تطوير برامج الاليات و البرامج المكتبية و التجارة الالكترونية و انظمة ERP و الاستشارات التكنولوجيا . تتنوع خدمتنا طبقا لاحتياجات السوق والعملاء سواء كانت خدمات برامجية او تسويقية ... إإلخ .\n" +
                        "\n" +
                        "شبين الكوم - المنوفية - مصر\n" +
                        "\n" +
                        " تليفون رقم : 2147483647\n" +
                        "\n" +
                        " البريد الإلكترونى: info@alatheertech.com");

            }
        });

        Alex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call.setText("الاثير تك هى شركة دولية تمتد عبر الوطن العربى هى شركة متخصصة فى البرمجيات والتسويق الالكترونى ونظم الأمان وتطبيقات الموبايل و التى تركز على تطوير مواقع الانترنت و تطوير برامج الاليات و البرامج المكتبية و التجارة الالكترونية و انظمة ERP و الاستشارات التكنولوجيا . تتنوع خدمتنا طبقا لاحتياجات السوق والعملاء سواء كانت خدمات برامجية او تسويقية ... إإلخ .\n" +
                        "\n" +
                        "الأسكندريةالأسكندريةالأسكندريةالأسكندريةالأسكندريةالأسكندرية\n" +
                        "\n" +
                        " تليفون رقم : 546456\n" +
                        "\n" +
                        " البريد الإلكترونى: qeqwe@qweqwe");
            }
        });


        Sudia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call.setText("الاثير تك هى شركة دولية تمتد عبر الوطن العربى هى شركة متخصصة فى البرمجيات والتسويق الالكترونى ونظم الأمان وتطبيقات الموبايل و التى تركز على تطوير مواقع الانترنت و تطوير برامج الاليات و البرامج المكتبية و التجارة الالكترونية و انظمة ERP و الاستشارات التكنولوجيا . تتنوع خدمتنا طبقا لاحتياجات السوق والعملاء سواء كانت خدمات برامجية او تسويقية ... إإلخ .\n" +
                        "\n" +
                        "السعودية - حائل - سوق الجوالات\n" +
                        "\n" +
                        " تليفون رقم : 543629615\n" +
                        "\n" +
                        " البريد الإلكترونى: info@alatheertech.com");

            }
        });


    }
}
