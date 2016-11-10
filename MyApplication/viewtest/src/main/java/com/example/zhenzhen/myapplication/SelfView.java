package com.example.zhenzhen.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhenzhen on 16/8/24.
 */
public class SelfView extends View {
    public SelfView(Context context) {
        super(context);
    }

    public SelfView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SelfView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
