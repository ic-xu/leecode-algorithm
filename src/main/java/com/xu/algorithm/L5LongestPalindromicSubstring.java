package com.xu.algorithm;

public class L5LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) return s;
        Boolean[][] tmp = new Boolean[length][length];
        int begin = 0;
        int end = 0;
        char[] chars = s.toCharArray();

        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (chars[i] != chars[j]) {
                    tmp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        tmp[i][j] = true;
                    }else {
                        tmp[i][j] = tmp[i+1][j-1];
                    }
                }
                if(tmp[i][j] && end-begin<=j-i){
                    begin=i;
                    end=j;
                }
            }
        }


        return s.substring(begin,end+1);
    }


    public static void main(String[] args) {
        String s = new L5LongestPalindromicSubstring().longestPalindrome("ac");
        System.out.println(s);
    }
}
