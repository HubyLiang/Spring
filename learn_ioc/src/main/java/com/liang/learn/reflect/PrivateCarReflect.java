package com.liang.learn.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrivateCarReflect {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class<?> clazz = loader.loadClass("com.liang.learn.reflect.PrivateCar");
        PrivateCar pcar = (PrivateCar) clazz.newInstance();
        Field colorFild = clazz.getDeclaredField("color");

        System.out.println(colorFild.toString());

        //1.取消Java语言访问检查以访问private变量
        colorFild.setAccessible(true);
        colorFild.set(pcar,"红色");

        Method driveMtd = clazz.getDeclaredMethod("drive", (Class[]) null);

        driveMtd.setAccessible(true);
        driveMtd.invoke(pcar,(Class[])null);


    }
}
