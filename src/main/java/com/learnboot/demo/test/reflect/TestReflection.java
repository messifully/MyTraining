package com.learnboot.demo.test.reflect;

import com.learnboot.demo.entity.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestReflection {

    public void test01(Map<String, User> map, List<User> list){
    }
    public Map<Integer, User> test02(){
        return new HashMap<>();
    }

    public static void main(String[] args) {

        Class<?> clazz = null;
        try {
            clazz = Class.forName("com.learnboot.demo.entity.User");
            User user = (User)clazz.getConstructor().newInstance();
            Method setName = clazz.getDeclaredMethod("setName", String.class);
            setName.invoke(user,"fang");

            User u1 = (User) clazz.getDeclaredConstructor().newInstance();
            Field f = clazz.getDeclaredField("name");
            f.setAccessible(true);
            f.set(u1,"huajie");
            System.out.println(user.getName());
            System.out.println(u1.getName());


            Class clz=TestReflection.class;
            System.out.println("获得指定方法的泛型");
            Method m=clz.getMethod("test01", Map.class, List.class);
            //取得方法的所有参数类型
            Type[] t=m.getGenericParameterTypes();
            for (Type paramType:t){
                System.out.println("#"+paramType);
                //判断取得的参数是否为参数化类型
                if (paramType instanceof ParameterizedType){
                    //是的话将其强制转型并获得泛型的真正类型
                    Type[] genericTypes=((ParameterizedType) paramType).getActualTypeArguments();
                    for (Type genericType:genericTypes){
                        System.out.println("泛型类型："+genericType);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
