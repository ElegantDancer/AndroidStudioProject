package com.example.zhenzhen.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

public class MainActivity extends Activity
        implements OnGestureListener {
    // ∂®“Â ÷ ∆ºÏ≤‚∆˜ µ¿˝
    GestureDetector detector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //¥¥Ω® ÷ ∆ºÏ≤‚∆˜
        detector = new GestureDetector(this, this);
    }

    //Ω´∏√Activity…œµƒ¥•≈ˆ ¬º˛Ωª∏¯GestureDetector¥¶¿Ì
    @Override
    public boolean onTouchEvent(MotionEvent me) {
        return detector.onTouchEvent(me);
    }

    @Override
    public boolean onDown(MotionEvent arg0) {
        Log.i("Gesture----->", "ondown");

        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2
            , float velocityX, float velocityY) {
        Log.i("Gesture----->", "onFling");

        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.i("Gesture----->", "onLongPress");

    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2
            , float distanceX, float distanceY) {
        Log.i("Gesture----->", "onScroll");

        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.i("Gesture----->", "onShowPress");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.i("Gesture----->", "onSingleTapUp");

        return false;
    }


}