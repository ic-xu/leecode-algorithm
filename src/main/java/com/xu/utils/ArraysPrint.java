package com.xu.utils;

/**
 * @author chenxu
 * @version 1
 * @date 2022/4/12 8:39 上午
 */
public class ArraysPrint {

    public static void printlnArr(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
}
