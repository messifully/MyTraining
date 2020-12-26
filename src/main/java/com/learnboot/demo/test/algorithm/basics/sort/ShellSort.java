package com.learnboot.demo.test.algorithm.basics.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int[] arr) {

        for (int gap = arr.length/2;gap>0;gap=gap/2){
            for (int i = gap;i<arr.length;i++) {
                if (arr[i-gap]>arr[i]) {
                    int tmp = arr[i];
                    int j;
                    for (j=i-gap;j>=0;j=j-gap) {
                        if (arr[j]>tmp) {
                            arr[j+gap]=arr[j];
                        }else {
                            break;
                        }
                    }
                    arr[j+gap]=tmp;
                }
            }
        }
    }
}
