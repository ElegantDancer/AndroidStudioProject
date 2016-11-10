package com.example.zhenzhen.sqlitedemo;

import android.content.ContentValues;

/**
 * Created by zhenzhen on 15/12/28.
 */
public class SQLUtils {

    public void create(){
        ContentValues values = new ContentValues();
        values.put("DEMO", "hello");
    }
}
