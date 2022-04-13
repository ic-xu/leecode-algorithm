package com.xu.algorithm;

import java.util.*;

/**
 * @author chenxu
 * @version 1
 * @date 2022/4/1 9:57 下午
 */
public class L15 {

    Map<Integer, Boolean> resolution = new HashMap<>();

    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        //如果数组长度小于3，直接返回空
        if (nums.length < 3) {
            return result;
        }
        //排序
        Arrays.sort(nums);
        //如果数组中的数全是正数或者全是负数，也返回[]；
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return result;
        }
        //让当前数据和左右数据相比较，小于0就往右边移动一位，大于0就往左边移动一位
        int L;
        int R;
        int tmpSum;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            L = i + 1;
            R = nums.length - 1;
            while (L < R) {
                 tmpSum = nums[i] + nums[L] + nums[R];
                if (tmpSum == 0) {
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
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
                } else if (tmpSum > 0) {
                    //向右边过滤相同值的数据运算
                    R--;
                } else {
                    //向左边过滤相同值的数据运算
                    L++;
                }
            }
        }
        return result;
    }


    public List<List<Integer>> threeSum0(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++; // 去重
                    while (L < R && nums[R] == nums[R - 1]) R--; // 去重
                    L++;
                    R--;
                } else if (sum < 0) L++;
                else R--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = {-1, 0, 1, 2, -1, -4};
//        ints = new int[]{0, 0, 0, 0, 0, -0};
        ints = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new L15().threeSum(ints);
        System.out.println(lists.toString());
    }
}
