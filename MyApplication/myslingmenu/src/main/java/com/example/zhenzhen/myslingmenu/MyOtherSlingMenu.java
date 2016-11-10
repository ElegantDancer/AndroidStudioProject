package com.example.zhenzhen.myslingmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/**
 * Created by zhenzhen on 2016/11/10.
 */

public class MyOtherSlingMenu extends HorizontalScrollView {

    private LinearLayout mLinearLayout;
    private View mMenu;
    private View mContent;

    private int mScreenWidth;

    private boolean once = false;

    private int mPaddingLeft;

    private Context mContext;

    public MyOtherSlingMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        mPaddingLeft = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, context.getResources().getDisplayMetrics());

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        if(!once){

            mLinearLayout = (LinearLayout) getChildAt(0);
            mMenu = mLinearLayout.getChildAt(0);
            mContent = mLinearLayout.getChildAt(1);

            WindowManager manager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics metrics = new DisplayMetrics();
            manager.getDefaultDisplay().getMetrics(metrics);

            mScreenWidth = metrics.widthPixels;
            mMenu.getLayoutParams().width = mScreenWidth;
            mContent.getLayoutParams().width = mScreenWidth;
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        if(!changed){
            this.scrollBy(mScreenWidth, 0);
        }
    }
}
