package com.iqiyi.zhenzhen.mutithreaddemo;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by zhenzhen on 2016/11/16.
 */

public class IqiyiLog {

    private static IqiyiLog outInstance = new IqiyiLog();

    private ReentrantReadWriteLock reentrantReadWriteLock;
    private ReentrantReadWriteLock.WriteLock writeLock;
    private ReentrantReadWriteLock.ReadLock readLock;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



    private ExecutorService service;
    private static Context mContext;

    private IqiyiLog() {
        reentrantReadWriteLock = new ReentrantReadWriteLock();
        writeLock = reentrantReadWriteLock.writeLock();
        readLock = reentrantReadWriteLock.readLock();
        service = Executors.newFixedThreadPool(10);

    }

    /**
     * 获取单例对象
     *
     * @param context
     * @return
     */
    public static IqiyiLog getInstance(Context context) {
        mContext = context;
        return outInstance;
    }


    /**
     * 往文件中写数据
     *
     * @param str
     */
    public void write(final String str) {

        service.execute(new Runnable() {
            @Override
            public void run() {
                put(str);
            }
        });
    }

    /**
     * 读取文件中的内容
     *
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */

    public String read() throws ExecutionException, InterruptedException {
        Future<String> future = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return get();
            }
        });

        return future.get();
    }

    private void put(String str) {

        try {
            writeLock.lock();
            File file = getLogFile();
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            StringBuffer buffer = new StringBuffer();
            buffer.append(dateFormat.format(new Date())).append(":   ").append(str);//.append("\r\n");
            bufferWriter.newLine();
            bufferWriter.write(buffer.toString());
            bufferWriter.flush();
            fileWriter.close();
            bufferWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    private String get() {
        return getContentFromFile();
    }

    /**
     * 将文件内容返回到一个string中
     *
     * @return
     */
    private String getContentFromFile() {

        readLock.lock();
        File file = getLogFile();
        StringBuffer buffer = new StringBuffer();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferReader = new BufferedReader(reader);
            String str = bufferReader.readLine();
            while (null != str) {
                buffer.append(str);
                str = bufferReader.readLine();
            }
            reader.close();
            bufferReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(mContext, "文件不存在！", Toast.LENGTH_SHORT).show();
            return null;
        } finally {
            readLock.unlock();
        }

        return buffer.toString();
    }

    /**
     * 得到log的位置
     *
     * @return
     */
    private File getLogFile() {

        File file = new File(mContext.getExternalFilesDir(null), "iqiyiLog.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        return file;
    }
}
