package com.learnboot.demo.test.proxy;

import com.learnboot.demo.proxy.Person;
import com.learnboot.demo.proxy.PersonInvocationHandler;
import com.learnboot.demo.proxy.SoftwareEngineer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class TestProxy {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Person person = new SoftwareEngineer("fang");
        InvocationHandler handler = new PersonInvocationHandler<>(person);
        Class<?> proxyClass = Proxy.getProxyClass(Person.class.getClassLoader(), new Class[]{Person.class});
        System.out.println("package = " + proxyClass.getPackage() + " SimpleName = " + proxyClass.getSimpleName() + " name =" + proxyClass.getName() + " CanonicalName = " +                "" + proxyClass.getCanonicalName() + " 实现的接口 Interfaces = " + Arrays.toString(proxyClass.getInterfaces()) +                " superClass = " + proxyClass.getSuperclass() + " methods =" + Arrays.toString(proxyClass.getMethods()));        // 3、  通过 proxyClass 获得 一个带有InvocationHandler参数的构造器constructor
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        Person p = (Person)constructor.newInstance(handler);
        p.goWorking(p.getName(),"武汉");
//        Person o = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, handler);
//        p.goWorking(p.getName(),"上海");
    }


}
