package com.learnboot.demo.test.proxy;

import com.learnboot.demo.proxy.JavaStudy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TestCglibProxy {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(JavaStudy.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("前置方法");
                Object result = methodProxy.invokeSuper(o, objects);
                System.out.println("后置方法");
                return result;
            }
        });
        JavaStudy proxy = (JavaStudy)enhancer.create();
        proxy.study();
        proxy.rest();
    }
}
