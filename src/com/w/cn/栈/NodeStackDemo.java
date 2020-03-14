package com.w.cn.栈;

import java.util.Stack;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-14-15:24
 *
 * 单链表模拟栈
 * 1.带头节点的单链表
 * 2.head.next ==null //栈空
 * 3.入栈 链表尾部添加
 * 4.出栈 链表尾部出
 * 5.遍历 链表的倒叙  利用栈 stack 反转先进后出
 * 先正序插入在pop
 */
public class NodeStackDemo {
    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.push(node1);
        singleLinkedList.push(node2);
        singleLinkedList.push(node3);
        singleLinkedList.push(node4);
        singleLinkedList.list();
        singleLinkedList.pop();
        System.out.println("出栈后");
        singleLinkedList.list();
    }
}

class SingleLinkedList{
    private Node head = new Node(0,null);
    private Node getHead(){
        return head;
    }

    /**
     * 判断栈空
     * @return
     */
    public boolean isEmpty(){
        return head.getNext()==null?true:false;
    }

    /**
     * 入栈
     * @param node
     */
    public void push(Node node){
        if(isEmpty()){
            head.setNext(node);
            return;
        }
        Node cur = getLastNode();
        cur.setNext(node);
    }

    private Node getLastNode() {
        Node cur = head.getNext();
        while (true){
            if(cur.getNext()==null){
                break;
            }
            cur=cur.getNext();
        }
        return cur;
    }

    /**
     * 出栈
     */
    public void pop(){
        if(isEmpty()){
            System.out.println("栈空");
            return;
        }
        Node cur = head.getNext();
        while (true){
            if(cur.getNext().getNext()==null){
                break;
            }
            cur=cur.getNext();
        }
        System.out.println(cur.getNext()+"号出栈");
        cur.setNext(null);
    }

    /**
     * 遍历栈
     * 倒叙遍历单链表
     */
    public void list(){
        if (isEmpty()){
            System.out.println("栈为空");
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        Node cur = head.getNext();
        while (true){
            if(cur==null){
                break;
            }
            stack.push(cur);
            cur=cur.getNext();
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}
class Node{
    private int no;//编号
    private Node next;

    public Node(int no, Node next) {
        this.no = no;
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}
