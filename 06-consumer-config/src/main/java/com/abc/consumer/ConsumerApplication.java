package com.abc.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker   // 开启服务降级
// 指定Service接口所在的包，开启OpenFeign客户端
@EnableFeignClients(basePackages = "com.abc.consumer.service")
@SpringBootApplication
@EnableEurekaClient
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    // 设置负载均衡算法为“随机算法”
   /* @Bean
    public IRule loadBalanceRule() {
        return new RandomRule();
    }*/

    // @Bean
    // public IRule loadBalanceRule() {
    //     // 指定要排除的Server的端口号
    //     List<Integer> ports = new ArrayList<>();
    //     ports.add(8082);
    //     return new CustomRule(ports);
    // }
}
