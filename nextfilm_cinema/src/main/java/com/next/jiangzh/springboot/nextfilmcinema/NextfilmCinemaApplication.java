package com.next.jiangzh.springboot.nextfilmcinema;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.next.jiangzh.springboot.nextfilmcinema.dao.mapper"})
public class NextfilmCinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(NextfilmCinemaApplication.class, args);
    }

}
