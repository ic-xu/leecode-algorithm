package com.xu.algorithm;

import java.util.*;

/**
 * @author chenxu
 * @version 1
 * @date 2022/4/1 9:57 下午
 */
public class L18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        //如果数组长度小于3，直接返回空
        if (nums.length < 4) {
            return result;
        }
        //排序
        Arrays.sort(nums);
        int L;
        int R;
        int tmpSum;
        for (int i = 0; i < nums.length-3; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 3; j++) {
                if(j>nums.length-3) break;//小剪枝
                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                L = j + 1;
                R = nums.length - 1;
                while (L < R) {
                    tmpSum = nums[i] + nums[L] + nums[R] + nums[j];
                    if (tmpSum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        //向左边过滤相同值的数据运算
                        while (L < R && nums[L] == nums[L + 1]) {
                            L++;
                        }
                        //向右边过滤相同值的数据运算
                        while (L < R && nums[R] == nums[R - 1]) {
                            R--;
                        }
//                    继续寻找满足条件的值
                        L++;
                        R--;
                    } else if (tmpSum > target) {
                        //向右边过滤相同值的数据运算
                        R--;
                    } else {
                        //向左边过滤相同值的数据运算
                        L++;
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] ints = {-1, 0, 1, 2, -1, -4};
//        ints = new int[]{0, 0, 0, 0, 0, -0};
        ints = new int[]{1, 0, -1, 0, -2, 2};
        ints = new int[]{1, -2, -5, -4, -3, 3, 3, 5};
        List<List<Integer>> lists = new L18().fourSum(ints, -11);
        System.out.println(lists.toString());
    }
}
