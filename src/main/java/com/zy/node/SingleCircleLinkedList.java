package com.zy.node;

/**
 * @author 子远
 */
public class SingleCircleLinkedList {

    public static void main(String[] args) {
        SingleCircleLinked sc = new SingleCircleLinked();

        sc.add(15);
        // sc.list();
        sc.countNode(1,4,15);

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

    /**
     * 约瑟夫循环出圈问题
     * @param startNo 开始出圈的节点
     * @param countNumber 循环次数
     * @param nums  环形队列的总长度
     */
    public void countNode(int startNo,int countNumber,int nums){

        // 校验参数
        if (first == null || startNo < 1 || startNo > nums){
            return;
        }
        Node cur = first;
        // 将cur 指向 环形队列的最后一个节点
        while (true){
            if (cur.getNext() == first){
                break;
            }
            cur =  cur.getNext();
        }
        // 将 first 和 cur 都移动 startNo - 1 次
        for (int i = 0; i < startNo -1 ; i++) {
            first = first.getNext();
            cur = cur.getNext();
        }
        while (true){
            // cur 和first  相等 说明圈子中只剩下一个节点
            if (cur == first){
                break;
            }
            for (int i = 0; i < countNumber -1 ; i++) {
                first = first.getNext();
                cur = cur.getNext();
            }
            System.out.printf(" node 节点 编号 %d \n",first.getNo());
            // 重新组织环形队列
            first = first.getNext();
            cur.setNext(first);
        }

        System.out.printf("剩下的节点 %d \n",cur.getNo());
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
