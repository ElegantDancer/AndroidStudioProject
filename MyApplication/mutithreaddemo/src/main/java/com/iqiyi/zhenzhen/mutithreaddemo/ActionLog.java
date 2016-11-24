package com.iqiyi.zhenzhen.mutithreaddemo;

/**
 * Created by zhenzhen on 2016/11/16.
 */

import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 行为日志记录
 * @author Administrator
 *
 */
public class ActionLog {

    private static final String TAG = "ActionLog";
    public static String filePath="";

    public static ConcurrentLinkedQueue tempQueue=new ConcurrentLinkedQueue<Object>();
    /**
     * 记录基本信息 头
     * @param bi
     */
    public static synchronized void recordBaseInfoLog(String bi){
        tempQueue.add(bi);
        if(!WriteThread.isWriteThreadLive){//监察写线程是否工作中，没有 则创建
            new WriteThread().start();
        }
    }
    /**
     * 记录行为信息
     * @param ai
     */
    public static synchronized void recordActionInfoLog(String ai){
        tempQueue.add(ai);
        if(!WriteThread.isWriteThreadLive){
            new WriteThread().start();
        }
    }
    /**
     * 打开日志文件并写入日志
     *
     * @return
     * **/
    public static void recordStringLog(String text) {// 新建或打开日志文件
        File file = new File(filePath);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter filerWriter = new FileWriter(file, true);//后面这个参数代表是不是要接上文件中原来的数据，不进行覆盖
            BufferedWriter bufWriter = new BufferedWriter(filerWriter);
            bufWriter.write(text);
            bufWriter.newLine();
            bufWriter.close();
            filerWriter.close();
            Log.d("行为日志写入成功",text);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * 判断日志文件是否存在
     * @return
     */
    public static boolean isExitLogFile(){
        File file = new File(filePath);
        if (file.exists()&&file.length()>3){
            return true;
        }else{
            return false;
        }
    }
    /**
     * 删除日志文件
     */
    public static void deleteLogFile(){
        File file = new File(filePath);
        if (file.exists()){
            file.delete();
        }
    }
}
