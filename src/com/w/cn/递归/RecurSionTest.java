package com.w.cn.递归;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-14-16:08
 * 递归测试
 */
public class RecurSionTest {
    public static void main(String[] args) {
//        test(3);
        System.out.println(factorial(3));
    }
    //打印问题
    public static void test(int n){
        if(n>2){
            test(n-1);
        }
//        else
        System.out.println(n);
    }
    //阶乘
    public static int  factorial(int n){//3
        if(n==1){
            return 1;
        }
        else {
            return factorial(n-1)*n;//factorial(2)*3=>factorial(1)*2*3
        }
    }
}
