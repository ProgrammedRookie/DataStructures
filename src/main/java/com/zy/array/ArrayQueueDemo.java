package com.zy.array;

/**
 * 数组方式实现队列
 * @author 子远
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(3);

        aq.addQueue(2);

        aq.addQueue(4);

        aq.addQueue(6);

        System.out.println(aq.getQueue());

        aq.addQueue(8);

        aq.showQueue();

        aq.headQueue();
    }
}

class ArrayQueue{

    /**
     *  数组最大容量
     */
    private static int maxSize;

    private static int front;

    private static int rear;

    private static int[] arr;


    public ArrayQueue(int arraySize) {
        maxSize = arraySize;
        arr = new int[maxSize];
        // 用于获取元素 初始位置是数据头部元素的前一个位置
        front = -1;
        // 用于添加元素，初始位置是数据的尾部前一个位置
        rear = -1;
    }

    public boolean isFull(){
        return rear == maxSize -1;
    }

    public boolean isEmpty(){
        return  front == rear;
    }

    public void addQueue(int item){
        if (isFull()){
            System.out.println("队列已满~~~~~");
            return;
        }
        arr[++rear] = item;
    }

    public int getQueue(){

        if (isEmpty()){
            throw new RuntimeException("队列为空~~~~");
        }
        return arr[++front];
    }


    public void showQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空~~~~");
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.printf("arr[%d] = %d\t",i,arr[i]);
        }
    }

    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空~~~~");
        }
        return arr[front +1];
    }

}
