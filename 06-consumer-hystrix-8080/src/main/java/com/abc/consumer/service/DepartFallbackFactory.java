package com.abc.consumer.service;

import com.abc.consumer.bean.Depart;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 服务降级处理类，该类需要实现FallbackFactory接口，其泛型为该服务降级类所对应的Feign接口
 */
@Component
public class DepartFallbackFactory implements FallbackFactory<DepartService> {
    @Override
    public DepartService create(Throwable throwable) {
        return new DepartService() {

            @Override
            public boolean saveDepart(Depart depart) {
                System.out.println("执行saveDepart()的服务降级处理方法");
                return false;
            }

            @Override
            public boolean removeDepartById(int id) {
                System.out.println("执行removeDepartById()的服务降级处理方法");
                return false;
            }

            @Override
            public boolean modifyDepart(Depart depart) {
                System.out.println("执行modifyDepart()的服务降级处理方法");
                return false;
            }

            // fallbackFactory的优先级高于fallbackMethod的
            @Override
            public Depart getDepartById(int id) {
                System.out.println("执行getDepartById()的服务降级处理方法");
                Depart depart = new Depart();
                depart.setId(id);
                depart.setName("no this depart -- 类级别");
                depart.setDbase("no this db -- 类级别");
                return depart;
            }

            @Override
            public List<Depart> listAllDeparts() {
                System.out.println("执行listAllDeparts()的服务降级处理方法");
                return null;
            }
        };
    }
}
