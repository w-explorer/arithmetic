package com.w.cn.链表;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-12-16:48
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.showList();
        HeroNode2 hero5 = new HeroNode2(4, "林冲1", "豹子头");
        doubleLinkedList.updataByNo(hero5);

//        doubleLinkedList.delByNo(4);

        doubleLinkedList.showList();
    }

}

class DoubleLinkedList{

    private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHead() {
        return head;
    }
    /**
     * temp.next = temp.next.next
     * 删除节点 没有引用 会被jvm  回收
     * @param no
     */
    public void delByNo(int no){
        //判断是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;//是否找到该节点
        while (true){
            //到链表尾部 未找到
            if(temp==null){
                break;
            }
            if(temp.no==no){
                //找到
                flag = true;
                break;
            }
            temp= temp.next;
        }

        if(flag){
            temp.pre.next =  temp.next;
            if(temp.next!=null){
                temp.next.pre = temp.pre;
            }
        }
        else {
            System.out.println("未找到指定的节点");
        }
    }

    /**
     * 根据英雄标号修改
     * @param heroNode
     */
    public void updataByNo(HeroNode2 heroNode){
        //判断是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;//是否找到该节点
        while (true){
            //到链表尾部 未找到
            if(temp==null){
                break;
            }
            if(temp.no==heroNode.no){
                //找到
                flag = true;
                break;
            }
            temp= temp.next;
        }

        if(flag){
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        }
        else {
            System.out.println("未找到指定的节点");
        }

    }

    public void showList(){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true){
            if (temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }

    /**
     * 不考虑标号顺序时
     * 1.找到当前链表的最后节点   遍历链表  next==null;即为尾部节点
     * 在最后节点的next  指向新节点
     * @param heroNode
     */
    public void add(HeroNode2 heroNode){
        HeroNode2 temp = head;
        while (true){
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }
}

class HeroNode2{

    public int no;   //排名编号
    public String name; //名称
    public String nickName; //昵称
    public HeroNode2 next; //指向下一个节点
    public HeroNode2 pre; //指向下一个节点

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
