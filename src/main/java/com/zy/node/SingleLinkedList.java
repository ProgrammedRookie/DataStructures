package com.zy.node;


import java.util.Stack;

/**
 * 单链表
 * @author 子远
 */
public class SingleLinkedList {

    public static void main(String[] args) {
        LinkedNode ln = new LinkedNode();

        ln.add(new HeroNode(1,"宋江","及时雨"));
        ln.add(new HeroNode(3,"李逵","黑旋风"));
        ln.add(new HeroNode(2,"吴用","智多星"));

        LinkedNode ln2 = new LinkedNode();
        ln2.add(new HeroNode(5,"宋江","及时雨"));
        ln2.add(new HeroNode(4,"李逵","黑旋风"));
        ln2.add(new HeroNode(6,"吴用","智多星"));

        System.out.println("============");
      //  System.out.println( LinkedNode.getNodeLength(ln.getHead()));
        LinkedNode.mergeTwoLists(ln.getHead(),ln2.getHead());

      //  HeroNode lastNode = LinkedNode.getLastNode(ln.getHead(), 2);

       // System.out.println(lastNode);

    }
}

class LinkedNode{


    /**
     *  链表头节点
     */
    HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

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
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 返回 链表中有效节点数
     * @param head
     * @return
     */
    public static int getNodeLength(HeroNode head){
        // 当链表为空时
        if (head.next == null){
            return 0;
        }
        int length = 0;
        // 排除头节点
        HeroNode temp = head.next;
        while (temp != null){
            length++;
            // 向后移动
            temp = temp.next;
        }
        return length;
    }

    /**
     * 返回 倒数第index位置上的节点
     * @param heroNode
     * @param index
     * @return
     */
    public static HeroNode getLastNode(HeroNode heroNode,int index){

        // 链表为空时，返回null
        if (heroNode.next == null){
            return null;
        }
        // 链表总长度
        int size = getNodeLength(heroNode);

        // 校验index
        if (index < 0 || index > size){
            return null;
        }
        // 排除头
        HeroNode temp = heroNode.next;
        // 变量 size -index 次数后，就是倒数index 上的 node
        for (int i = 0; i < size - index ; i++) {
            temp = temp.next;
        }
        return temp;
    }


    /**
     * 链表反转
     * @param head
     */
    public static void  reverseNode(HeroNode head){

        // 校验链表
        if (head.next == null){
            System.out.println("链表空~~~~");
            return;
        }
        // 临时变量
        HeroNode cur  = head.next;
        // 指向 cur 的下一个 next
        HeroNode next = null;
        // 创建一个临时的头
        HeroNode reverseNode = new HeroNode(0,"","");
        // 将每次拿到的节点都放到reverse 的头位置 （反转）
        while (cur != null){
            // 先获取 cur 的下一个 node
            next = cur.next;
            // 将 cur.next 放到临时链表的头位置上
            // reverseNode.next 头节点的下一个位置，相当于 链表的右边和cur.next 相连
            cur.next = reverseNode.next;
            // reverseNode.next 的左边链接 cur 相当于放到头位置的下一个节点的位置上
            reverseNode.next = cur;
            cur = next;
        }
        head.next = reverseNode.next;
    }

    /**
     * 从尾到头打印链表 (栈的方式 特点：先进后出)
     * @param head
     */
    public static void reversePrint(HeroNode head){

        if (head.next == null){
            return;
        }

        HeroNode cur  = head.next;

        Stack<HeroNode> stack = new Stack<HeroNode>();
        // 压栈
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        // 弹出
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    /**
     * 合并链表 还得在想想
     * @param node1
     * @param node2
     * @return
     */
    public static HeroNode mergeTwoLists(HeroNode node1 ,HeroNode node2){


        if (node1 == null){
            return node2;
        }
        if (node2 == null){
            return node1;
        }

        if (node1.no < node2.no){
            node1.next = mergeTwoLists(node1.next,node2);
            return node1;
        }else {
            node2.next = mergeTwoLists(node1,node2.next);
            return node2;
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