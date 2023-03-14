package com.minis.context;

import com.minis.beans.BeanDefinition;
import com.minis.beans.BeanFactory;
import com.minis.beans.SimpleBeanFactory;
import com.minis.beans.XmlBeanDefinitionReader;
import com.minis.core.ClassPathXmlResource;
import com.minis.core.Resource;
import com.minis.exception.NoSuchBeanDefinitionException;


public class ClassPathXmlApplicationContext implements BeanFactory {

    BeanFactory beanFactory;

    public ClassPathXmlApplicationContext(String fileName) {
        Resource resource = new ClassPathXmlResource(fileName);
        BeanFactory bf = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(bf);
        reader.loadBeanDefinitions(resource);
        this.beanFactory = bf;
    }

    @Override
    public Object getBean(String beanName) throws NoSuchBeanDefinitionException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanFactory.registerBeanDefinition(beanDefinition);
    }

}
