package com.iqiyi.zhenzhen.singleinstancedemo;


/**
 * Created by zhenzhen on 2016/11/2.
 */

public class CustomPlayer {

    private String name = "test";

    private static CustomPlayer ourInstance = new CustomPlayer();

    public static CustomPlayer getInstance() {
        return ourInstance;
    }

    private CustomPlayer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
