package com.csl.springcloud.cfgbean;

import com.csl.myrule.RandomRule_LC;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
//        return new RoundRobinRule();
//        return new RandomRule();//达到目的，用我们重新选择的随机算法替代默认的轮询
//        return new RetryRule();
        return new RandomRule_LC();//自定义为每台机器5次
    }
}
