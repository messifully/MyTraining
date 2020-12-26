package com.learnboot.demo.test.algorithm.bitoperate;

import java.util.LinkedList;

public class BitOperate {

    public static void main(String[] args) {
        numberOfLeadingZeros(17);

    }

    /**
     * 代码就是找到数的最高位时第几位
     * @param i
     * @return
     */
    public static int numberOfLeadingZeros(int i) {
        // HD, Count leading 0's
        if (i <= 0)
            return i == 0 ? 32 : 0;
        int n = 31;
        System.out.println(Integer.toBinaryString(i));
        if (i >= 1 << 16) {
            n -= 16;
            i >>>= 16;
            System.out.println(Integer.toBinaryString(i));
        }
        if (i >= 1 << 8) {
            n -= 8;
            i >>>= 8;
            System.out.println(Integer.toBinaryString(i));
        }
        if (i >= 1 << 4) {
            n -= 4;
            i >>>= 4;
            System.out.println(Integer.toBinaryString(i));
        }
        if (i >= 1 << 2) {
            n -= 2;
            i >>>= 2;
            System.out.println(Integer.toBinaryString(i));
        }
        System.out.println(Integer.toBinaryString(i));
        int tmp = n - (i >>> 1);
        System.out.println(Integer.toBinaryString(tmp));
        System.out.println(tmp);
        return tmp;
    }
}
