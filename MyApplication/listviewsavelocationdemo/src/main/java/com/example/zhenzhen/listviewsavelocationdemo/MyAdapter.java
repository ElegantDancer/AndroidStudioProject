package com.example.zhenzhen.listviewsavelocationdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by zhenzhen on 16/8/4.
 */
public class MyAdapter extends BaseAdapter {

    Context mContext;

    public MyAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return 40;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.list_item, null);
        TextView mTextView = (TextView) view.findViewById(R.id.text);
        mTextView.setText("第" + position + "个项目");

        return view;
    }
}
