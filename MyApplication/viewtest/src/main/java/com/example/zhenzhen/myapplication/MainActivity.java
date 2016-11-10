package com.example.zhenzhen.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private WebView mWebview;
    private String url = "http://www.baidu.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebview = (WebView) findViewById(R.id.web);

        mWebview.loadUrl(url);
        mWebview.getTranslationX();
    }
}
