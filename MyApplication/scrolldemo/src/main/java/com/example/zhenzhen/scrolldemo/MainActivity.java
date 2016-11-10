package com.example.zhenzhen.scrolldemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private final String TAG = "DEMO------DEMO";

    private MyScrollView mScrollView;

    private TextView mTextView;

    private Button mButton;

    private ImageView mImageView;
    private float scallY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mScrollView = (MyScrollView) findViewById(R.id.scroll_demo);
        mTextView = (TextView) findViewById(R.id.scroll_demo_tex);
        mImageView = (ImageView) findViewById(R.id.scroll_demo_img);
        mButton = (Button) findViewById(R.id.scroll_demo_btn);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Log.i(TAG, "------>" + mImageView.getHeight());

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                KeyEvent event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BACK);
//                boolean bb =  MainActivity.this.getWindow().getDecorView().dispatchKeyEvent(event);
//                Log.i(TAG, "----->"+ bb);
                finish();
            }
        });

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scallY += 0.1f;
                if(scallY < 0.3f){

                    mImageView.setScaleY(0);
                }else{
                    mImageView.setScaleY(scallY);
                }
                invalidateOptionsMenu();
                Log.i(TAG, "------>" + mImageView.getHeight());
            }
        });
//        mScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                int textHeight = mTextView.getHeight();
//                Log.i(TAG, "------->textHeight");
//                if (textHeight > 0) {
//
//                    float visionHeight = Math.max(scrollY, 0);
//                    float scaleY = visionHeight / textHeight;
//                    mTextView.setScaleY(scaleY);
//                }
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
