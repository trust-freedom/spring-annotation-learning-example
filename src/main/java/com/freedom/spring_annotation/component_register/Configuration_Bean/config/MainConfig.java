package com.freedom.spring_annotation.component_register.Configuration_Bean.config;

import com.freedom.spring_annotation.common.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类==配置文件
 * 告诉Spring这是一个配置类
 */
@Configuration
public class MainConfig {

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
