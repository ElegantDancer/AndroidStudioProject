package com.iqiyi.zhenzhen.volleydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.volley_btn);
        mTextView = (TextView) findViewById(R.id.volley_tex);
        final RequestQueue mQuene = Volley.newRequestQueue(this);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest request = new StringRequest("https://www.baidu.com", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        mTextView.setText(s);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        mTextView.setText("取错了图片");
                    }
                });
                mQuene.add(request);
            }

        });

    }
}
