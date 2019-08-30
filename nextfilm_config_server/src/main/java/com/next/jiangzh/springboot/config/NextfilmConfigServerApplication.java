package com.next.jiangzh.springboot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class NextfilmConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NextfilmConfigServerApplication.class, args);
    }

}
