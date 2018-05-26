package com.freedom.spring_annotation.component_register.ComponentScan.filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyComponentFilter implements TypeFilter {

    /**
     *
     * @param metadataReader  读取到的当前正在扫描的类的信息
     *                           getResource()  -  Return the resource reference for the class file
     *                           getClassMetadata()  -  Read basic class metadata for the underlying class
     *                           getAnnotationMetadata()  -  Read full annotation metadata for the underlying class,including metadata for annotated methods
     *
     * @param metadataReaderFactory  可以获取到其他任何类信息的
     *                                   getMetadataReader(String className)  -  Obtain a MetadataReader for the given class name
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源（类的路径）
        Resource resource = metadataReader.getResource();

        //类名包含Dao
        String className = classMetadata.getClassName();
        System.out.println("--->"+className);
        if(className.contains("Dao")){
            return true;
        }
        return false;
    }
}
