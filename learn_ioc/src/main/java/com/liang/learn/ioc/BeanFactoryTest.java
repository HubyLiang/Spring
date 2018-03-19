package com.liang.learn.ioc;

import com.liang.learn.bean.Car;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * XmlBeanFactory 在Spring 3.2已被废弃，建议使用XmlBeanDefinitionReader,DefaultListableBeanFactory.
 * Spring默认的BeanFactory是DefaultListableBeanFactory类，spring创建DefaultListableBeanFactory对象后，
 * 会把配置信息转换成一个一个的BeanDefinition对象，并把这些BeanDefinition对象注册到DefaultListableBeanFactory对象中，
 * 以供bean工厂创建bean实例。BeanDefinition对象存储的是单个bean的配置信息，比如依赖类、scope、是否延迟加载等等。
 */
public class BeanFactoryTest {

    @Test
    public void getBean() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:beans.xml");

        System.out.println(resource.getURL());
        System.out.println(resource.getURI());

        DefaultListableBeanFactory listableBeanFactory = new DefaultListableBeanFactory();

        /**
         * XmlBeanDefinitionReader 通过Resource装载Spring配置信息并启动Ioc容器，然后通过BeanFactory#getBean（beanName）
         * 方法从Ioc容器中获取Bean，
         */
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(listableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(resource);

        System.out.println("init BeanFactory.");
        Car car = listableBeanFactory.getBean("car", Car.class);
        System.out.println("car bean is ready for u");

        car.introduce();

    }
}
