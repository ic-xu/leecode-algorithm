package com.xu.algorithm;

import java.util.*;

public class L1531StringCompressionII {

    public int getLengthOfOptimalCompression(String s, int k) {
        List<Integer> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int j = i + 1;
            while (j < chars.length && (chars[i] == chars[j])) {
                j++;
            }
            int length = j - i;
            if (k > 0 && length == 1) {
                k--;
            } else result.add(length);
            i = j-1;
        }
        Collections.sort(result);
        while (k>0){
            Integer tmp = result.get(0)-1;
            if(tmp==0){
                result.remove(0);
            }else {
                result.set(0,tmp);
            }
            k--;
        }
        System.out.println(result);
        System.out.println(k);
        return result.size()*2;
    }

    public static void main(String[] args) {
        new L1531StringCompressionII().getLengthOfOptimalCompression("aabbaa", 2);
    }
}
