package com.zy.node;

/**
 * 单链表
 * @author 子远
 */
public class SingleLinkedList {

    public static void main(String[] args) {
        LinkedNode ln = new LinkedNode();

        ln.add(new HeroNode(1,"宋江","及时雨"));
        ln.add(new HeroNode(2,"吴用","智多星"));
        ln.add(new HeroNode(3,"李逵","黑旋风"));

        ln.list();
    }
}

class LinkedNode{

    /**
     *  链表头节点
     */
    HeroNode head = new HeroNode(0,"","");

    /**
     * 添加
     * @param heroNode
     */
    public void add(HeroNode heroNode){
        // 临时遍历指向头节点
        HeroNode  temp = head;
        // 找到尾节点
        while (true){
            // 如果链表中的节点 next 为 null 即最后一个节点 跳出循环
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    /**
     * 查看链表中的节点
     */
    public void list(){
        // 当 temp 等于null 链表中没有数据
        if ( head.next == null){
            System.out.println("空链表~~~~~~");
            return;
        }
        HeroNode temp  = head.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.print(temp);
            temp = temp.next;
        }
    }


}



class HeroNode{

    public int no;
    public String name;
    public String nickName;
    public HeroNode next;


    public HeroNode(int no,String name,String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
        this.next = null;
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