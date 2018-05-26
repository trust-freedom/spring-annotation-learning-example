**@Configuration**

告诉Spring这是一个配置类

**@Bean**

给容器中注册一个Bean
Bean类型为返回值的类型，默认使用方法名作为bean id
也可以在@Bean指定组件id

https://docs.spring.io/spring/docs/4.3.9.RELEASE/spring-framework-reference/html/beans.html#beans-java-basic-concepts


**@ComponentScan**

value : 指定要扫描的包

excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除哪些组件

includeFilters = Filter[] ：指定扫描的时候只需包含哪些组件，需要配合useDefaultFilter=false使用
> FilterType.ANNOTATION：按照注解
> 
> FilterType.ASSIGNABLE_TYPE：按照给定的类型
> 
> FilterType.ASPECTJ：使用ASPECTJ表达式
> 
> FilterType.REGEX：使用正则指定
> 
> FilterType.CUSTOM：使用自定义规则，实现TypeFilter接口match()方法，返回Boolean代表当前类是否可以注册为组件

@ComponentScans 支持ComponentScan数组，可以指定多个扫描策略
