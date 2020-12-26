package com.learnboot.demo.test.algorithm.basics.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] unsortedArray = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
        quickSort(unsortedArray,0,unsortedArray.length-1);
        System.out.println(Arrays.toString(unsortedArray));
    }

    /**
     * 填坑法
     * @param arr
     * @param start
     * @param end
     */
    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = arr[start];
        int low = start;
        int high = end;
        while (low < high) {
            //从后面开始找
            //后面大于基准数的数不动
            //这里low < high条件必不可少，不然有可能会让high--一直执行下去，这里结束如果携程low<=high，那么赋值这步虽然没影响，但是low会继续向前推进，导致low>high
            while (arr[high] >= temp&&low < high) {
                high--;
            }
            //找到小于基准的数了，那就赋值给前面的坑.这里arr[low++]下标不可以随意向前推进，因为循环里面一次不能同时推进2次，否则会导致low>high
            arr[low]=arr[high];
            //再从前面开始找，推进前面坑位
            while (arr[low]<=temp&&low < high) {
                low++;
            }
            //找到大于基准的数了，那就赋值给后面的坑
            arr[high]=arr[low];
        }
        //循环出来时再将基准值赋给最后的坑，也就是分界线
        arr[high]=temp;
        //此时已经完成工作，左边小于等于base，右边大于等于base
        //递归时必须要让排序的数组变小，不让没办法走到数组的长度为1这个结束条件
        quickSort(arr,start,low-1);
        quickSort(arr,low+1,end);

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;
    }

}
