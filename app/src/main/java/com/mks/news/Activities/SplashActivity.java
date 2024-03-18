package com.mks.news.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.mks.news.R;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    TextView appName, appTagLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        constraintLayout = findViewById(R.id.layoutSplash);
        appName = findViewById(R.id.text_app_name);
        appTagLine = findViewById(R.id.textApp_tagline);

//        int nightModeFlags =
//                getApplicationContext().getResources().getConfiguration().uiMode &
//                        Configuration.UI_MODE_NIGHT_MASK;
//        switch (nightModeFlags) {
//            case Configuration.UI_MODE_NIGHT_YES:
//                appName.setTextColor(Color.parseColor("#D1D5DA"));
//
//                break;
//
//            case Configuration.UI_MODE_NIGHT_NO:
//                appName.setTextColor(Color.parseColor("#31495D"));
//                break;
//
//            case Configuration.UI_MODE_NIGHT_UNDEFINED:
//
//                break;
//        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },2000);


    }
}