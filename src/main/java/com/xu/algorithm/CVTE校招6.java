package com.xu.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 包名：com.xu.algorithm
 * 文件名：CVTE校招5.class
 * 版权：Copyright by CVTE 公司
 * 描述：
 * 修改人：陈旭(chenxu9741@cvte.com)
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 *
 * @author 陈旭
 * @group [][] xx
 * @date 2022-08-18 15:37
 **/
public class CVTE校招6 {


    public static int[] calculate(int[] nums) {
        int len = nums.length;
        int[] res = new int[2];
        int maxLen = 1;
        int currLen = 1;
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int start = -1;
        int end = -1;
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                continue;
            }
            if (set.contains(i - 1)) {
                currLen++;
            } else {
                start = i;
                currLen = 1;
            }
            end = i;
            if (currLen > maxLen) {
                res[0] = start;
                res[1] = end;
                maxLen = end - start + 1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] a = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] calculate = calculate(a);
        System.out.println("end");
    }

    public static int[] calculate1(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        } // 开始数字

        int start = -1; // 结尾数字

        int end = -1; // 最长区间值

        int longestStreak = 0;
        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                if (longestStreak < currentStreak) {
                    start = num;
                    end = currentNum;
                    longestStreak = currentStreak;
                }
            }
        }
        return new int[]{start, end};
    }
}
