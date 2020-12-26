package com.learnboot.demo.test.algorithm.basics.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 9, 11, 8, 67, 3, 4, 2, 32 };
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        //构建大顶堆
        for (int i = arr.length/2-1;i>=0;i--) {
            adjustHeap(arr,i,arr.length);
        }
        //调整
        for (int j = arr.length-1;j>0;j--) {
            swap(arr,0,j);
            //已经是大顶堆了，那么只需将堆顶元素下沉就可以了，仍然是大顶堆
            adjustHeap(arr,0,j);
        }
    }

    private static void adjustHeap(int[] arr, int i, int len) {
        int tmp = arr[i];
        for (int k = 2*i+1;k<len;k=2*k+1) {
            if (k+1<len && arr[k+1] >arr[k]) {
                k++;
            }
            if (tmp<arr[k]) {
                arr[i]=arr[k];
                //这个的目的在于将起始位重置
                i=k;
            }
        }
        arr[i]=tmp;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

}
