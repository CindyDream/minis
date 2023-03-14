package com.minis.beans;

import com.minis.exception.NoSuchBeanDefinitionException;


public interface BeanFactory {

    Object getBean(String beanName) throws NoSuchBeanDefinitionException;

    void registerBeanDefinition(BeanDefinition beanDefinition);

}
