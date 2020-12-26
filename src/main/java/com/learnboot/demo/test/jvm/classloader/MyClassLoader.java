package com.learnboot.demo.test.jvm.classloader;

import java.util.concurrent.ConcurrentHashMap;

public class MyClassLoader {

    public static void main(String[] args) {
        System.out.println("ClassLodarDemo's ClassLoader is " + MyClassLoader.class.getClassLoader());
        System.out.println("String's ClassLoader is " + String.class.getClassLoader());
        ClassLoader classLoader;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<>();
    }

}

