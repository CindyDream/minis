package com.minis.beans;

import com.minis.exception.NoSuchBeanDefinitionException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SimpleBeanFactory implements BeanFactory {

    private  List<BeanDefinition> beanDefinitions = new ArrayList<>();
    private List<String> beanNames = new ArrayList<>();
    private Map<String, Object> singletons = new HashMap<>();

    public SimpleBeanFactory() {

    }

    @Override
    public Object getBean(String beanName) throws NoSuchBeanDefinitionException {
        Object singleton = singletons.get(beanName);
        if (null != singleton) {
            return singleton;
        }
        int i = beanNames.indexOf(beanName);
        if (i == -1) {
            throw new NoSuchBeanDefinitionException();
        }
        BeanDefinition beanDefinition = beanDefinitions.get(i);

        try {
            singleton = Class.forName(beanDefinition.getClassName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        singletons.put(beanDefinition.getId(), singleton);
        return singleton;
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanDefinitions.add(beanDefinition);
        this.beanNames.add(beanDefinition.getId());
    }

}
