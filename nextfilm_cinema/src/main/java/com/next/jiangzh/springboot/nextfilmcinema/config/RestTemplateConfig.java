package com.next.jiangzh.springboot.nextfilmcinema.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced // Eureka|Ribbon 在RestTemplate内部嵌入了一个拦截器 -> LoadBalancerClient
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
