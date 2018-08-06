package com.my.mqtt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world!
 *
 */
@EnableEurekaClient //启动EnableEureka客户端
@SpringBootApplication
@EnableScheduling
public class MqttApp
{
    public static void main(String[] args) {
        SpringApplication.run(MqttApp.class, args);
    }
}
