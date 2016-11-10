package com.iqiyi.zhenzhen.listviewdemo;

import android.app.Activity;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.MyAdpter;

public class MainActivity extends Activity {

    private ListView mListView;
    private int listViewHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.my_listview);
        Log.i("ZZZ", "onCrete直接取值" + mListView.getHeight());
        ArrayList mList = new ArrayList();
        for(int i = 0; i < 20; i++){
            mList.add(i);
        }
        mListView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                listViewHeight = mListView.getHeight();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    mListView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }else {
                    mListView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        });
        MyAdpter adpter = new MyAdpter(this, mList);
        mListView.setAdapter(adpter);
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(firstVisibleItem + visibleItemCount == totalItemCount){
                    View lastView = mListView.getChildAt(mListView.getChildCount() - 1);
                    if(lastView != null && lastView.getBottom() == listViewHeight){
                        Toast.makeText(MainActivity.this, "到了底部,监听完美", Toast.LENGTH_SHORT).show();
                    }
                     Log.i("ZZZ", "getButton---->" + (mListView.getBottom() - mListView.getTop()));
                    Log.i("ZZZ", "totalItemCount is---->" + totalItemCount);
                    Log.i("ZZZ", "ListView getChildCount is---->" + mListView.getChildCount());
                     Log.i("ZZZ", "得到的结果为" + listViewHeight);
                }
                if(firstVisibleItem == 0){
                    View first = mListView.getChildAt(firstVisibleItem);
                    if(first != null && first.getTop() == 0){
                        Toast.makeText(MainActivity.this, "到了顶部,完美", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}
