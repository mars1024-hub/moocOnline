package com.xuecheng.manage_cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: Yizq
 * @data: 2020/4/12 16:45
 */
@SpringBootApplication
@EntityScan("com.xuecheng.framework.domain.cms") //扫描实体类
@ComponentScan(basePackages = {"com.xuecheng.api"}) //扫描接口
@ComponentScan(basePackages = {"com.xuecheng.manage_cms"}) //扫描本项目下所有的类
public class MangeCmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MangeCmsApplication.class, args);
    }

}
