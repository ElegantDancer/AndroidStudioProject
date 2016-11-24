package com.iqiyi.zhenzhen.mutithreaddemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainActivity extends AppCompatActivity {


    private TextView mTextView;
    MyThread thread = new MyThread();
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.tet3);
        mContext = this;

        File file = new File(mContext.getFilesDir(), "log1.txt");

        if(file.exists()){
            file.delete();
        }

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer buffer = new StringBuffer();
                for(int i = 0; i< 100; i++){

                    IqiyiLog.getInstance(mContext).write("------>我写的文章--->:" + String.valueOf(i));
                }

                try {
                    buffer.append(IqiyiLog.getInstance(mContext).read());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mTextView.setText("得到的结果：" + buffer.toString());
            }
        });
    }

    public class MyProRundle implements Runnable {

        @Override
        public void run() {
            thread.produce();
        }
    }

    public class MyConsRunnable implements Runnable{

        @Override
        public void run() {
            thread.consume();
        }
    }

    private String getResult(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future future = executorService.submit(new MyCallable());
        executorService.submit(new MyConsRunnable());
        future.isDone();
        try {
            return String.valueOf(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return "失败了";
    }

    public class MyCallable implements Callable{

        @Override
        public Object call() throws Exception {
            return "heihei";
        }
    }
}
