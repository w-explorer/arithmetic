package com.w.cn.队列;

import java.util.Scanner;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-10-22:59
 * * 问题：
 * *      第一次添加满队列后。情空队列。front == rear ==2; 不能复用数组
 * * 优化;
 * *      将这个数组使用算法，改进成一个环形的队列  取模 %
 * <p>
 * 环形数组队列
 * <p>
 * 有效数据个数：
 * (rear + maxSize - front) % maxSize
 */
public class AnnularArrayQueue {
    private int maxSize;//数组最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//数组模拟队列

    //初始化队列
    public AnnularArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
//        front = 0; //指向队列的头，是指向队列头的0位子
//        rear = 0;  //指向队列的尾部后一个位置，因为希望空出一个空间做为约定.  作为动态变换的位置   因为都是0就不需要初始化了
        arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean idFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断是否空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断是否满
        if (idFull()) {
            throw new RuntimeException("队列为空，不能读取数据");
        }
        //直接将数据加入
        arr[rear] = n;
        //将rear后移，必须考虑取模
        rear = (rear + 1) % maxSize;

    }

    public int peek() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能读取数据");
        }
        //需要分许front是指向队列的第一个元素
        //1.需要将front的数值保存到临时变量
        //2.将front 后移
        //3.将临时变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public int geHeadQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能读取数据");
        }
        return arr[front];
    }

    public void showListQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能读取数据");
        }
        //从front开始遍历 ，遍历多少个元素   一共
        for (int i = front; i < front+(rear+maxSize-front)%maxSize; i++) {
            System.out.printf("arr[%d]=%d\n", i%maxSize, arr[i%maxSize]);
        }
    }


    public static void main(String[] args) {
        boolean loop = true;
        AnnularArrayQueue arrayQueue = new AnnularArrayQueue(4); //说明设置，其队列的有效数据做大是3
        char key = ' ';
        Scanner sc = new Scanner(System.in);
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = sc.next().charAt(0);//接收一个字符
            try {
                switch (key) {
                    case 's':
                        arrayQueue.showListQueue();
                        break;
                    case 'e':
                        sc.close();
                        loop = false;
                        break;
                    case 'a':
                        int data = sc.nextInt();
                        arrayQueue.addQueue(data);
                        break;
                    case 'g':
                        int pick = arrayQueue.peek();
                        System.out.printf("出队数据是%d\n", pick);
                        break;
                    case 'h':
                        System.out.printf("队列头的数据是%d\n", arrayQueue.geHeadQueue());
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

