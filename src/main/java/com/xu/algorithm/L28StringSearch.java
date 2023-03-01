package com.xu.algorithm;

/**
 * @author chenxu
 * @version 1
 * @date 2022/3/26 9:24 上午
 */
public class L28StringSearch {

    private final String pat;
    private int[][] dp;

    public L28StringSearch(String pat) {
        this.pat = pat;
        //构建netval 数组
        int M = pat.length();
        // dp[状态][字符] = 下个状态
        dp = new int[M][256];
        // base case
        dp[0][pat.charAt(0)] = 1;
        // 影子状态 X 初始为 0
        int X = 0;
        // 当前状态 j 从 1 开始
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++) {
                if (pat.charAt(j) == c) {
                    dp[j][c] = j + 1;
                } else {
                    dp[j][c] = dp[X][c];
                }
            }
            // 更新影子状态
            X = dp[X][pat.charAt(j)];
        }
    }

}