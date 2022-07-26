package com.xu.algorithm;

import java.util.Arrays;

/**
 * @author chenxu
 * @version 1
 * @date 2022/5/11 09:31
 */
public class L16 {
    public static void main(String[] args) {
        int[] ints = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(ints, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int chazhi = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                //计算和
                int temp = nums[i] + nums[l] + nums[r];

                //计算差值
                int abs = Math.abs(temp - target);

              //记录最小的一个值
                if ( abs< chazhi) {
                    chazhi = abs;
                    res = temp;
                }

                //判断是在目标数字的左边还是右边
                if (temp < target) l++;
                if (temp >= target) r--;
            }
        }
        return res;
    }
}
