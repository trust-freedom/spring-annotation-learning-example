package com.freedom.spring_annotation.component_register.ComponentScan;

import com.freedom.spring_annotation.component_register.ComponentScan.config.ComponentScanConfig;
import com.freedom.spring_annotation.component_register.ComponentScan.config.ComponentScanExcludeFilterConfig;
import com.freedom.spring_annotation.component_register.ComponentScan.config.ComponentScanIncludeFilterConfig;
import com.freedom.spring_annotation.component_register.ComponentScan.config.ComponentScanMyComponentFilterConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComponentScanTest {

    /**
     * 基于XML
     * 结果：
     * org.springframework.context.annotation.internalConfigurationAnnotationProcessor
     * org.springframework.context.annotation.internalAutowiredAnnotationProcessor
     * org.springframework.context.annotation.internalRequiredAnnotationProcessor
     * org.springframework.context.annotation.internalCommonAnnotationProcessor
     * org.springframework.context.event.internalEventListenerProcessor
     * org.springframework.context.event.internalEventListenerFactory
     * mainConfig
     * bookController
     * bookDao
     * bookService
     * person
     * person02
     * 除了IOC容器中自己要装配的一些组件外，还有
     * mainConfig    因为@Configuration注解包含@Component，也是一个组件
     * xml中定义了persion，mainConfig配置类定义了persion02
     */
    @Test
    public void testClassPathXmlApplicationContext(){
        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("beans2.xml");

        //IOC容器中定义了哪些Bean
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for(String definitionName : definitionNames){
            System.out.println(definitionName);
        }
    }

    /**
     * 基于配置类
     * 结果：
     * org.springframework.context.annotation.internalConfigurationAnnotationProcessor
     * org.springframework.context.annotation.internalAutowiredAnnotationProcessor
     * org.springframework.context.annotation.internalRequiredAnnotationProcessor
     * org.springframework.context.annotation.internalCommonAnnotationProcessor
     * org.springframework.context.event.internalEventListenerProcessor
     * org.springframework.context.event.internalEventListenerFactory
     * mainConfig
     * bookController
     * bookDao
     * bookService
     * person02
     */
    @Test
    public void testAnnotationConfigApplicationContext(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        //IOC容器中定义了哪些Bean
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for(String definitionName : definitionNames){
            System.out.println(definitionName);
        }
    }


    /**
     * excludeFilters测试
     * 结果：
     * IOC容器内置组件。。。
     * componentScanExcludeFilterConfig
     * bookDao
     * bookService
     * person02
     * 将ComponentScanConfig按照给定类型排除
     * 将bookController按照注解类型排除
     */
    @Test
    public void testComponentScanExcludeFilter(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanExcludeFilterConfig.class);

        //IOC容器中定义了哪些Bean
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for(String definitionName : definitionNames){
            System.out.println(definitionName);
        }
    }

    /**
     * includeFilters测试
     * 结果：
     * IOC容器内置组件。。。
     * componentScanIncludeFilterConfig
     * bookController
     * bookService
     * person02
     */
    @Test
    public void testComponentScanIncludeFilter(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanIncludeFilterConfig.class);

        //IOC容器中定义了哪些Bean
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for(String definitionName : definitionNames){
            System.out.println(definitionName);
        }
    }

    /**
     * 自定义组件过滤器，返回true则注册
     * 使用MyComponentFilter，虽然没有任何的@Component等注解，但由于是在扫描的包下，且符合类名包含Dao，就注册成了组件
     */
    @Test
    public void testComponentScanMyComponentFilter(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanMyComponentFilterConfig.class);

        //IOC容器中定义了哪些Bean
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for(String definitionName : definitionNames){
            System.out.println(definitionName);
        }
    }
    
}
