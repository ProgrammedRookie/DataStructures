package com.zy.node;

/**
 * @author 子远
 */
public class DoubleLinkedList {

    public static void main(String[] args) {
        DoubleLinked dn = new DoubleLinked();
        dn.add(new DoubleNode(1, "宋江", "及时雨"));
        dn.add(new DoubleNode(3, "李逵", "黑旋风"));
        dn.add(new DoubleNode(2, "吴用", "智多星"));


        dn.delete(2);

        dn.list();
    }
}

class DoubleLinked {

    private DoubleNode head = new DoubleNode(0, "", "");


    /**
     * 修改
     *
     * @param doubleNode
     */
    public void update(DoubleNode doubleNode) {

        DoubleNode temp = head;

        if (temp.next == null) {
            System.out.println("链表为空");
            return;
        }
        while (true) {
            if (temp.next.no == doubleNode.no) {
                // 要替换的 节点
                DoubleNode updateTemp = temp.next;
                updateTemp.name = doubleNode.name;
                updateTemp.nickName = doubleNode.nickName;
                break;
            }
            // 向后移动
            temp = temp.next;
        }
    }


    /**
     * 删除
     *
     * @param index
     */
    public void delete(int index) {
        DoubleNode temp = head;

        if (temp.next == null) {
            System.out.println("链表为空");
            return;
        }
        while (true) {
            if (temp.no == index) {
                // temp 前一个节点的后一个节点
                temp.pre.next = temp.next;
                if (temp.next == null) {
                    break;
                }
                // temp 后一个节点的前一个节点
                temp.next.pre = temp.pre;
                break;
            }
            // 向后移动
            temp = temp.next;
        }
    }


    /**
     * 添加
     *
     * @param
     */
    public void add(DoubleNode doubleNode) {
        // 临时遍历指向头节点
        DoubleNode temp = head;
        // 找到尾节点
        while (true) {
            // 如果链表中的节点 next 为 null 即最后一个节点 跳出循环
            if (temp.next == null) {
                break;
            }
            // 向后移动
            temp = temp.next;
        }

        temp.next = doubleNode;
        doubleNode.pre = temp;
    }


    /**
     * 查看链表中的节点
     */
    public void list() {
        // 当 temp 等于null 链表中没有数据
        if (head.next == null) {
            System.out.println("空链表~~~~~~");
            return;
        }
        DoubleNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }


}

class DoubleNode {

    public int no;
    public String name;
    public String nickName;
    public DoubleNode next;
    public DoubleNode pre;


    public DoubleNode(int no, String name, String nickName) {
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
