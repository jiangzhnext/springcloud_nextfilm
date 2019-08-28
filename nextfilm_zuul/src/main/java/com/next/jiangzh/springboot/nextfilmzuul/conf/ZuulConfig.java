package com.next.jiangzh.springboot.nextfilmzuul.conf;

import com.next.jiangzh.springboot.nextfilmzuul.filters.CommonErrorFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {

    @Bean
    public CommonErrorFilter commonErrorFilter(){
        return new CommonErrorFilter();
    }

}
