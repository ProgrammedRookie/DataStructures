package com.zy.stack;

/**
 * @author 子远
 */
public class ArrayOrNodeStack {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("弹出"+ stack.pop());
        stack.list();
    }
}

/**
 * 单链表方式
 */
class NodeStack{
    // todo
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