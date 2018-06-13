package com.syf.sort;

/**
 * Created by dell
 * at 2018/3/27
 * 冒泡排序   O(n^2)
 */
public class BubbleSort {

    static void sort(int[] a){
        for (int i = 0,size = a.length; i <size-1 ; i++) {
            for (int j = 0; j <size-i-1 ; j++) {
                if(a[j]>a[j+1]){
                    a[j] = a[j+1]+a[j];
                    a[j+1] = a[j] - a[j+1];
                    a[j] = a[j]-a[j+1];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[]a = {1,9,4,3,5,2};
        sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
