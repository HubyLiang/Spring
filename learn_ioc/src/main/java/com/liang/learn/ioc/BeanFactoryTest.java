package com.liang.learn.ioc;

import com.liang.learn.bean.Car;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

public class BeanFactoryTest {


    @Test
    public void getBean() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:beans.xml");

        System.out.println(resource.getURL());
        System.out.println(resource.getURI());

        DefaultListableBeanFactory listableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(listableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(resource);

        System.out.println("init BeanFactory.");
        Car car = listableBeanFactory.getBean("car", Car.class);
        System.out.println("car bean is ready for u");

        car.introduce();

    }
}
