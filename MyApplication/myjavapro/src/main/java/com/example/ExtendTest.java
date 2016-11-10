package com.example;

/**
 * Created by zhenzhen on 16/8/15.
 */
public class ExtendTest extends FatherTest{
    public String sonPublicName = "I am public son name";

    @Override
    protected void protectedRun() {
        System.out.print("This is a public son run");

    }

    public static void main(String[] args) {
        ExtendTest son = new ExtendTest();
        FatherTest father = new ExtendTest();
        father.protectedRun();
        son.protectedRun();
        FatherTest fatherTest = new FatherTest();
        //深刻理解什么叫类访问权限.new出的那个对象竟然都无法使用那个变量,仅仅只能在那个类中使用
        //fatherTest.name
    }

}
