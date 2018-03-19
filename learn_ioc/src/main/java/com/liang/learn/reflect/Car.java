package com.liang.learn.reflect;

/**
 * 反射： Java语言编译成class文件后由类加载器装载后，在JVM中将形成一份描述Class结构的元信息对象。
 *       通过该元信息对象可以获知class的结构信息，例如构造函数，属性，方法等。Java允许用户借由
 *       与class相关的元信息对象间接的调用class对象的功能。即反射的创建对象。
 *
 */
public class Car {
    private String brand;
    private String color;
    private int maxSpeed;

    public Car() {
    }

    public Car(String brand, String color, int maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public void introduce(){
        System.out.println("Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}');
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
