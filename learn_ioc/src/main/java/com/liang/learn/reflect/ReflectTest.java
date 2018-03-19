package com.liang.learn.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射创建Car对象
 * 反射中几个重要的类： ClassLoader,Class,Constructor,Method
 *
 */
public class ReflectTest {

    public static Car initByDefaultConst() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //1.通过类加载器获取Car对象
        //通过获取当前线程，然后通过指定全限定类名装载对应的类。
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class<?> clazz = loader.loadClass("com.liang.Car");

        //2.获取类的默认构造器对象并通过它实例化Car
        Constructor<?> constructor = clazz.getDeclaredConstructor((Class[]) null);
        Car car = (Car) constructor.newInstance();

        //3.通过反射设置属性
        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car,"SSK");

        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car,"Black");

        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car,200);

        return car;
    }

    public static void main(String[] args) throws Exception{
        Car car = initByDefaultConst();
        car.introduce();
    }
}
