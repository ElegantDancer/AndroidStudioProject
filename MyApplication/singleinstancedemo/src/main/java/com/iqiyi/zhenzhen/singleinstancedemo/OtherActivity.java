package com.iqiyi.zhenzhen.singleinstancedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by zhenzhen on 2016/11/2.
 */
public class OtherActivity extends Activity{

    private Button mButton;
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mButton = (Button) findViewById(R.id.single_btn2);
        mTextView = (TextView) findViewById(R.id.single_tex);

        final CustomPlayer customPlayer = CustomPlayer.getInstance();
        mTextView.setText("otherActivity-----> " + customPlayer.getName());

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customPlayer.setName("第二次赋值");
                mTextView.setText(customPlayer.getName());
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }
}
