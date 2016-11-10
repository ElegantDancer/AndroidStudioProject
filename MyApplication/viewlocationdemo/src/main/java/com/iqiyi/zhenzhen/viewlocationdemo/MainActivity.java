package com.iqiyi.zhenzhen.viewlocationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private String TAG = "ZZZ----->";
    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.demo_btn);
        mLinearLayout = (LinearLayout) findViewById(R.id.my_liner);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mButton.scrollBy(30, 40);
                mLinearLayout.scrollBy(30, 40);
                int[] positon = new int[2];
                mButton.getLocationInWindow(positon);
                Log.i(TAG, "X坐标为getLocationInWindow:" + positon[0]);
                Log.i(TAG, "Y坐标为getLocationInWindow:" + positon[1]);

                mButton.getLocationOnScreen(positon);
                Log.i(TAG, "X坐标location为getLocationOnScreen:" + positon[0]);
                Log.i(TAG, "Y坐标location为getLocationOnScreen:" + positon[1]);
                Log.i(TAG, "getXY的方式坐标为getLocationOnScreen:" + mButton.getX());
                Log.i(TAG, "getXY的方式坐标为getLocationOnScreen:" + mButton.getY());
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
