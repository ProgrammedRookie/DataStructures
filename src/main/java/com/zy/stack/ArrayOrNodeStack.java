package com.zy.stack;

import javax.management.relation.RoleUnresolved;

/**
 * @author 子远
 */
public class ArrayOrNodeStack {

    public static void main(String[] args) {

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        int ch = ' ';
        int oper = 0;

        String es = "30+9*2-2";

        ArrayStack numsStack = new ArrayStack(10);

        ArrayStack operStack = new ArrayStack(10);

        while (true){

            ch = es.substring(index,index+1).charAt(0);

            if (operStack.isOper(ch)){
                if (operStack.isEmpty()){
                    operStack.push(ch);
                }else {
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numsStack.pop();
                        num2 = numsStack.pop();
                        oper = operStack.pop();
                        res = numsStack.cal(num1,num2,oper);
                        numsStack.push(res);
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);
                    }
                }
            }else {
                // todo 将数放入数字栈
                numsStack.push(ch -48);
            }
            index++;
            if (index == es.length()){
                break;
            }
        }

        while (true){
            if (operStack.isEmpty()){
                break;
            }
            num1 = numsStack.pop();
            num2 = numsStack.pop();
            res = numsStack.cal(num1,num2,operStack.pop());
            numsStack.push(res);
        }
        System.out.println(numsStack.pop());
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

    /**
     * 判断符号优先级
     * @param oper
     * @return
     */
    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    /**
     * 计算
     * @param num1
     * @param num2
     * @param oper
     * @return
     */
    public int cal(int num1,int num2,int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
                default:break;
        }
        return res;
    }

    public int peek(){
        return stack[top];
    }

    public boolean isOper(int oper){
        return oper == '*' || oper == '+' || oper == '-' || oper == '/';
    }


}