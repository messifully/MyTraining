package com.learnboot.demo.test.algorithm.basics.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] unsortedArray = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
        bubbleSort(unsortedArray);
        System.out.println(Arrays.toString(unsortedArray));
    }

    private static void bubbleSort(int[] array) {
        //从后开始遍历len-1次，每次都将最大的放在最后
        for (int i = array.length-1;i>0;i--) {
            //每次都交换最大的数在最后位
            for (int j = 0;j<i;j++) {
                if (array[j]>array[j+1]) {
                    int temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }
}
