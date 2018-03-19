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
 *
 *     类装载工作由ClassLoader及其子类负责.
 *     ClassLoad是一个重要的的Java运行时系统组件。负责在运行时查找和装入Class字节码文件。
 *     JVM在运行时会产生3个ClassLoad：根装载器，扩展类装载器，应用类装载器。
 *     注意： 根装载器不是ClassLoad的子类，它是由C++语言编写，因此无法在Java中获取到它的句柄。
 *
 *     根装载器负责装载JRE核心类库，如JRE下的 rt.jar,charsets.jar等.
 *     扩展类装载器（ExtClassLoader） 和应用类装载器（AppClassLoader）都是ClassLoader的子类，
 *     扩展类装载器负责装载JRE扩展目录ext 中的JAR类包; 应用类装载器负责装载CLassPath 路径下的类包。
 *
 *     这三个类装载器之间存在父子层级关系。即根装载器是扩展类装载器的父类，扩展类装载器是应用类装载器的父类。
 *     在默认情况下，使用应用类装载器装载应用程序的类。
 *
 *     JVM装载类时使用“全盘负责委托机制”,  "全盘负责"是指当一个ClassLoader装载一个类时，除非显示的使用另一个ClassLoader，
 *     否则该类及其引用的类也是由这个ClassLoader载入。
 *     "委托机制" 是指 先委托父装载器类寻找目标类，只有在找不见的情况下才从自己的类路径中查找并装载目标类。避免恶意的类装载。
 *
 *     JVM的"全盘委托机制"可能会引发 java.lang.NuSuchMethodError. 引起错误的原因是在类的加载目录下可能存在多个版本jar包。
 *
 */
public class ClassLoadTest {
    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("current loader:"+loader);
        System.out.println("parent loader:"+loader.getParent());
        System.out.println("grandparent loader:"+loader.getParent().getParent());
    }
}
