package com.zy.stack;

import javax.management.relation.RoleUnresolved;

/**
 * @author 子远
 */
public class ArrayOrNodeStack {

    public static void main(String[] args) {
        NodeStack ns = new NodeStack();
        ns.push( 1);
        ns.push( 2);
        ns.push(3);
        ns.push( 4);

        ns.list();

        System.out.println(ns.pop());
    }
}

/**
 * 单链表方式
 */
class NodeStack{
    // todo


    Node head;


    public boolean isEmpty(){
        return head.next == null;
    }

    public void  push(int value){
        Node node = new Node(value);
        if(head == null) {
            head = node;
        }else {
            // 直接将新节点作为栈顶元素
            node.next = head;
            head = node;
        }

    }

    public void list(){

        if (isEmpty()){
            throw  new RuntimeException("栈空");
        }

        Node cur = head;
        while (true){
            if (cur == null){
                break;
            }
            System.out.printf("编号 %d \n",cur.no);
            cur = cur.next;
        }

    }

    public int pop(){

        if (isEmpty()){
           throw new RuntimeException("栈空");
        }

        int value = head.no;
        head = head.next;
        return value;
    }

}


class Node {

    public int no;
    public Node next;

    public Node(int no) {
        this.no = no;
    }
}

/**
 * 数组方式
 */
class ArrayStack {
    private int maxSize;
    private int[] stack;
    private  int top =-1 ;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    // 是否满
    public boolean isFull(){
        return  top == maxSize -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] =value;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }

        for (int i = top; i >= 0 ; i--) {
            System.out.printf("栈内index[%d]====  栈内元素%d \n",i,stack[i]);
        }
    }
}