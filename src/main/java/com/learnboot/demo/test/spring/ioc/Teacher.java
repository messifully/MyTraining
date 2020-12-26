package com.learnboot.demo.test.spring.ioc;

public class Teacher {
    private String course;

    public Teacher() {
        super();
        System.out.println("Teacher Bean的构造方法");
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
        System.out.println("Teacher Bean 属性注入");
    }
}
