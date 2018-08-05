package com.my.order;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@EnableEurekaClient //启动EnableEureka客户端
@SpringBootApplication
public class OrderApp
{
    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }
}