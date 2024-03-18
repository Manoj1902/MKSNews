package com.mks.news.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.intuit.sdp.BuildConfig;
import com.mks.news.Adapters.PagerAdapter;
import com.mks.news.R;

public class HomeActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mHome, mScience, mSports, mHealth, mTechnology, mEntertainment;
    ImageView btnInfo;
    PagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mHome = findViewById(R.id.tabItemHome);
        mSports = findViewById(R.id.tabItemSports);
        mHealth = findViewById(R.id.tabItemHealth);
        mScience = findViewById(R.id.tabItemScience);
        mEntertainment = findViewById(R.id.tabItemEntertainment);
        mTechnology = findViewById(R.id.tabItemTechnology);
        btnInfo = findViewById(R.id.info);

        ViewPager viewPager = findViewById(R.id.viewPagerFragmentContainer);

        tabLayout = findViewById(R.id.tabLayout);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 6);
        viewPager.setAdapter(pagerAdapter);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                String versionCode = String.valueOf(BuildConfig.VERSION_CODE);
                String versionName = String.valueOf(BuildConfig.VERSION_NAME);
                Toast.makeText(HomeActivity.this, "Version " + versionName, Toast.LENGTH_SHORT).show();
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0 ||tab.getPosition() == 1 || tab.getPosition() == 2 ||tab.getPosition() == 3 ||tab.getPosition() == 4 ||tab.getPosition() == 5){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}