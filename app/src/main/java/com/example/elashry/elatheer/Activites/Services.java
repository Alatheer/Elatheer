package com.example.elashry.elatheer.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.elashry.elatheer.R;
import com.imangazaliev.circlemenu.CircleMenu;
import com.imangazaliev.circlemenu.CircleMenuButton;

public class Services extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        CircleMenu circleMenu = (CircleMenu) findViewById(R.id.circleMenu);
        circleMenu.setOnItemClickListener(new CircleMenu.OnItemClickListener() {
            @Override
            public void onItemClick(CircleMenuButton menuButton) {
                switch (menuButton.getId()) {
                    case R.id.Program:
                        showMessage("Program");
                        Intent i=new Intent(Services.this,Programs.class);
                        startActivity(i);
                        break;
                    case R.id.adv:

                        Intent m = new Intent(Services.this, WhyAtheer.class);
                        startActivity(m);                        break;
                    case R.id.design:
                        Intent d = new Intent(Services.this, media.class);
                        startActivity(d);
                        break;
                    case R.id.fhrsa:
                        Intent F=new Intent(Services.this,Fahrasa.class);
                        startActivity(F);
                        break;
                    case R.id.camera:
                        Intent ic=new Intent(Services.this,Camera.class);
                        startActivity(ic);
                        showMessage("camera");
                        break;
                }


            }
        });

        circleMenu.setStateUpdateListener(new CircleMenu.OnStateUpdateListener() {
            @Override
            public void onMenuExpanded() {
                Log.d("CircleMenuStatus", "Expanded");
            }

            @Override
            public void onMenuCollapsed() {
                Log.d("CircleMenuStatus", "Collapsed");
            }
        });
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
