package com.xu.algorithm;

public class L892surfaceArea {

    public static int surfaceArea(int[][] grid) {

        int n = grid.length;
        int area = 0;
        int lever;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                lever = grid[i][j];
                if (lever > 0) {
                    area += (lever << 2) + 2;
                    area -= i > 0 ? Math.min(grid[i - 1][j], lever) << 1 : 0;
                    area -= j > 0 ? Math.min(grid[i][j - 1], lever) << 1 : 0;
                }

            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        System.out.println(surfaceArea(a));
    }

}
