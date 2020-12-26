package com.learnboot.demo.test.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        AbstractApplicationContext context = new FileSystemXmlApplicationContext
                ("C:/Users/JAYCE/MyGitHub/springboot/boot-1.0/src/main/java/com/learnboot/demo/test/spring/ioc/Beans.xml");
        Student student = (Student) context.getBean("student");
        Teacher teacher = (Teacher) context.getBean("teacher");
        System.out.println(student.getName());
        System.out.println(teacher.getCourse());
        context.registerShutdownHook();
    }
}
