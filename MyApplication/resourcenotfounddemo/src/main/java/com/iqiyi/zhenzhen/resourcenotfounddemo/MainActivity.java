package com.iqiyi.zhenzhen.resourcenotfounddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.res_txt);

        try{
            mTextView.setText("hah");
        }catch (Exception ex){
            mTextView.setText("hahahahah");
        }


    }
}
