package com.stminds.algorithm.divide;

/**
 * 求解n次幂
 *
 * @author harvest
 * @version 1.0
 * @date 2022-01-11 23:28
 */
public class NthPower {
    public static void main(String[] args) {
        //answer 1
        long start1 = System.nanoTime();
        long multiply1 = multiply1(2, 31);
        long start2 = System.nanoTime();
        System.out.println(start2 - start1);//1500
        long start3 = System.nanoTime();
        long multiply2 = multiply2(2, 31);
        System.out.println(System.nanoTime() - start3);//1200
        long start4 = System.nanoTime();
        double multiply3 = multiply3(2, 31);
        System.out.println(System.nanoTime() - start4);//91900
        long start5 = System.nanoTime();
//        double multiply5 = multiply4(2, 31);
        System.out.println(System.nanoTime() - start5);//
    }
    
    private static double multiply4(int x, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("the 'n' can't < 0 ");
        }
        if (n == 0) {
            return 1;
        }
        // TODO: 2022/1/11
        return 1;
    }
    
    private static double multiply3(int x, int y) {
        return Math.pow(x, y);
    }
    
    private static long multiply2(int x, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("the 'n' can't < 0 ");
        }
        if (n == 0) {
            return 1;
        }
        return x * multiply2(x, n - 1);
    }
    
    private static long multiply1(int x, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("the 'n' can't < 0 ");
        }
        if (n == 0) {
            return 1;
        }
        long tmp = 1;
        for (int i = 0; i < n; i++) {
            tmp *= x;
        }
        return tmp;
    }
}
