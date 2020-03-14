package com.w.cn.递归;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-14-18:01
 * 思路：
 * 递归-回溯   类似暴力算法
 * 约定：1 为放置皇后位置  0 为放置
 * 判断 位置是否合适
 *
 * 优化：贪心算法
 *
 */
public class EightQueue {
    int max =8;//定义共多少个皇后
    static int count = 0;//计数共多少次成功放置
    int arr[] = new int[max];//用于存放成功后的皇后的位置  角标为行数   值为列树  即【index】【value】为皇后的位置
    public static void main(String[] args) {
        EightQueue eightQueue = new EightQueue();
        eightQueue.put(0);//从第1个皇后开始放置
        System.out.printf("共%d种方法",count);
    }

    /**
     * 判断皇后位置是否满足
     * @param n  为放置的第n+1个皇后  n =0为第一个皇后
     * @return
     */
    public  boolean check(int n){
        for (int i = 0; i < n; i++) {  //i 表示行数
            //arr[i]==arr[n] 判断是否在同一列   Math.abs(n-1)==Math.abs(arr[n]-arr[i]) 结合正方形 长=宽 判断是否在同一斜线上
            if(arr[i] == arr[n]||Math.abs(n-i)==Math.abs(arr[n]-arr[i])){
                return false;
            }
        }
        return true;
    }

    /**
     * 放置皇后
     * 先考虑出口
     * @param n 皇后数量
     */
    public  void put(int n){
        if(n==max){//为第九个棋子
            count++;
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;//第N个皇后的位置   [n][i]
            if (check(n)){//检查放置的第几个皇后是否冲突
                //接着放置后面的皇后 开始递归
                put(n+1);
            }
        }
    }

    public  void print(){
        for (int i = 0; i < max; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
