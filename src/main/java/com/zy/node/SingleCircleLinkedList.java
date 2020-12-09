package com.zy.node;

/**
 * @author 子远
 */
public class SingleCircleLinkedList {

    public static void main(String[] args) {
        SingleCircleLinked sc = new SingleCircleLinked();

        sc.add(5);
        sc.list();

    }
}


class SingleCircleLinked {

    private Node first = null;

    /**
     * 单向环形链表添加
     *
     * @param nums
     */
    public void add(int nums) {

        if (nums < 1) {
            System.out.println("值非法~~~~");
            return;
        }

        Node cur = null;
        for (int i = 1; i <= nums; i++) {
            Node node = new Node(i);
            // 如果是头节点
            if (i == 1) {
               first = node;
               // 头节点自己形成闭环
               first.setNext(first);
               // 向后移动
               cur = first;
            }else {
                //
                cur.setNext(node);
                node.setNext(first);
                cur = node;
            }
        }
    }

    public void list() {
        if (first == null) {
            System.out.println("链表为空~~~");
            return;
        }
        Node cur = first;
        while (true) {
            System.out.printf("node 节点编号 %d \n", cur.getNo());
            if (cur.getNext() == first) {
                break;
            }
            cur = cur.getNext();
        }
    }


}


class Node {

    private Integer no;
    private Node next;

    public Node(Integer no) {
        this.no = no;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
