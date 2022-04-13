package com.xu.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxu
 * @version 1
 * @date 2021/12/22 5:48 下午
 */
public class CVTE校招4 {

    public static void main(String[] args) {
        String ff = "ABCBABEFAFEBA";
        System.out.println(getMirrorString(ff));

        System.out.println(search("hello,worls", "world"));

    }


    public static String getMirrorString(String s) {
        int maxLen = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (isMirror(s, i, j)) {
                    if (j - i + 1 > maxLen) {
                        left = i;
                        right = j;
                        maxLen = j - i + 1;
                    }

                }
            }
        }
        return s.substring(left, right + 1);
    }

    public static boolean isMirror(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }



    public static List<String> search(String text, String keyboard){
        List<String> res = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        int start = 0;
        for(int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            if(c == '.' || c == ',' || c == ' '){
                tmp.add(text.substring(start,i));
                start = i + 1;
            }
        }
        for(String str : tmp){
            if(minDistance(str,keyboard) < 3){
                res.add(str);
            }
        }
        return res;
    }
    public static int minDistance(String text, String keyboard){
        int n1 = text.length();
        int n2 = keyboard.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int i = 1; i <= n1; i++){
            dp[i][0] = i;
        }
        for(int i = 1; i <= n2; i++){
            dp[0][i] = i;
        }
        text = text.toLowerCase();
        for(int i = 1; i <= n1; i++){
            for(int j = 1; j <= n2; j++){
                if(text.charAt(i-1) == keyboard.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else{
                    dp[i][j] = Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j]))+1;
                }
            }
        }
        return dp[n1][n2];

    }


}
