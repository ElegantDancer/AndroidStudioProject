package com.example.zhenzhen.handdraw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zhenzhen on 16/8/2.
 */
public class DrawView extends View {

    private float preX;
    private float preY;
    private Path path;
    public Paint paint = null;
    final int VIEW_WIDTH = 320;
    final int VIEW_HEIGHT = 480;
    //定义一个内存中的图片,将图片作为缓冲区
    Bitmap cacheBitmap = null;

    //定义cacheBitmap上的Canvas对象
    Canvas cacheCanvas = null;

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //以什么样的长宽和画质新建一张bitmap图像
        cacheBitmap = Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT, Bitmap.Config.ARGB_8888);
        cacheCanvas = new Canvas();
        path = new Path();
        //设置cacheCanvas将会绘制到内存中的cacheBitmap上
        cacheCanvas.setBitmap(cacheBitmap);
        //  设置画笔的颜色
        paint.setColor(Color.RED);
        //设置画笔风格
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        //反锯齿
        paint.setAntiAlias(true);
        paint.setDither(true);
    }

    public DrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //获取拖动事件的发生位置
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                path.quadTo(preX, preY, x, y);
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_UP:
                cacheCanvas.drawPath(path, paint);
                path.reset();
                break;
        }
        invalidate();
        //返回true代表已经消费了本次事件
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint bmpPaint = new Paint();
        canvas.drawBitmap(cacheBitmap, 0, 0, bmpPaint);
        canvas.drawPath(path, paint);
    }
}
