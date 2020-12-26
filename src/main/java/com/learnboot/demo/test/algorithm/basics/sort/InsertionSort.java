package com.learnboot.demo.test.algorithm.basics.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 9, 11, 8, 67, 3, 4, 2, 32 };
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        for (int i=1;i<arr.length;i++) {
            int temp = arr[i];
            int j;
            //待排序元素比前一个小时才插入，否则不插入
            if (arr[i]<arr[i-1]){
                for (j=i-1;j>=0;j--) {
                    if (arr[j]>temp){
                        arr[j+1]=arr[j];
                    }else {
                        break;
                    }
                }
                arr[j+1]=temp;
            }
        }
    }
}
