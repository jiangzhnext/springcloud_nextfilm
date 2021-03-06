package com.next.jiangzh.springboot.nextfilmcinema;

import com.next.jiangzh.springboot.myconf.MyRibbonConf;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableRetry
@EnableFeignClients
//@RibbonClient(name = "orderService",configuration = MyRibbonConf.class)
@MapperScan(basePackages = {"com.next.jiangzh.springboot.nextfilmcinema.dao.mapper"})
public class NextfilmCinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(NextfilmCinemaApplication.class, args);
    }

}
