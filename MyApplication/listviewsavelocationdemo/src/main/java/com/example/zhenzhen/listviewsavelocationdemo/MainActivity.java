package com.example.zhenzhen.listviewsavelocationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AbsListView.OnScrollListener{

    private ListView mListView;
    private int mTop;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mListView = (ListView) findViewById(R.id.my_list_view);
        MyAdapter adapter = new MyAdapter(this);
        mListView.setAdapter(adapter);
        mListView.setOnScrollListener(this);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });



    }


    @Override
    protected void onResume() {
        super.onResume();
        mListView.setSelectionFromTop(index, mTop);
//        mListView.setSelection(index);
    }

    @Override
    protected void onStop() {
        super.onStop();
        index = mListView.getFirstVisiblePosition();
        //当前可见的第一个item
        View view = mListView.getChildAt(0);

        mTop = (view == null)? 0:(view.getTop() - mListView.getPaddingTop());

        Log.i("view.getTop--->", String.valueOf(view.getTop()));
        Log.i("mTop--->", String.valueOf(mTop));
        Log.i("index--->", String.valueOf(index));
        Log.i("childCount--->", String.valueOf(mListView.getChildCount()));
        Log.i("Count--->", String.valueOf(mListView.getCount()));

        Log.i("listView.getPaddingTop", String.valueOf(mListView.getPaddingTop()));
//        mTop = view.getTop();
    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        Log.i("firstVisibleItem--->", String.valueOf(firstVisibleItem));
        Log.i("visibleItemCount--->", String.valueOf(visibleItemCount));
        Log.i("totalItemCount--->", String.valueOf(totalItemCount));

    }
}
