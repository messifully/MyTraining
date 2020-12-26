package com.learnboot.demo.test.jvm.classloader;

public class ClassLoading {
    //实例化代码块.每次生成类实例,都会执行.并且,实例化代码块的执行 优先于 构造器.
    {
        System.out.println("blockA");
    }

    //静态语句块,在类初始化时,仅仅执行一次.
    static{
        System.out.println("blockB");
    }

    //类实例
    public static ClassLoading t1 = new ClassLoading();

    //构造器方法
    ClassLoading(){
        System.out.println("constructor");
    }


    public static void main(String[] args)
    {
        //类实例
        ClassLoading t2 = new ClassLoading();
    }
}
