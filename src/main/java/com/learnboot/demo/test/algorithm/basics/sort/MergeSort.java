package com.learnboot.demo.test.algorithm.basics.sort;

import java.util.Arrays;

public class MergeSort {


    public static void main(String[] args) {
        int[] arr = new int[] { 4, 9, 11, 8, 67, 3, 4, 2, 32 };
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void mergeSort(int[] arr) {
        sort(arr,0,arr.length-1);
    }

    private static void sort(int[] arr, int left, int right) {
        //递归终止条件，分区只有一个元素时栈帧不再push，开始pop。
        if (left>=right) {
            return;
        }
        //中间元素指针
        int mid = (left+right)/2;
        //分别将左右分区排序
        sort(arr,left,mid);
        sort(arr,mid+1,right);
        //实际上上面只做了分区，没有做排序，现在只需要将分区排序好，那么就可以保证下一次的调用每个分区有序
        merge(arr,left,mid,right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int[] tmpArr = new int[arr.length];
        int rStart = mid+1;
        int lStart = left;
        int tmpIndex= left;
        while (lStart<=mid && rStart<=right) {
            if (arr[lStart]<=arr[rStart]) {
                tmpArr[tmpIndex++] = arr[lStart++];
            }else {
                tmpArr[tmpIndex++] = arr[rStart++];
            }
        }
        while (lStart<=mid){
            tmpArr[tmpIndex++]=arr[lStart++];
        }
        while (rStart<=right){
            tmpArr[tmpIndex++]=arr[rStart++];
        }
        //tmpArr为有序数组，再赋值回原数组
        while (left<=right){
            //这个位置不能++2次
            arr[left]=tmpArr[left++];
        }
    }
}
