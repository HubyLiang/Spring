package com.liang.learn;

/**
 * IOC的概念： 控制 + 反转
 *  对Spring而言，即某一接口的具体实现类的选择控制权从调用类中移除，转交给第三方决定，即由Spring 容器借由Bean配置来进行控制。
 * DI： 依赖注入
 *  让调用类对某一接口实现类的依赖关系由第三方（容器或协作类）注入，以一处调用类对某一接口实现类的依赖。
 * IOC的类型：
 *  构造函数注入，属性注入，接口注入
 *
 *
 */
public class MoAttack {

    private Geli geli;



    public void cityGateAsk(){
        //1. 演员直接侵入剧本
        LiuDeHua ldh = new LiuDeHua();
        ldh.responseAsk("墨者革离");

        //---------------------------------------
        //1.引入革离角色接口
        Geli geli = new LiuDeHua();
        //2.通过接口展开剧情
        geli.responseAsk("墨者革离");

    }
}
