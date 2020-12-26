package com.learnboot.demo.test.algorithm.basics.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class BucketSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 9, 11, 8, 67, 3, 4, 2, 32 };
        buckedSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void buckedSort(int[] arr) {
        int max=arr[0];
        int min=arr[0];
        for (int i: arr) {
            if (max<i){
                max=i;
            }
            if (min>i){
                min=i;
            }
        }
        //桶个数
        //映射规则为：f(x)=\frac x{10}-c，其中常量位：c=\frac {min}{10}，即以间隔大小 10 来区分不同值域
        int buckedNum=(max-min)/10+1;
        ArrayList<ArrayList<Integer>> buckedList = new ArrayList<>(buckedNum);
        for (int i=0;i<buckedNum;i++) {
            buckedList.add(new ArrayList<>());
        }
        // 将每个元素放入桶
        for (int value: arr) {
            buckedList.get((value-min)/10).add(value);
        }
        // 对每个桶进行排序
        for (ArrayList list : buckedList) {
            Collections.sort(list);
        }
        // 将桶中的元素赋值到原序列
        int tmp=0;
        for (int i=0;i<buckedList.size();i++){
            for (int j : buckedList.get(i)){
                arr[tmp++]=j;
            }
        }
    }
}
