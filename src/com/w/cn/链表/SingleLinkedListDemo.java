package com.w.cn.链表;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-11-13:55
 *
 *
 *
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //直接添加到队列尾部
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        //根据编号添加到队列指定位置
//        singleLinkedList.addByNo(hero1);
//        singleLinkedList.addByNo(hero3);
//        singleLinkedList.addByNo(hero3);
//        singleLinkedList.addByNo(hero2);
//        singleLinkedList.addByNo(hero4);

        //测试updata

//        singleLinkedList.addByNo(hero1);
//        singleLinkedList.addByNo(hero3);
//        singleLinkedList.addByNo(hero2);
//        singleLinkedList.addByNo(hero4);
//        singleLinkedList.showList();
//
//        HeroNode heroNode = new HeroNode(5, "卢俊义1", "玉麒麟1");
//        singleLinkedList.updataByNo(heroNode);
//        System.out.println("修改后");
//        singleLinkedList.showList();

        //测试删除

//        singleLinkedList.addByNo(hero1);
//        singleLinkedList.addByNo(hero3);
//        singleLinkedList.addByNo(hero2);
//        singleLinkedList.addByNo(hero4);
//        singleLinkedList.showList();
//        singleLinkedList.delByNo(5);
//        System.out.println("删除之后");
//        singleLinkedList.showList();


        //测试getLength
//        singleLinkedList.addByNo(hero1);
//        singleLinkedList.addByNo(hero3);
//        singleLinkedList.addByNo(hero2);
//        singleLinkedList.addByNo(hero4);
//        int length = getLength(singleLinkedList.getHead());
//        System.out.printf("英雄单链表有效个数为%d\n",length);
//        singleLinkedList.showList();
//        int res = 2;
//        HeroNode heroNodeByIndex = getHeroNodeByIndex(singleLinkedList.getHead(), res);
//        System.out.printf("倒数第%d个节点为:",res);
//        System.out.println(heroNodeByIndex);


        //测试带头节点的反转单链表
        singleLinkedList.addByNo(hero1);
        singleLinkedList.addByNo(hero3);
        singleLinkedList.addByNo(hero2);
        singleLinkedList.addByNo(hero4);
        System.out.println("原始链表");
        singleLinkedList.showList();
        reverse(singleLinkedList.getHead());
        System.out.println("反转后链表");
        singleLinkedList.showList();

    }

    /**
     * 通过头节点反转单链表  腾讯面试题
     * @param heroNode
     */
    public static void reverse(HeroNode heroNode){
        if(heroNode.next==null || heroNode.next.next==null){
            return;
        }
        HeroNode reverseHead = new HeroNode(0,"","");
        HeroNode cur = heroNode.next;
        HeroNode next = null;
        while (cur!=null){ //相当于插入
            next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur; //将cur 连接到新的链表上
            cur = next;//让cur后移
        }
        heroNode.next = reverseHead.next;
    }

    /**
     * 获取到单链表的节点的有效个数(如果是带头结点的链表，需求不统计头节点)
     * @param heroNode 链表的头节点
     * @return 返回单链表的有效节点个数
     */
    public static int getLength(HeroNode heroNode){
        HeroNode temp = heroNode.next;
        int length = 0;
        if(temp==null){
            return  length;
        }

        while (temp!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }

    //查找单链表中的倒数第K个节点【新浪面试题】
    //思路：
    //1.参数   头节点   index k 是倒数第几个节点
    //2.拿到链表的长度  从头到尾遍历
    //3.从头到尾遍历 (size - k)就可以得到
    //4.找到就返回，否则null
    public static HeroNode getHeroNodeByIndex(HeroNode heroNode,int k){
        //如果链表为空返回
        if(heroNode.next==null){
            return null;
        }
        //节点有效个数
        int size = getLength(heroNode);
        //第二次遍历 size - k 位置就是 到处低K个节点
        if(size<k||k<=0){
            return null;
        }
        HeroNode temp = heroNode.next;
        for (int i = 0; i < size-k; i++) {
            temp=temp.next;
        }
        return temp;
    }
}
//定义SingleLinkedList管理hero节点

class SingleLinkedList{
    //创建头节点  头节点不能动  不存放 任何具体数据
   private HeroNode head =  new HeroNode(0,"","");

    public HeroNode getHead() {
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
       HeroNode temp = head.next;
       boolean flag = false;//是否找到该节点
       while (true){
           //到链表尾部 未找到
           if(temp.next==null){
               break;
           }
           if(temp.next.no==no){
               //找到
               flag = true;
               break;
           }
           temp= temp.next;
       }

       if(flag){
          temp.next = temp.next.next;
       }
       else {
           System.out.println("未找到指定的节点");
       }
   }
    /**
     * 根据英雄标号修改
     * @param heroNode
     */
   public void updataByNo(HeroNode heroNode){
       //判断是否为空
       if(head.next==null){
           System.out.println("链表为空");
           return;
       }
       HeroNode temp = head.next;
       boolean flag = false;//是否找到该节点
       while (true){
           //到链表尾部 未找到
           if(temp.next==null){
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

    /**
     * 不考虑标号顺序时
     * 1.找到当前链表的最后节点   遍历链表  next==null;即为尾部节点
     * 在最后节点的next  指向新节点
     * @param heroNode
     */
   public void add(HeroNode heroNode){
       HeroNode temp = head;
       while (true){
           if (temp.next==null){
               break;
           }
           temp=temp.next;
       }
       temp.next = heroNode;
   }

    /**
     * 更具英雄排名插入指定位置
     * （如果有这个排名则添加失败，给出提示）
     * @param heroNode
     */
   public void addByNo(HeroNode heroNode){
       //需要辅助tem变量来找到指定的位置
       HeroNode temp = head;
       boolean flag = false;//编号是否存在
       while (true){
           //到了链表尾部
           if(temp.next==null){
               break;
           }
           if(temp.next.no>heroNode.no){
               break;
           }else if(temp.next.no==heroNode.no){
                flag = true;
                break;
           }
           temp=temp.next;
       }
       if(flag){//不能添加   排名存在
           System.out.printf("准备插入的英雄编号%d 已经存在了，不能添加\n",temp.no);
           return;
       }
       heroNode.next = temp.next;
       temp.next = heroNode;

   }
   public void showList(){
       //判断链表是否为空
       if(head.next==null){
           System.out.println("链表为空");
           return;
       }
       HeroNode temp = head.next;
       while (true){
           if (temp==null){
               break;
           }
           System.out.println(temp);
           temp=temp.next;
       }
   }

}

//定义HeroNode,每个HeroNode 对象就是一个节点
class HeroNode{

    public int no;   //排名编号
    public String name; //名称
    public String nickName; //昵称
    public HeroNode next; //指向下一个节点

    public HeroNode(int no, String name, String nickName) {
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
