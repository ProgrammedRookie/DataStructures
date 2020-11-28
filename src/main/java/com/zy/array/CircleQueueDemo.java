package com.zy.array;

/**
 * 数组方式实现环形队列
 * @author 子远
 */
public class CircleQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue ca = new CircleArrayQueue(3);

        ca.addQueue(3);

        ca.addQueue(4);

        System.out.println("-----"+ ca.getQueue());
        ca.showQueue();


    }
}

class CircleArrayQueue{

    /**
     *  数组最大容量
     */
    private static int maxSize;

    private static int front;

    private static int rear;

    private static int[] arr;


    public CircleArrayQueue(int arraySize) {
        maxSize = arraySize;
        arr = new int[maxSize];
    }

    /**
     * 队列是否满
     * @return
     */
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    /**
     * 队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return  front == rear;
    }

    public void addQueue(int item){
        if (isFull()){
            System.out.println("队列已满~~~~~");
            return;
        }
        arr[rear] = item;
        // 每添加一次元素后，rear 向后移动一位，如果 % maxSize == 0 时，说明又回到队列的头位置，（索引为 0）,添加时形成一个环装
        rear = (rear + 1) % maxSize;
    }

    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空~~~~");
        }
        int value = arr[front];
        // 每取出一个元素时，front 从头位置向后移动 如果 % maxSize == 0 时，又回到队列的头部 即 front 又 == 0
        front = (front +1) % maxSize;
        return value;
    }


    public void showQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空~~~~");
        }
        for (int i = front; i < front + size() ; i++) {
            System.out.printf("arr[%d] = %d\t",i % maxSize,arr[i % maxSize]);
            System.out.println();
        }

    }

    /**
     * 获取数组中有效的元素，rear是 队列中最后一个元素的后一个位置，说明数组中多存放了一个无用的数据
     * @return
     */
    public int size(){
        // % maxSize 有可能 rear 又回到队列头部
        return (rear + maxSize - front) % maxSize;
    }

    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空~~~~");
        }
        return arr[front];
    }

}
