package com.example.elashry.elatheer.Activites;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.elashry.elatheer.R;

import java.util.HashMap;

public class Camera extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

private SliderLayout mDemoSlider;
    Button btnregister1, btnregister2, btnregister3, btnregister4, btnregister5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        init_View();
        btnregister1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Camera.this,CallUs.class);
                startActivity(i);
            }
        });
        btnregister2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Camera.this,CallUs.class);
                startActivity(i);
            }
        });
        btnregister3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Camera.this,CallUs.class);
                startActivity(i);
            }
        });
        btnregister4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Camera.this,CallUs.class);
                startActivity(i);
            }
        });
        btnregister5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Camera.this,CallUs.class);
                startActivity(i);
            }
        });

    }


    private void init_View() {
        mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        btnregister1= (Button) findViewById(R.id.b1);
        btnregister2= (Button) findViewById(R.id.b2);
        btnregister3= (Button) findViewById(R.id.b3);
        btnregister4= (Button) findViewById(R.id.b4);
        btnregister5= (Button) findViewById(R.id.b5);

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("كاميرات مراقبه", R.drawable.ca);
        file_maps.put("تطبيقات موبيل ", R.drawable.mobile);
        file_maps.put("كاميرا ثلاثيه", R.drawable.ca2);
        file_maps.put("تسويق منتجات", R.drawable.s1);
        file_maps.put("تصميم لوجهات واعلانات", R.drawable.photo);
        file_maps.put("تصميم مواقع", R.drawable.ca3);
        file_maps.put("تصميم بوسترات ومنيوهات", R.drawable.menu1);


        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView.description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);
            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(2000);
        mDemoSlider.addOnPageChangeListener(this);


    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
