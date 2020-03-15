package com.w.cn.二叉树;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-15-13:23
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //初始化节点
        HeroNode node1 = new HeroNode(1,"宋江");
        HeroNode node2 = new HeroNode(2,"吴用");
        HeroNode node3 = new HeroNode(3,"卢俊义");
        HeroNode node4 = new HeroNode(4,"林冲");
        HeroNode node5 = new HeroNode(5,"关胜");
        BinaryTree binaryTree = new BinaryTree();
        node1.left=node2;
        node1.right=node3;
        node3.right=node4;
        node3.left=node5;
        binaryTree.setRoot(node1);
        System.out.println("前序遍历：");
        binaryTree.preOrder();
        System.out.println("中序遍历：");
        binaryTree.infixOrder();
        System.out.println("后序遍历：");
        binaryTree.postOrder();
        System.out.println("前序查找：");
        System.out.println(binaryTree.preOrderSearch(5));
        System.out.println("中序查找：");
        System.out.println(binaryTree.infixOrderSearch(5));
        System.out.println("后序查找：");
        System.out.println(binaryTree.postOrderSearch(5));

        System.out.println("删除节点");
        binaryTree.delNodeByNo(3);
        System.out.println("前序遍历：");
        binaryTree.preOrder();
    }
}

//创建二叉树
class BinaryTree {
    private HeroNode root;//根节点

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //删除节点
    public void delNodeByNo(int no){
        if(root==null){
            System.out.println("二叉树为空");
            return;
        }
        if(root.no==no){
            root=null;
        }else {
            root.delNodeByNo(no);
        }
    }

    //前序遍历
    public void preOrder() {
        if (root==null) {
            System.out.println("二叉树为空");
        }
        root.preOrder();
    }
    //中序遍历
    public void infixOrder() {
        if (root==null) {
            System.out.println("二叉树为空");
        }
        root.infixOrder();
    }
    //后序遍历
    public void postOrder() {
        if (root==null) {
            System.out.println("二叉树为空");
        }
        root.postOrder();
    }
    //前序查询
    public HeroNode preOrderSearch(int no){
        if (root==null) {
            return null;
        }
        return root.preOrderSearch(no);
    }
    //中序查询
    public HeroNode infixOrderSearch(int no){
        if (root==null) {
            return null;
        }
        return root.infixOrderSearch(no);
    }
    //后序查询
    public HeroNode postOrderSearch(int no){
        if (root==null) {
            return null;
        }
        return root.postOrderSearch(no);
    }
}

//创建节点
class HeroNode {
    public int no;//标号
    public String name;//名称
    public HeroNode left;//左子树
    public HeroNode right;//右子树

    //初始化节点
    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //创建前序遍历
    public void preOrder() {
        //根节点
        System.out.println(this);
        //如果左节点不为空，向左子树递归
        if (this.left != null) {
            this.left.preOrder();
        }
        //如果右子树不为空，向右子树递归
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //创建中序遍历
    public void infixOrder() {
        //如果左节点不为空，向左子树递归
        if (this.left != null) {
            this.left.infixOrder();
        }
        //根节点
        System.out.println(this);
        //如果右子树不为空，向右递归中序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //创建后序遍历
    public void postOrder() {
        //左子树不为空，向左子树递归后续
        if (this.left != null) {
            this.left.postOrder();
        }
        //右子树不为空，向有百年递归后续遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        //根节点
        System.out.println(this);
    }

    //前序查找
    /**
     *
     * @param no 查找no
     * @return
     */
    public HeroNode preOrderSearch(int no){
        //由于是递归  要更具情况放置  放置的这句话  TODO 细品--递归最后末尾 才打印
        System.out.println("进入前续查询");
        //比较当前节点是否符合
        if(this.no == no){
            return this;
        }
        HeroNode resNode = null;
        //判断左子树是否为空，如果不为空继续向左子树前序遍历
        if(this.left!=null){
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        //判断右子树是否为空，如果不为空继续向右子树前序遍历
        if(this.right!=null){
            resNode = this.right.preOrderSearch(no);
        }
        //最后不用再判断 不该最后怎样都要返回结果
        return resNode;
    }
    //中序查找
    /**
     *
     * @param no 查找no
     * @return
     */
    public HeroNode infixOrderSearch(int no){
        HeroNode resNode = null;
        //判断左子树是否为空，如果不为空继续向左子树前序遍历
        if(this.left!=null){
            resNode = this.left.infixOrderSearch(no);
        }
        System.out.println("进入中续查询");
        //比较当前节点是否符合
        if(this.no == no){
            return this;
        }
        if(resNode!=null){
            return resNode;
        }
        //判断右子树是否为空，如果不为空继续向右子树前序遍历
        if(this.right!=null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }
    //前序查找
    /**
     *
     * @param no 查找no
     * @return
     */
    public HeroNode postOrderSearch(int no){
        HeroNode resNode = null;
        //判断左子树是否为空，如果不为空继续向左子树前序遍历
        if(this.left!=null){
            resNode = this.left.postOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        //判断右子树是否为空，如果不为空继续向右子树前序遍历
        if(this.right!=null){
            resNode = this.right.postOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        System.out.println("进入后续查询");
        //比较当前节点是否符合
            if(this.no == no){
            return this;
    }
        return null;
    }

    /**
     * 删除节点  利用前序遍历思想
     * 思路；
     * 1.判断当前节点是否为满足条件
     * 2.由于是单向链表，不能定位到待删除的那个节点。
     * 3.当前节点不为空，判断this.left.no 是否满足
     * 4.当前节点不为空，判断this.right.no 是否满足
     * 5.  3/4/都未满足就以此进行  左边、右边的递归
     * @param no
     */
    public void delNodeByNo(int no){
        if(this.left!=null&&this.left.no==no){
            this.left=null;
            return;
        }
        if(this.right!=null&&this.right.no==no){
            this.right=null;
            return;
        }
        if(this.left!=null){
            this.left.delNodeByNo(no);
        }
        if(this.right!=null){
            this.right.delNodeByNo(no);
        }
    }
}
