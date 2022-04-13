package com.xu.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxu
 * @version 1
 * @date 2021/12/21 4:07 下午
 */
public class CVTE校招3 {
    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
        getOutOrder(7, 3);
//        System.out.println();
//        System.err.println("fff " + (System.currentTimeMillis() - start));
        int[] a = {1,3,2,4,7,6,5,1,8};

        System.out.println(findDuplicateNum(a));
    }
    public static void getOutOrder(int n,int m){
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }

        int count=0;
        int t=0;
        while(list.size()!=0){
            count=(count+1)%m;
            if(count==0){
                System.out.println(list.get(t));
                list.remove(t);
                t--;
            }
            t++;
            if(t>=list.size()){
                t=0;
            }
        }
    }


    public static int findDuplicateNum(int[] nums){

        //因为是1-n个数，均大于0，所以我们可以用负数标记，当负负为正之时，就说明对应数字重复了
        for(int i=0;i<nums.length;i++){
            int a=Math.abs(nums[i]);
            if(nums[a-1]<0)
                return a;  //返回的是value，不是index
            else
                nums[a-1]*=-1;
        }
        return -1;
    }

//    public static int findDuplicateNum(int[] nums) {
//        int result = 0;
//        int i = 0, j = 0;
//        while (true) {
//            i = nums[nums[i]];
//            j = nums[j];
//            if (i == j) {
//                i = 0;
//                while (nums[j] != nums[i]) {
//                    i = nums[i];
//                    j = nums[j];
//                }
//                result = nums[j];
//                return result;
//            }
//
//        }
//
//
//    }

//    public static void getOutOrder(int n, int m) {
////        int[] num = new int[n];
//        for (int i = 0; i < n; i++) {
//            int a = getOutI(n, m, i + 1) + 1;
//            System.out.print(a + " ");
//        }
////        System.out.print("getOutOrder("+ n +", "+ m +")=");
////        for (int i = 0; i < n; i++) {
////            System.out.print(num[i] + " ");
////        }
////        System.out.println("\n");
//    }

    public static int getOutI(int n, int m, int i) {
        if (i == 1) {
            return (n + m - 1) % n;
        } else {
            return (getOutI(n - 1, m, i - 1) + m) % n;
        }
    }

    public static void f(int n, int m) {
        int t = m;
        if (m > n) {
            t = m - n;
        }
        for (int i = 0; i < n; i++) {

        }


    }


//    public static void getOutOrder(int n, int m) {
//
//        int count = 0;
//        int[] list = new int[n];
//        for (int i = 0; i < n; i++) {
//            list[i] = i;
//        }
//
//        while (list.length == 0)
//        {
//            for (int i = 0; i < list.length; i++) {
//                count++;
//                if (count == m) {
//                    System.out.println(list[i]);
//                }
//
//            }
//
//        }
//
//    }
}
