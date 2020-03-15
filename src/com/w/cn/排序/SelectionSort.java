package com.w.cn.排序;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-09-21:00
 * 选择排序（select sorting）也是一种简单的排序方法。
 * 它的基本思想是：第一次从arr[0]~arr[n-1]中选取最小值，与arr[0]交换，
 * 第二次从arr[1]~arr[n-1]中选取最小值，与arr[1]交换，
 * 第三次从arr[2]~arr[n-1]中选取最小值，与arr[2]交换，…，
 * 第i次从arr[i-1]~arr[n-1]中选取最小值，与arr[i-1]交换，…,
 * 第n-1次从arr[n-2]~arr[n-1]中选取最小值，与arr[n-2]交换，总共通过n-1次，
 * 得到一个按排序码从小到大排列的有序序列。
 *
 * 选择排序：   最不理想的次数为  3(n-1)
 */
public class SelectionSort {
    static int arr[]={6,3,7,9,1,4,10,2};
    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i++) {
            //最小数的索引
            int minIndex = i;
            for(int j=i; j<arr.length; j++) {
                //找到最小数，并记录最小数的索引
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //交换符合条件的数
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
            System.out.printf("第%d躺排序后:\n",i);
            print();
        }
    }
    public static void print (){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
