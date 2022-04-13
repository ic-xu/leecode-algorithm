package com.xu.algorithm;

import com.xu.utils.ArraysPrint;

/**
 * @author chenxu
 * @version 1
 * @date 2022/4/12 8:32 上午
 */
public class L1329 {

    public int[][] diagonalSort(int[][] mat) {
        ArraysPrint.printlnArr(mat);
        System.out.println();


        int[][] result = new int[mat.length][];
        for (int j = mat[0].length - 2; j >= 0; j--) {
            int tmpa = mat[0][j];
            System.out.println(mat[0][j]);
        }


        System.out.println();
        for (int i = 1; i < mat.length; i++) {
            System.out.println(mat[i][0]);
        }
        return result;
    }
}
