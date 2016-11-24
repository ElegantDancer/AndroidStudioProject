package com.iqiyi.zhenzhen.animationdemo;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.ani_tex);

        /**
         * Tween Animation
         */
//        Animation animation = new AlphaAnimation(0.1f, 1.0f);
//        animation.setDuration(5000);
//        animation.setRepeatCount(300);
//        animation.setRepeatMode(Animation.REVERSE);
//        mTextView.setAnimation(animation);

        /**
         * a set of animation
         */

//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anmi_first);
//        mTextView.setAnimation(animation);

        /**
         * 属性动画
         */

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ObjectAnimator animator = ObjectAnimator.ofFloat(mTextView, "translationY", 500.0f);
                animator.setDuration(5000);
                animator.setRepeatCount(20);
                animator.setRepeatMode(ValueAnimator.REVERSE);
                animator.start();

            }
        });
    }
}
