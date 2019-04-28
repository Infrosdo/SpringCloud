package com.kaikeba.provider.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
// 使用Hibernate映射机制生成数据库表，默认表名与实体类名相同
@Entity
// 1. 客户端与Controller间的数据通讯是通过JSON形式进行的，这个Java对象与JSON数据间的转换
// 工作是由SpringMVC的HttpMessageConverter接口完成的，确切地说是由Jackson对该接口的
// 实现类完成的。
// 2. Hibernate默认对所有查询结果开启了延迟加载策略。
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Depart {
    // 表示当前属性映射到表中为主键
    @Id
    // 主键是自动递增的
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String dbase;
}
