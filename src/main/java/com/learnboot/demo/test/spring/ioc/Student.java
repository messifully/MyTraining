package com.learnboot.demo.test.spring.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Student implements BeanNameAware, BeanFactoryAware, ApplicationContextAware,InitializingBean, DisposableBean {
    private String name;
    private String id;

    public Student() {
        super();
        System.out.println("Student Bean的构造方法");
    }

    //    public Student(String name, String id) {
//        this.name = name;
//        this.id = id;
//        System.out.println("执行StudentBean 构造方法");
//    }

    public String getName() {
        System.out.println("StudentBean getName()方法" );
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("StudentBean name属性注入");
    }

    public String getId() {
        System.out.println("StudentBean getId()方法" );
        return id;
    }

    public void setId(String id) {
        System.out.println("StudentBean id属性注入");
        this.id = id;
    }


//    public void setName(String name){
//        this.name  = name;
//        System.out.println("StudentBean name属性注入");
//    }
//    public void getName(){
//        System.out.println("StudentBean getName()方法" );
//    }
//    public String getId() {
//        System.out.println("StudentBean getId()方法" );
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//        System.out.println("StudentBean id属性注入");
//    }



    public void init(){
        System.out.println("Student Bean 的自定义初始化init()方法");
    }
    public void myDestroy(){
        System.out.println("Student Bean 的自定义myDestroy()执行销毁");
    }


    //调用BeanNameAware的setBeanName()
    //传递Bean的ID。
    @Override
    public void setBeanName(String name) {
        System.out.println("调用BeanNameAware的setBeanName()..." + "参数"+name );
    }

    //调用BeanFactoryAware的setBeanFactory()
    //传递Bean的beanFactory。
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware的setBeanFactory()..."  + "参数"+beanFactory.getClass().getName() );
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("调用ApplicationContextAware的setApplicationContext..."  + "参数"+applicationContext.getClass().getName());

    }

    //调用InitializingBean的afterPropertiesSet()
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean的afterPropertiesSet()");
    }

    //调用DisposableBean的destroy()
    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean的destroy()");
    }
}
