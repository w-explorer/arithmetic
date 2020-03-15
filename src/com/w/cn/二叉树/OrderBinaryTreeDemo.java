package com.w.cn.二叉树;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-15-15:31
 *
 * 顺序存储二叉树的概念
 *
 * 基本说明：
 *
 * > 数组存储方式和树的村粗方式可以互相转换，即数组可以转换成树，树也可以转换为数组。
 *
 * 顺序存储二叉树的特点;
 *
 * > 1.顺序二叉树通常只考虑完全二叉树
 * >
 * > 2.第n个元素的左子节点为2*n+1
 * >
 * > 3.第n个元素的右子节点为2*n+2
 * >
 * > 4.第n个元素的父节点为(n-1)/2
 * >
 * > 5.n：表示二叉树中的第几个元素（按照0开始标号，即数组的下脚表）
 */
public class OrderBinaryTreeDemo {
    public static void main(String[] args) {
        int []arr ={1,2,3,4,5,6};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        System.out.println("前序遍历：");
        arrayBinaryTree.preOrder();
        System.out.println("中序遍历：");
        arrayBinaryTree.infixOrder();
        System.out.println("后序遍历：");
        arrayBinaryTree.postOrder();
    }
}
class ArrayBinaryTree{
    private int [] arr;
    public ArrayBinaryTree(int [] arr){
        this.arr=arr;
    }

    /**
     * 重载函数让函数调用代码更加的干净
     */
    public void preOrder(){
        preOrder(0);
    }
    public void infixOrder(){
        infixOrder(0);
    }
    public void postOrder(){
        postOrder(0);
    }

    /**
     * 前序遍历
     * @param index
     */
    public void preOrder(int index){
        int length = arr.length;
        if(arr==null||length==0){
            System.out.println("数组为空，不能前序遍历");
        }
        //打印当前节点 根节点
        System.out.println(arr[index]);
        //递归左子树
        if(2*index+1<length){//避免脚标越界
            preOrder(2*index+1);
        }
        //递归右子树
        if(2*index+2<length){//避免脚标越界
            preOrder(2*index+2);
        }
    }
    /**
     * 中序遍历
     * @param index
     */
    public void infixOrder(int index){
        int length = arr.length;
        if(arr==null||length==0){
            System.out.println("数组为空，不能前序遍历");
        }
        //递归左子树
        if(2*index+1<length){//避免脚标越界
            infixOrder(2*index+1);
        }

        //打印当前节点 根节点
        System.out.println(arr[index]);

        //递归右子树
        if(2*index+2<length){//避免脚标越界
            infixOrder(2*index+2);
        }

    }
    /**
     * 后序遍历
     * @param index
     */
    public void postOrder(int index){
        int length = arr.length;
        if(arr==null||length==0){
            System.out.println("数组为空，不能前序遍历");
        }
        //递归左子树
        if(2*index+1<length){//避免脚标越界
            postOrder(2*index+1);
        }
        //递归右子树
        if(2*index+2<length){//避免脚标越界
            postOrder(2*index+2);
        }
        //打印当前节点 根节点
        System.out.println(arr[index]);
    }
}
