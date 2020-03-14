package com.w.cn.链表;

import java.util.Stack;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-12-16:24
 */
public class TestStack {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("1");
        stack.add("2");
        stack.add("3");
        while (stack.size()>0) System.out.println(stack.pop());
    }
}
