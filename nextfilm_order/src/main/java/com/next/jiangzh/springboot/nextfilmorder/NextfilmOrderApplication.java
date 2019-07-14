package com.next.jiangzh.springboot.nextfilmorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.next.jiangzh.springboot.nextfilmorder.dao.mapper"})
public class NextfilmOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NextfilmOrderApplication.class, args);
    }

}
