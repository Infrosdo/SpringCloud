package com.abc.consumer.codeconfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DepartCodeConfig {

    @LoadBalanced    // 开启消息者端的负载均衡功能，默认是轮询策略
    @Bean
    public IRule roundBalanceRule() {
        return new RandomRule();
    }
}
