package com.example;

public class MyJavaPro implements Cloneable{

    @Override
    protected MyJavaPro clone() throws CloneNotSupportedException {
        return (MyJavaPro)this.clone();
    }

    public static void main(String[] args) {
        System.out.printf("");
    }
}
