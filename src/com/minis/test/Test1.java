package com.minis.test;

import com.minis.context.ClassPathXmlApplicationContext;
import com.minis.exception.NoSuchBeanDefinitionException;


public class Test1 {

    public static void main(String[] args) throws NoSuchBeanDefinitionException {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        AService aservice=(AService)context.getBean("aservice");
        aservice.sayHello();
    }
}
