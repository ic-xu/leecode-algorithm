package com.xu.algorithm;

public class CVTE校招7 {


    public static void main(String[] args) {

        int[] a = {10, 20, 30, 40, 50};
//        int diff = getDiff(a);
        int   diff = min(a);
        System.out.println(diff);
    }


    public static int getDiff(int[] orderNumArr) {
        int sum = 0, max = 0;
        for (int i = 0; i < orderNumArr.length; i++) {
            sum += orderNumArr[i];
        }
        int[] dp = new int[(int) (sum / 2 + 1)];
        for (int i = 0; i < orderNumArr.length; i++) {
            for (int j = (int) (sum / 2); j > 0; j--) {
                if (j >= orderNumArr[i]) {
                    dp[j] = Math.max(dp[j], dp[j - orderNumArr[i]] + orderNumArr[i]);
                    //                    System.out.println("dp["+j+"] 的值是 "+ dp[j]);
                    System.out.print(dp[j]);
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        for (int i = 1; i < sum / 2 + 1; i++) {
            max = Math.max(max, dp[i]);
        }
        return Math.abs((sum - max) - max);
    }


    public static int min(int orders[]) {
        if (orders == null || orders.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i : orders) {
            sum += i;
        }
        int[][] dp = new int[orders.length + 1][sum / 2 + 1];
        for (int i = 0; i < sum / 2; i++) {
            dp[0][i] = (i >= orders[0] ? orders[0] : 0);
        }
        for (int i = 1; i < orders.length; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= orders[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - orders[i]] + orders[i]);
                }
            }
        }
        return sum - 2 * dp[orders.length - 1][sum / 2];
    }



    public int minDis(int[] orders){
        //求离sum/2最近的数
        //背包问题，先求sum/2最大容量 x
        //另一个包能装y-sum-x
        //|y-x|=|sum-2x|
        int sum = 0,len = orders.length;
        for(int i = 0;i<len;i++){
            sum += orders[i];
        }
        int halfSum =sum/2;
        int[] dp = new int[halfSum+1];
        for(int i = 0;i<len;i++){
            for(int j = halfSum;j>=orders[i];j--){
                dp[i] = Math.max(dp[i],dp[j-orders[i]]+orders[i]);
            }
        }
        return Math.abs(sum-2*dp[halfSum]);
    }

}
