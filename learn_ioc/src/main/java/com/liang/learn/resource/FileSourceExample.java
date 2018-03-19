package com.liang.learn.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileSourceExample {
    public static void main(String[] args) {

        try {
            String filePath = "/home/bonjour/Desktop/file1";

            //1.使用系统文件路径方式加载文件
            WritableResource resource1 = new PathResource(filePath);

            //2.使用类路径方式加载文件
            Resource resource2 = new ClassPathResource("conf/file2");

            //3.使用writableResource接口写资源文件
            OutputStream stream1 = resource1.getOutputStream();
            stream1.write("欢迎光临\n小春论坛".getBytes());

            //4.使用Resource读取资源文件
            InputStream ins1 = resource1.getInputStream();
            InputStream ins2 = resource2.getInputStream();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int i ;
            while ((i = ins1.read()) != -1){
                baos.write(i);
            }

            System.out.println(baos.toString());

            System.out.println("res1:"+resource1.getFilename());
            System.out.println("res2:"+resource2.getFilename());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }


    }


}
