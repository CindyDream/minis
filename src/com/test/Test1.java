package com.test;

import com.minis.ClassPathXmlApplicationContext;


public class Test1 {

    public static void main(String[] args)   {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        AService aservice=(AService)context.getBean("aservice");
        aservice.sayHello();
    }
}
