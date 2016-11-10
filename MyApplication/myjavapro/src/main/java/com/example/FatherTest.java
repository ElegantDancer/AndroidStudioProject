package com.example;

/**
 * Created by zhenzhen on 16/8/15.
 */
public class FatherTest {

    private String name="I am your father";
    public String publicName = "I am father public name";


    public void publicRun(){
        System.out.print("This is a public father run");
    }

    private void privateRun(){
        System.out.print("This is a private father run");

    }

    protected void protectedRun(){
        System.out.print("This is a protected father run");

    }
}
