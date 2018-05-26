package com.freedom.spring_annotation.component_register.Configuration_Bean;

import com.freedom.spring_annotation.component_register.Configuration_Bean.bean.Person;
import com.freedom.spring_annotation.component_register.Configuration_Bean.config.MainConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    /**
     * 传统的基于XML注册组件
     */
    @Test
    public void testClassPathXmlApplicationContext(){
        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("beans1.xml");
        Person person = (Person)applicationContext.getBean("person");
        System.out.println(person);
    }

    /**
     * 基于配置类 + @Bean注册组件
     */
    @Test
    public void testAnnotationConfigApplicationContext(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
//        Person person = (Person)applicationContext.getBean("person"); //通过组件id查找
//        System.out.println(person);

        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);  //通过类型查找BeanName
        for (String name : namesForType) {
            System.out.println(name);  //打印不同方式指定的组件id
        }
    }

    
}
