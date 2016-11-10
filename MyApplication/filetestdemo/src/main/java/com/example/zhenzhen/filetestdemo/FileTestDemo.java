package com.example.zhenzhen.filetestdemo;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by zhenzhen on 15/12/18.
 */
public class FileTestDemo {


    public boolean createExternFile(Context mContext, String fileName){

        File file = new File(mContext.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), fileName);
        File file2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES), fileName);
        if(file.mkdir()){
            return true;
        }
        return false;
    }

}
