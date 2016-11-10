package com.example.zhenzhen.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.Button;

/**
 * Created by zhenzhen on 16/8/24.
 */
public class SelfButton extends Button {
    public SelfButton(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
    }
}
