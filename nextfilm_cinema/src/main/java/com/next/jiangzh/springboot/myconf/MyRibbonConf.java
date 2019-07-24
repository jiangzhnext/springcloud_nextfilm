package com.next.jiangzh.springboot.myconf;

import com.netflix.loadbalancer.IRule;
import com.next.jiangzh.springboot.nextfilmcinema.config.MyRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRibbonConf {

    @Bean
    public IRule iRule(){
        System.out.println("==============");
        return new MyRule();
    }

}
