package com.w.cn.链表;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-12-17:43
 */
public class CycleSingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode3 hero1 = new HeroNode3(1, "宋江", "及时雨");
        HeroNode3 hero2 = new HeroNode3(2, "卢俊义", "玉麒麟");
        HeroNode3 hero3 = new HeroNode3(3, "吴用", "智多星");
        HeroNode3 hero4 = new HeroNode3(4, "林冲", "豹子头");
        CycleSingleLinkedList cSLinkedList = new CycleSingleLinkedList();
        cSLinkedList.add(hero1);
        cSLinkedList.add(hero2);
        cSLinkedList.add(hero3);
        cSLinkedList.add(hero4);
        cSLinkedList.list();
        cSLinkedList.Joseph(1,2);
    }

}

class CycleSingleLinkedList{
    private HeroNode3 first = new HeroNode3(-1,null,null);
    //需要 first 指向 第一个节点 做标记

    public HeroNode3 getFirst(){
        return first;
    }
    /**
     * 约瑟夫出圈
     *
     * helper 为  first.prve
     * @param k 从第几个小号数
     * @param feet 报数阶级数
     */
    public  void Joseph(int k,int feet){
        HeroNode3 first = getFirst();
        HeroNode3 cur = first.next;
        HeroNode3 temp = first.next;
        HeroNode3 helper = null;
        while (true){
            if(temp.next==cur){
                break;
            }
            temp=temp.next;
        }
        for (int i = 0; i < k; i++) {
            cur = first.next;
        }

        helper=temp;
        for (int i = 0; i < k-1; i++) {
            helper =helper.next;
        }
        while (true){
            if(helper==cur){
                System.out.println("最后一个小孩是："+cur.no);
                break;
            }
            for (int i = 0; i < feet-1; i++) {
                cur=cur.next;
            }
            for (int i = 0; i < feet-1; i++) {
                helper=helper.next;
            }
            System.out.println(cur.no+"号小孩出圈");
            cur = cur.next;
            helper.next = cur;
        }
    }
    public boolean list(){
        HeroNode3 first = getFirst();
        if (this.first.next==null){
            System.out.println("链表为空");
            return false;
        }
        HeroNode3 cur = this.first.next;
        while (true){
            System.out.println(cur);
            if(cur.next.no== this.first.next.no){
                break;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 添加node
     * @param heroNode
     */
    public  void add(HeroNode3 heroNode){
        if(first.next==null){
            first.next = heroNode;
            heroNode.next = heroNode;
            return;
        }
        HeroNode3 cur = first.next;
        while (true){
            if (cur.no==heroNode.no){
                System.out.println("添加失败，节点编号重复");
            }
            if(cur.next.no==first.next.no){
                break;
            }
            cur = cur.next;
        }
        cur.next = heroNode;
        heroNode.next = first.next;

    }
}

class HeroNode3{
    public int no;   //排名编号
    public String name; //名称
    public String nickName; //昵称
    public HeroNode3 next; //指向下一个节点

    public HeroNode3(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
