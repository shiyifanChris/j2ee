package com.syf.sort;

import java.util.Arrays;

/**
 * Created by dell
 * at 2018/3/27
 * 快排  O(nlogn)
 * 先选取标杆  大的一侧，小的一侧，再换标杆  运用递归
 */
public class QuickSort {

    public static void sort(int[] sources,int low,int high){
        if(low < high){
            int key = sources[low];//此轮比较的key,左边比key大,右边比key小.
            int l = low;
            int h = high;
            int tmp;
            while(l < h){
                //因为我们不能创建额外的数组,所以才取了"交换"数据的方式.
                //从右边开始,将比key大的交换到过来.
                while(l < h && sources[h] >= key){
                    h--;
                }
                //右边找到了比key大的.
                if(l < h){
                    //交换顺序
                    tmp = sources[l];
                    sources[l] = sources[h];
                    sources[h] = tmp;
                }
                //从左边开始,将比key小的交换过来
                while(l < h && sources[l] <= key){
                    l++;
                }
                if(l < h){
                    tmp = sources[l];
                    sources[l] = sources[h];
                    sources[h] = tmp;
                    }
                }
            sort(sources, low, l-1);
            sort(sources, l+1, high);
            }
         }

        public static void main(String[] args) {
            int[] sources = {2,9,21,1,-3,11};
            sort(sources, 0, sources.length -1);
            System.out.println(Arrays.toString(sources));
        }
}
