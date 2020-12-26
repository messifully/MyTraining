package com.learnboot.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class PersonInvocationHandler<T> implements InvocationHandler {

    T target;

    public PersonInvocationHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("被动态代理类回调执行, 代理类 proxyClass ="+proxy.getClass()+
//                " 方法名: " + method.getName() +
//                "方法. 方法返回类型："+method.getReturnType()
//                +" 接口方法入参数组: "+(args ==null ? "null" : Arrays.toString(args)));
        for (int i = 0; i < 1; i++) {
            System.out.println("前置任务");
        }
        Object result = method.invoke(target, args);
        System.out.println("被代理类方法执行完毕");
        System.out.println("后置任务");
        return result;
    }
}
