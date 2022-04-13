package com.xu.algorithm;


import java.util.*;

public class Main {


    public static void main(String[] args) {
//        int[] aa = {2, 3, 6};
//        int target = 4;
//
//        int[] part = {3, 2, 3, 4};
//        int[] time = {2, 1, 1, 3};
////        System.out.println(new Main().solution(aa, target));
//
//        System.out.println(new Main().func(time, part, 3));


        int[] ints = new int[]{52, 54, 57, 41, 41, 66, 70, 73};
        int[] indicators = indicators(ints);
        System.out.println(Arrays.toString(indicators));
    }

//    public List<List<Integer>> solution(int[] integerSet, int targetInteger) {
//        List<List<Integer>> outer = new ArrayList<>();
//        auxCombinationSum(new ArrayList<>(), outer, integerSet, targetInteger, 0);
//        return outer;
//    }
//
//    private void auxCombinationSum(List<Integer> inner, List<List<Integer>> outer, int[] candidate, int target, int start) {
//        if (target < 0) {
//            return;
//        }
//        if (target == 0) {
//            outer.add(new ArrayList<>(inner));
//        } else {
//            for (int i = start; i < candidate.length; i++) {
//                inner.add(candidate[i]);
//                auxCombinationSum(inner, outer, candidate, target - candidate[i], i);
//                inner.remove(inner.size() - 1);
//            }
//        }
//    }


    //---------------------第一份-----------------------------
    // 倍数关系，几倍？ 不是倍数关系？
//    List<List<Integer>> res = new ArrayList<>();
//    public List<List<Integer>> solution(int[] integerSet,int targetInteger){
//        for(int num : integerSet){
//            List<Integer> list = new ArrayList<>();
//            int count = 0;
//            // 有倍数关系
//            if(isNum(num,targetInteger)){
//                count = targetInteger / num;
//                while(count != 0){
//                    list.add(num);
//                    count--;
//                }
//            }else{
//                // target - num 是否为integerSet里的一个元素的倍数关系
//                int index = notNum(integerSet,targetInteger - num,list);
//                if(index != -1){
//                    list.add(num);
//                    count = (targetInteger - num ) / integerSet[index];
//                    while(count != 0){
//                        list.add(integerSet[index]);
//                        count--;
//                    }
//                }
//            }
//            if(!list.isEmpty()){
//                res.add(list);
//            }
//        }
//        return res;
//    }
//
//
//    public boolean isNum(int num,int target){
//        return (target % num) == 0;
//    }
//
//
//    public int notNum(int[] nums , int target , List<Integer> list){
//        for(int i = 0;i < nums.length;i++){
//            if(isNum(nums[i],target)){
//                return i;
//            }
//        }
//        return -1;
//    }


    //    //---------------------第二份-----------------------------
//public List<List<Integer>> solution(int[] integerSet, int targetInteger){
//    List<List<Integer>> res = new ArrayList<>(); //定义输出结果集
//    Arrays.sort(integerSet); //数组排序
//    func(res, new ArrayList<>(), integerSet, targetInteger, 0 ,0); //调用函数
//    return res; //返回结果
//}
//
//    public void func(List<List<Integer>> res, List<Integer> p, int[] integerSet, int targetInteger, int sum, int index){
//        //数字之和相等
//        if(sum == targetInteger){
//            res.add(new ArrayList<>(p));
//            return; //找到一个结果
//        }
//
//        for(int i = index; i< integerSet.length; i++){
//            //大于的时候，结束遍历
//            if(sum + integerSet[i] > targetInteger){
//                break;
//            }
//            p.add(integerSet[i]); //添加
//            func(res, p, integerSet, targetInteger, sum + integerSet[i], i);
//            p.remove(p.size() - 1); //回溯
//        }
//
//    }

    public int func(int[] applyTimes, int[] participants, int totalTime) {
        int dp[] = new int[1000];
        int l = applyTimes.length;
        for (int i = 0; i < l; i++) {
            for (int j = totalTime; j >= participants[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - participants[i]] + applyTimes[i]);
            }
        }
        return dp[totalTime];
    }

    public static int purchasePlanNumber(int[] clothes,int[] shoes,int x){
        int lenc = clothes.length;
        int lens = shoes.length;
        int res = 0;
        quickSort(clothes,0,lenc-1);
        quickSort(shoes,0,lens-1);
        while(clothes[lenc]+shoes[lens]<x){
            lens++;
            lenc++;
        }
        if(clothes[lenc]+shoes[--lens]<x){
            res  = lenc*(lens-1);
        }
        if(clothes[--lenc]+shoes[lens]<x){
            res = lenc*(lens-1);
        }
        return res;
    }
    public static void quickSort(int[] nums,int left,int right){
        if(left<right){
            int pivot = getPivot(nums,left,right);
            quickSort(nums,left,pivot-1);
            quickSort(nums,pivot+1,right);
        }
    }
    public static int getPivot(int[] nums,int left,int right){
        int temp = nums[left];
        while(left<right){
            while(left<right && nums[right]>=temp) right--;
            nums[left] = nums[right];
            while(left<right && nums[left]<=temp) left++;
            nums[right] = nums[left];
        }
        if(left==right) nums[left] = temp;
        return left;
    }


    public static int[] indicators(int[] visitorCounts) {
        List<Integer> list = new ArrayList<>();
        int left=0,right=1;

        while(right<visitorCounts.length && left<visitorCounts.length){
            if(visitorCounts[left]<visitorCounts[right]) {
                list.add(right-left);
                left = right;
                right++;
            }else{
                right++;
            }
        }

        list.add(0);
        int[] res = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            res[i] = list.get(i);
        }

        return res;
    }


}