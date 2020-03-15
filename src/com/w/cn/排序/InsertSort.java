package com.w.cn.排序;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-14-21:32
 * <p>
 * 插入排序（Insertion Sorting）的基本思想是：
 * 把n个待排序的元素看成为一个有序表和一个无序表，
 * 开始时有序表中只包含一个元素，无序表中包含有n-1个元素，
 * 排序过程中每次从无序表中取出第一个元素，
 * 把它的排序码依次与有序表元素的排序码进行比较，
 * 将它插入到有序表中的适当位置，使之成为新的有序表
 */
public class InsertSort {
    static int arr[] = {6, 3, 7, 9, 1, 4, 10, 2};

    public static void main(String[] args) {
        insertionSort(arr);
    }

    /**
     * 插入排序
     *
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {
        int len;
        // 基本情况下的数组可以直接返回
        if (array == null || (len = array.length) == 0 || len == 1) {
            return array;
        }
        int current ;
        for (int i = 1; i < len; i++) {
            current = arr[i];//第一次已经有排序了  从第二个开始
            int preId = i-1;
            while (preId >=0 && current < arr[preId]) {  //因为目标数组时从小到大有序排列的 当current > 数组元素则停止
                arr[preId + 1] = arr[preId];//将大于目标值的元素前移
                preId--;
            }
            arr[preId + 1] = current;
            System.out.printf("第%d躺排序后:\n", i);
            print();
        }
        return array;
    }

    public static void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
