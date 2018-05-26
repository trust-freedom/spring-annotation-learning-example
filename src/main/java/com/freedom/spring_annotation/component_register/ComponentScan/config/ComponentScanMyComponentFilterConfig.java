package com.freedom.spring_annotation.component_register.ComponentScan.config;

import com.freedom.spring_annotation.component_register.ComponentScan.filter.MyComponentFilter;
import com.freedom.spring_annotation.component_register.ComponentScan.service.BookService;
import com.freedom.spring_annotation.component_register.Configuration_Bean.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * 配置类==配置文件
 * 告诉Spring这是一个配置类
 */
@Configuration
@ComponentScan(value = "com.freedom.spring_annotation.component_register.ComponentScan",
               includeFilters = {
                   @Filter(type=FilterType.CUSTOM, classes={MyComponentFilter.class})
               },
               useDefaultFilters = false)     //必须配合useDefaultFilters=false使用，即禁用默认的Filter，否则还是会按照包扫描，XML配置也是
//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型
//FilterType.ASPECTJ：使用ASPECTJ表达式
//FilterType.REGEX：使用正则指定
//FilterType.CUSTOM：使用自定义规则
public class ComponentScanMyComponentFilterConfig {

    /**
     * 给容器中注册一个Bean
     * Bean类型为返回值的类型，默认使用方法名作为bean id
     * 也可以在@Bean指定组件id
     * @return
     */
    @Bean("person02")
    public Person person01() {
        return new Person("lisi", 20);
    }


}
