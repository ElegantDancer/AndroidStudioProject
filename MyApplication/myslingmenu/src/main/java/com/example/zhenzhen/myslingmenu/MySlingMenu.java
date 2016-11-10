package com.example.zhenzhen.myslingmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/**
 * Created by zhenzhen on 2016/11/9.
 */

public class MySlingMenu extends HorizontalScrollView {

    private LinearLayout mLinearlayout;
    private int mScreenWidth;
    private View mContentView;
    private View mMenuView;

    private int mPaddingLeft;

    private boolean once = false;


    public MySlingMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(metrics);
        mScreenWidth = metrics.widthPixels;

        mPaddingLeft = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, context.getResources().getDisplayMetrics());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.i("----->first --->", "haha");

        /**
         * 将menuView 和contentView的宽度设置为屏幕的宽度
         */
        if(!once){
            mLinearlayout = (LinearLayout) getChildAt(0);
            mMenuView = mLinearlayout.getChildAt(0);
            mContentView = mLinearlayout.getChildAt(1);

            mMenuView.getLayoutParams().width = mScreenWidth;
            mContentView.getLayoutParams().width = mScreenWidth;
            once = true;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        /**
         * 初始化位置layout的设定
         *
         * 因为viewGroup是根据子先计算子view的位置，然后在确定在viewGroup中的显示
         * 所以onLayout可能会被多次调用
         * 进行changed判断就是为了防止多次执行
         */

        //super先执行  是因为  viewGroup（本例中是HorizontalScrollView）最终位置确定后，再执行scrollTo
        //super.onMeasure在下面和在上面执行无所谓
        //change最后一次为false
        super.onLayout(changed, l, t, r, b);
        if(!changed){
            //利用了HorizontalScrollView的特性
            this.scrollBy(mScreenWidth, 0);

        }
    }
}
