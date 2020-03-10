package com.w.cn.队列;

import java.util.Scanner;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-10-20:38
 * 队列 先进先出的一种线性数据结构
 *
 * 允许再队尾添加元素、队首删除元素
 *
 * 可以i使用数组和链表来实现
 *
 *
 *
 * 队列本身是有序列表，若使用数组的结构来存储队列的数据，其中 maxSize 是该队列的最大容量。
 *
 * 因为队列的输出、输入是分别从前后端来处理，
 * 因此需要两个变量 front及 rear分别记录队列前后端的下标，
 * front 会随着数据输出而改变，而 rear则是随着数据输入而改变
 *
 * 当我们将数据存入队列时称为”addQueue”，addQueue 的处理需要有两个步骤：思路分析
 * 将尾指针往后移：rear+1 , 当front == rear 【空】
 * 若尾指针 rear 小于队列的最大下标 maxSize-1，则将数据存入 rear所指的数组元素中，否则无法存入数据。 rear  == maxSize - 1[队列满]
 *
 *
 *
 * 问题：
 *      第一次添加满队列后。情空队列。front == rear ==2; 不能复用数组
 * 优化;
 *      将这个数组使用算法，改进成一个环形的队列  取模 %
 */
public class ArrayQueue {
    private int maxSize;//数组最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int [] arr;//数组模拟队列
    //初始化队列
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        front = -1; //指向队列的头，是指向队列头的前一个位子
        rear = -1;  //指向队列的尾部，指向队列尾的数据--就是队列的最后一个数据
        arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean idFull(){
        return rear==maxSize-1;
    }
    //判断是否空
    public boolean isEmpty(){
        return rear==front;
    }

    //添加数据到队列
    public void addQueue(int n){
        //判断是否满
        if(idFull()){
            throw new RuntimeException("队列为空，不能读取数据");
        }
        rear++;
        arr[rear] = n;
    }

    public int pick(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能读取数据");
        }
        front++;//头指针后移
        return arr[front];
    }

    public int geHeadQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能读取数据");
        }
        return arr[front+1];
    }

    public void showListQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能读取数据");
        }
        for (int i = 0;i<arr.length;i++
             ) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }


    public static void main(String[] args) {
        boolean loop =true;
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner sc = new Scanner(System.in);
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key=sc.next().charAt(0);//接收一个字符
            try {
                switch (key){
                    case 's':
                            arrayQueue.showListQueue();
                        break;
                    case 'e':
                        sc.close();
                        loop =false;
                        break;
                    case 'a':
                        int data = sc.nextInt();
                        arrayQueue.addQueue(data);
                        break;
                    case 'g':
                        int pick = arrayQueue.pick();
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
