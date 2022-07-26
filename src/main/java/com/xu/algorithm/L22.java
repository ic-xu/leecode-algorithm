package com.xu.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenxu
 * @version 1
 * @date 2022/6/2 10:04
 */
public class L22 {


    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }



    public static List<String> generateParenthesis(int n) {
        // wuzhenyu
        List<String> ans = new ArrayList();
        dfs(ans, new char[n * 2], 0, n, n);
        return ans;
    }
    static void  dfs(List<String> ans, char[] cs, int pos, int left, int right) {
        if (pos == cs.length) {
            ans.add(String.valueOf(cs));
            return;
        }
        if (right > left) { // right剩下的一定要大于left才能保证左侧括号合法
            cs[pos] = ')';
            dfs(ans, cs, pos + 1, left, right - 1);
        }
        if (left > 0) {
            cs[pos] = '(';
            dfs(ans, cs, pos + 1, left - 1, right);
        }
    }
}
