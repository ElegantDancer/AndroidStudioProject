package com.example.zhenzhen.fragmentdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        mTextView = (TextView) findViewById(R.id.my_tex);
        Log.i("getTop----->", String.valueOf(mTextView.getTop()));
        Log.i("getPaddingTop----->", String.valueOf(mTextView.getPaddingTop()));
        Log.i("getPaddingLeft----->", String.valueOf(mTextView.getPaddingLeft()));
        Log.i("getPaddingRight----->", String.valueOf(mTextView.getPaddingRight()));
        Log.i("getBottom----->", String.valueOf(mTextView.getBottom()));
        Log.i("getLeft----->", String.valueOf(mTextView.getLeft()));
        Log.i("getRight----->", String.valueOf(mTextView.getRight()));
        Log.i("getMesureHeight----->", String.valueOf(mTextView.getMeasuredHeight()));
        Log.i("getHeight----->", String.valueOf(mTextView.getHeight()));

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
