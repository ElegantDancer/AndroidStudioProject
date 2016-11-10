package com.example.zhenzhen.scrolldemo;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/**
 * Created by zhenzhen on 15/11/19.
 */
public class MyScrollView extends HorizontalScrollView {
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Bundle bundle = new Bundle();
    }

}
