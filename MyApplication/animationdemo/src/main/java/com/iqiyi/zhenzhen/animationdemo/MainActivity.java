package com.iqiyi.zhenzhen.animationdemo;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Tween Animation
         */
        Animation animation = new AlphaAnimation(0.1f, 0.3f);
        animation.setDuration(5000);
        ObjectAnimator obj = new ObjectAnimator();

    }
}
