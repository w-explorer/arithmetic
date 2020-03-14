package com.w.cn.链表;

import java.util.LinkedList;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-12-16:38
 */
public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        String s = linkedList.get(2);
    }
}
