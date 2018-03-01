package com.smart.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //创建Rest服务
@EnableAutoConfiguration //对Spring框架进行自动配置
public class BbsDemo {

//    @RequestMapping("/")
//    public String index(){
//        return "欢迎光临论坛";
//    }

//    public static void main(String [] args){
//        SpringApplication.run(BbsDemo.class,args);
//    }
}
