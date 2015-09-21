package com.softtanck.xfermodestudy;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Window;

/**
 * @author : Tanck
 * @Description : TODO
 * @date 9/16/2015
 */
public class TestActivity extends AppCompatActivity {

    private Window window;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP) {
            window = getWindow();
            //00AAE9
            window.setStatusBarColor(Color.rgb(0, 170, 233));
            window.setEnterTransition(new Fade());
        }
        setContentView(R.layout.test);

    }
}
