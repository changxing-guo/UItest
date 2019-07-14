package com.uimanager.test;

class test1 {
    public void a() {
        System.out.println("test1");
    }
}
public class test extends test1{
    @Override
    public void a(){
        super.a();
        System.out.println("test");
    }

    public static void main(String[] args) {
        new test().a();
    }
}
