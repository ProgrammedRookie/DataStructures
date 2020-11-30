package com.zy.node;

/**
 * 单链表
 * @author 子远
 */
public class SingleLinkedList {

    public static void main(String[] args) {
        LinkedNode ln = new LinkedNode();

        ln.insert(new HeroNode(1,"宋江","及时雨"));
        ln.insert(new HeroNode(3,"李逵","黑旋风"));
        ln.insert(new HeroNode(2,"吴用","智多星"));
        ln.delete(1);


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
            // 向后移动
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    /**
     * 修改
     * @param heroNode
     */
    public void update(HeroNode heroNode){

        HeroNode temp = head;

        if (temp.next == null){
            System.out.println("链表为空");
            return;
        }
        while (true){
            if (temp.next.no == heroNode.no){
                // 要替换的 节点
                HeroNode updateTemp = temp.next;
                updateTemp.name = heroNode.name;
                updateTemp.nickName = heroNode.nickName;
                break;
            }
            // 向后移动
            temp = temp.next;
        }
    }

    /**
     * 删除
     * @param index
     */
    public void delete(int index){
        HeroNode temp = head;

        if (temp.next == null){
            System.out.println("链表为空");
            return;
        }
        while (true){
            if (temp.next.no == index){
                // 要替换的 节点
                HeroNode updateTemp = temp.next;
                temp.next = updateTemp.next;
                break;
            }
            // 向后移动
            temp = temp.next;
        }
    }

    /**
     * 指定位置插入
     * @param heroNode
     */
    public void insert(HeroNode heroNode){

        HeroNode temp =  head;
        // 控制是否能插入的变量
        boolean flag = false;

        while (true){
            // 如果链表为空,不能插入
            if (temp.next == null){
                break;
            }
            // 找到 heroNode 后一个位置
            if (temp.next.no > heroNode.no){
                break;
            }
            // 如果表示相同，代表该位置有数据
            if (temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            // 向后移动
            temp = temp.next;
        }
        if (flag){
            System.out.printf("编号重复，编号为%d",heroNode.no);
        }else {
           heroNode.next = temp.next;
           temp.next = heroNode;
        }
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