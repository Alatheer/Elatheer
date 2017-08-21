package com.example.elashry.elatheer.Activites;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.elashry.elatheer.Fragmebts.Mobile;
import com.example.elashry.elatheer.Fragmebts.Web;
import com.example.elashry.elatheer.Fragmebts.Webapp;
import com.example.elashry.elatheer.R;
import com.example.elashry.elatheer.Adapters.ViewPagerAdapter;

public class Programs extends AppCompatActivity {
    private TabLayout mTab;
    private ViewPager pager;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs);
        init_View();

    }

    private void init_View() {
        mToolbar = (Toolbar) findViewById(R.id._mngr_mtoolBar);
        setSupportActionBar(mToolbar);

        mTab = (TabLayout) findViewById(R.id.mngr_mTab);
        pager= (ViewPager) findViewById(R.id.pro_viewPager);

        mTab.addTab(mTab.newTab().setText("ويب"));
        mTab.addTab(mTab.newTab().setText("موبيل"));
        mTab.addTab(mTab.newTab().setText("مواقع"));

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Web());
        adapter.addFragment(new Mobile());
        adapter.addFragment(new Webapp());

        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Programs.this, Services.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }
}
