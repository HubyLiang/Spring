package com.liang.learn.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Java反射机制
 *   Class反射对象描述类语义结构，可以从Class对象中获取构造函数，成员变量，方法等类元素的反射对象，并以编程的方式
 *   通过对这些反射对象对目标类进行操作。
 *   Constructor：类的构造函数反射类。通过 Class#getConstructors() 获取构造器数组。
 *   Method: 类方法反射类。 通过Class#getDeclaredMethods()方法获取类的所欲方法反射类数组。Method的主要方法是invoke(Object obj,Object[] args)
 *   Field: 类的成员变量的反射类。通过Class#getDeclaredField()方法获取类的成员变量的反射对象数组。主要方法是set(Obj obj,Obj value)
 *
 */
public class PrivateCar {

    private String color = "蓝色";

    private void drive(){
        System.out.println("drive private car! the color is:"+color);
    }

}
