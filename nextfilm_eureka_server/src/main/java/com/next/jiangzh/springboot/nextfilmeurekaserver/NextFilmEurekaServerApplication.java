package com.next.jiangzh.springboot.nextfilmeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NextFilmEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NextFilmEurekaServerApplication.class, args);
    }

}
