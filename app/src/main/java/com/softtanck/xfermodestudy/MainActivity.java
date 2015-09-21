package com.softtanck.xfermodestudy;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            //00AAE9
            window.setStatusBarColor(Color.rgb(0, 170, 233));
        }
        setContentView(R.layout.activity_main);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void ceshi(View view) {
        Intent intent = new Intent(MainActivity.this, TestActivity.class);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this, findViewById(R.id.myView), "tanck").toBundle());
    }

}
