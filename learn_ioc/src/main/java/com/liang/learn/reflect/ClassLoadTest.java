package com.liang.learn.reflect;

/**
 * 类装载器ClassLoader的工作机制：
 *     类装载器就是寻找类的字节码文件并构造出类在JVM内部表示对象的组件。
 *     在Java中，类装载器把一个类装进JVM中，大概需要经历：
 *     1. 装载：查找和导出Class文件。
 *     2. 链接：执行校验，准备，和解析步骤，其中解析步骤是可以选择的。
 *       1.校验：检查载入的CLass文件数据的正确性。
 *       2.准备：给类的静态变量分配存储空间。
 *       3.解析：将符号引用转换为直接引用。
 *     3.初始化：对类的静态变量，静态代码块执行初始化工作。
 */
public class ClassLoadTest {
    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("current loader:"+loader);
        System.out.println("parent loader:"+loader.getParent());
        System.out.println("grandparent loader:"+loader.getParent().getParent());
    }
}
