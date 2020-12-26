package com.learnboot.demo.proxy;

public class CSStudy  implements IStudy{

    private String name;

    public CSStudy(String name) {
        this.name = name;
    }

    @Override
    public String study(String name) {
        System.out.println(this.name +"," + name +"正在学习CS");
        return "return";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void learn(String name) {
        System.out.println(this.name +"," + name +"正在leanCS");
    }
}
