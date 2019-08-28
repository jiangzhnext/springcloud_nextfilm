package com.next.jiangzh.springboot.nextfilmzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class NextfilmZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(NextfilmZuulApplication.class, args);
    }

}
