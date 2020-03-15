package com.w.cn.排序;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-14-20:40
 *
 * 冒泡排序（Bubble Sorting）的基本思想是：通过对待
 * 排序序列从前向后（从下标较小的元素开始）,依次比较
 * 相邻元素的值，若发现逆序则交换，使值较大
 * 的元素逐渐从前移向后部，就象水底下的气泡一样逐渐
 * 向上冒。
 *
 * 因为排序的过程中，各元素不断接近自己的位置，如果一趟比较下
 * 来没有进行过交换，就说明序列有序，因此要在排序过程中设置
 * 一个标志flag判断元素是否进行过交换。从而减少不必要的比较。(这里说的优化，可以在冒泡排序写好后，在进行)
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
