package com.zy.recursion;

/**
 * @author zy
 */
public class Queue8 {

    int max = 8;
    int[] array = new int[max];
    int count = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("共有%d种解法",queue8.count);
    }


    private void check(int n){
        if (n == max){
            print();
            return;
        }
        for (int i = 0; i < max ; i++) {
            array[n] = i;
            if (judge(n)){
                check(n+1);
            }
        }
    }

    /**
     * 检查 第 n 个皇后 与前面已经放好的皇后是否存在冲突
     * @param n = 第几个皇后
     * @return
     */
    private boolean judge(int n){
        for (int i = 0; i < n ; i++) {
            // array[n] == array[i] 检查是否在同一列上
            // Math.abs(n-i) ==  Math.abs(array[n] - array[i]) 检查是否在同一斜线上
            if (array[n] == array[i] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }


    private void print(){
        count++;
        for (int i = 0; i < array.length ; i++) {
            System.out.printf(array[i] +" ");
        }
        System.out.println();
    }





}
