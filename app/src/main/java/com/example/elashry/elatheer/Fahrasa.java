package com.example.elashry.elatheer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Fahrasa extends AppCompatActivity {
Button tasnef,head,fhrsa;
    TextView t1,t2,dt1,dt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fahrasa);

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

