package com.w.cn.栈;

import java.util.Scanner;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-14-15:03
 *
 * 数据模拟栈  的入栈  出栈  遍历
 * 1.使用数组来模拟
 * 2.定义top 来表示栈顶  初始化为 -1
 * 3.入栈时，top++;stack[top]=data;
 * 4.出栈： top --;return stack[top+1];
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        boolean loop = true;
        ArrStack arrStack = new ArrStack(4); //说明设置，其队列的有效数据做大是3
        char key = ' ';
        Scanner sc = new Scanner(System.in);
        while (loop) {
            System.out.println("s(list): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(push): 添加数据到队列");
            System.out.println("g(pop): 从队列取出数据");
            key = sc.next().charAt(0);//接收一个字符
            try {
                switch (key) {
                    case 's':
                        arrStack.list();
                        break;
                    case 'e':
                        sc.close();
                        loop = false;
                        break;
                    case 'a':
                        int data = sc.nextInt();
                        arrStack.push(data);
                        break;
                    case 'g':
                        int pick = arrStack.pop();
                        System.out.printf("出队数据是%d\n", pick);
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("程序退出~~");
    }
}

class ArrStack{
    private int maxsize;//栈的大小
    private int top = -1;//top为栈顶  初始化为-1
    private int[] stack;//数组模拟栈，数据存在改数组中
    public ArrStack(int maxsize){
        this.maxsize = maxsize;
        stack = new int[maxsize];
    }
    //栈满

    public boolean isFull(){
        return top==maxsize-1;
    }

    //栈空
    public boolean isEmpty(){
        return top==-1;
    }

    /**
     * 入栈
     * @param value
     */
    public void push(int value){
        if(isFull()){
            System.out.println("栈满，不能添加");
            return;
        }
        top++;
        stack[top]=value;
    }

    /**
     * 出栈
     */
    public int pop(){
        if(isEmpty()){
            throw  new RuntimeException("栈空");
        }
        top --;
        return stack[top+1];
    }
    //遍历栈
    public void list(){
        if(isEmpty()){
            System.out.println("栈为空");
            return;
        }
        int temp = top;
        while (true){
            if(temp==-1){
                break;
            }
            System.out.printf("stack[%d]\n",stack[temp]);
            temp--;
        }
    }
}
