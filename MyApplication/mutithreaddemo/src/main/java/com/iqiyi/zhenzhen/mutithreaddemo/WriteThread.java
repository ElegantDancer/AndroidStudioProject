package com.iqiyi.zhenzhen.mutithreaddemo;

import com.google.gson.Gson;

public class WriteThread extends Thread{

    public static boolean isWriteThreadLive=false;//写日志线程是否已经在运行了

    public WriteThread() {
        isWriteThreadLive=true;
    }

    @Override
    public void run() {
        isWriteThreadLive=true;
        Gson gson=new Gson();
        while(!ActionLog.tempQueue.isEmpty()){//对列不空时
            try {
                //写日志到SD卡
                ActionLog.recordStringLog(gson.toJson(ActionLog.tempQueue.poll()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        isWriteThreadLive=false;//队列中的日志都写完了，关闭线程（也可以常开 要测试下）
    }
}
