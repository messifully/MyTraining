package com.learnboot.demo.test.proxy;

import com.learnboot.demo.proxy.CSStudy;
import com.learnboot.demo.proxy.IStudy;
import com.learnboot.demo.proxy.ProxyStudy;

public class TestDynamicProxy {

    public static void main(String[] args) {
        IStudy iStudy = new CSStudy("fang");
        ProxyStudy proxyStudy = new ProxyStudy();
        IStudy proxy = (IStudy)proxyStudy.getProxy(iStudy);
        proxy.study("huajie");
        proxy.learn("huajie");

    }
}
