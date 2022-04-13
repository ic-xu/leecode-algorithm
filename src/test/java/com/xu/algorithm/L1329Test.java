package com.xu.algorithm;

import static org.junit.jupiter.api.Assertions.*;

class L1329Test {

    @org.junit.jupiter.api.Test
    void diagonalSort() {
        int[][] testMat = new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
        int[][] ints = new L1329().diagonalSort(testMat);
    }
}