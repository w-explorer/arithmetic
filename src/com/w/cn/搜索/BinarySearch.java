package com.w.cn.搜索;

import java.util.ArrayList;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-15-11:21
 *
 * 二分查找
 *
 * 数组是有序的
 *
 *
 * 课后思考：有多个相同数值时，全部返回
 * 1.找到 midValue 时  不用直接返回
 * 2.向mid 索引值的左边扫描，将满足的目标值，加入集合中
 * 3.向mid索引值右边扫描，将满足的目标这个i，加入集合中
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[]={1,2,2,4,5,7,8,10};
//        int i = binarySearch(arr, 0, arr.length - 1, 2);
//        System.out.println("结果角标为"+i);
        ArrayList<Integer> arrayList = binarySearch2(arr, 0, arr.length - 1, 2);
        System.out.println(arrayList);
    }

    /**
     *返回满足的  下角标集合
     * @param arr 数组
     * @param left 左边索引
     * @param right 右边索引
     * @param findValue 待查找值
     * @return
     */
    public static ArrayList<Integer> binarySearch2(int arr[], int left, int right, int findValue){

        //边界值 左边 right = 0 -1=-1;右边 left = arr.length-1 +
        if(left>right){
            return null;
        }
        //找到中间索引
        int mid = (left+right)/2;
        int midValue = arr[mid];
        if(findValue>midValue){ //向右递归
            return binarySearch2(arr,mid+1,right,findValue);
        } else if (findValue<midValue) {//向左递归
            return binarySearch2(arr,left,mid-1,findValue);
        }else { //findValue = minValue 则下角标就是该值
            ArrayList<Integer> list = new ArrayList<>();
            //向左边扫描
            int temp = mid -1;
            while (true){
               if(temp<0||arr[temp]!=arr[mid]){
                   break;
               }
               list.add(temp);
               temp--;
            }
            list.add(mid);//加入中间的mid
            //向右边扫描
            int rTemp = mid +1;
            while (true){
               if(rTemp>arr.length-1||arr[rTemp]!=arr[mid]){
                   break;
               }
               list.add(rTemp);
                rTemp++;
            }
            return list;
        }
    }
    /**
     *返回满足的值  只能返回一个
     * @param arr 数组
     * @param left 左边索引
     * @param right 右边索引
     * @param findValue 待查找值
     * @return
     */
    public static int binarySearch(int arr[], int left, int right, int findValue){

        //边界值 左边 right = 0 -1=-1;右边 left = arr.length-1 +
        if(left>right){
            return -1;
        }
        //找到中间索引
        int mid = (left+right)/2;
        int midValue = arr[mid];
        if(findValue>midValue){ //向右递归
            return binarySearch(arr,mid+1,right,findValue);
        } else if (findValue<midValue) {//向左递归
            return binarySearch(arr,left,mid-1,findValue);
        }else { //findValue = minValue 则下角标就是该值
            return mid;
        }
    }
}
