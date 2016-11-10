package com.example.zhenzhen.myapplication;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zhenzhen on 2016/11/9.
 */

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getRawX();
        int y = (int) event.getRawY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                getScrollX();
                break;
            case MotionEvent.ACTION_MOVE:
                break;
        }

        return super.onTouchEvent(event);
    }
}
