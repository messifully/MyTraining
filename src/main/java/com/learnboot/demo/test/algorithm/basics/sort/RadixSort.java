package com.learnboot.demo.test.algorithm.basics.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = { 999999999, 65, 24, 47, 13, 50, 92, 88, 66, 33, 22445, 10001, 624159, 624158, 624155501 };
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        //获取最大值
        int max = getMax(arr);
        //获取最大值位数；
        int digit = getMaxDigit(max);
        List<ArrayList<Integer>> queue = new ArrayList<>();//多维数组
        initList(queue);
        for (int i=0;i<digit;i++) {
            for (int j=0;j<arr.length;j++) {
                //获取对应位的值（i为0是个位，1是十位，2是百位）
                int digitValue = arr[j]%(int)Math.pow(10,i+1)/(int)Math.pow(10,i);
                ArrayList list = queue.get(digitValue);
                list.add(arr[j]);
            }
            //开始收集，赋值到原数组
            int count = 0;
            for (int k=0;k<10;k++){
                for (int tmp: queue.get(k)){
                    arr[count++]=tmp;
                }
                queue.get(k).clear();
            }
        }
    }

    private static <T> void initList(List<ArrayList<T>> queue) {
        for (int i=0;i<10;i++){
            ArrayList<T> q = new ArrayList();
            queue.add(q);//由于数字的特殊性，大数组中要添加10个小数组；
        }
    }

    private static int getMaxDigit(int max) {
        int times = 0;
        while (max>0){
            max/=10;
            times++;//求取这个最大值的位数，依次除以10；直到为0；
        }
        return times;
    }

    private static int getMax(int[] arr) {
        int max = 0;
        for (int i=0;i<arr.length;i++){
            if (max<arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
}
