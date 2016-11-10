package com.example.zhenzhen.handdraw;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * Created by zhenzhen on 16/8/2.
 */
public class HandlerTest extends Activity{


    private Handler mHandler;
    private MyRunnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Runnable ab = new Runnable() {
            @Override
            public void run() {

            }
        };

         runnable = new MyRunnable();


        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                return false;
            }
        }){

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };

    }


    public class myThread extends Thread{
        @Override
        public void run() {
            Looper.prepare();
            mHandler = new Handler(){
                @Override
                public void handleMessage(Message msg) {

                }
            };
            Looper.loop();
        }
    }



    public class MyRunnable implements Runnable {

        @Override
        public void run() {

            mHandler.postDelayed(runnable, 1000);
        }
    }
}
