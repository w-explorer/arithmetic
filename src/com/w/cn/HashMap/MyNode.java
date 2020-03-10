package com.w.cn.HashMap;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-10-14:50
 */
public class MyNode {
    private Object item;
    private MyNode next;

    public MyNode(Object item, MyNode next) {
        this.item = item;
        this.next = next;
    }

    public static void main(String[] args) {

        MyNode header = new MyNode(new Object(), null);
        MyNode node = new MyNode(new Object(), null);
        header.next=node;
        MyNode node1 = new MyNode(new Object(),header);
        header=node1;
    }
}
