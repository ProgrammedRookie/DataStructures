package com.zy.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度 O(n^2)
 * @author zy
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] array = {3,9,-1,10,-2};

        int temp;

        for (int i = 0; i < array.length -1 ; i++) {
            for (int j = 0; j < array.length -1 -i ; j++) {
                if (array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

}
