package com.w.cn.排序;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-14-20:40
 *
 * 冒泡排序
 *
 * 优化  当某一趟排序没有经行交换数时  就提前结束
 */
public class BubbleSort {
    static int arr[]={6,3,7,9,1,4,10,2};
    public static void main(String[] args) {
        //O（n^2）

        boolean flag = false;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    flag=true;
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            if(flag){
                System.out.printf("第%d躺排序后:\n",i);
                flag=false;
            }else {
                break;
            }
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
