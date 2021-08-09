package com.xu.algorithm;


import java.util.*;
import java.util.function.IntFunction;

public class TreeNodeMaxMoney {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {

        TreeNode left1 = new TreeNode(4);
        TreeNode right1 = new TreeNode(4);
        TreeNode left = new TreeNode(1, left1, right1);

        TreeNode left2 = new TreeNode(3);
        TreeNode right2 = new TreeNode(1);
        TreeNode right = new TreeNode(4, left2, right2);

        TreeNode root = new TreeNode(5, left, right);
        System.out.println(Arrays.toString(maxMoney(root)));
    }


    public static Integer[] maxMoney(TreeNode root) {
        Map<Integer, Integer> result = new TreeMap<>(Comparator.reverseOrder());
        Integer deep = 0;
        calculate(root, deep, result);
        return result.values().toArray(value -> new Integer[0]);
    }

    public static void calculate(TreeNode root, Integer deep, Map<Integer, Integer> result) {
        if (null != root) {
            Integer integer = result.computeIfAbsent(deep,(key)-> 0);
            result.put(deep, integer + root.val);
            deep++;
            calculate(root.left, deep, result);
            calculate(root.right, deep, result);
        }
        deep--;
    }



    public static Object[] maxMoney11(TreeNode root) {
        Map<Integer, Integer> result = new TreeMap<>();
        Integer deep = 0;
        calculate(root, deep, result);

        Map<Integer,List<Integer>> resultArr = new TreeMap<>(Integer::compareTo);

        search1(root,deep,resultArr);
        ArrayList<List<Integer>> objects = new ArrayList<>();
        for (List<Integer> list:resultArr.values()) {
            objects.add(list);
        }

        System.out.println(objects);
        return result.values().toArray();
    }


    public static void search1(TreeNode root, Integer deep,Map<Integer,List<Integer>> result) {
        System.err.println(deep);
        if (null != root) {
            List<Integer> integers = result.computeIfAbsent(deep,(key) -> new ArrayList<>());
            integers.add(root.val);
            deep++;
            search1(root.left, deep, result);
            search1(root.right, deep, result);
        }
        deep--;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Integer deep = 0;
        Map<Integer,List<Integer>> resultArr = new TreeMap<>();
        search1(root,deep,resultArr);
        return new ArrayList<>(resultArr.values());
    }
}
