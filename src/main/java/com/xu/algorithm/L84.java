package com.xu.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 包名：com.xu.algorithm
 * 文件名：L84.class
 * 版权：Copyright by CVTE 公司
 * 描述：
 * 修改人：陈旭(chenxu9741@cvte.com)
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 *
 * @author 陈旭
 * @group [][] xx
 * @date 2022-10-13 10:32
 **/
public class L84 {


    public static void main(String[] args) {

        int[] a = new int[]{2,1,5,6,2,3};

        System.out.println(largestRectangleArea(a));


    }


    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int newheight[] = new int[n + 2];
        for (int i = 1; i <= n; i ++ ) {
            newheight[i] = heights[i - 1];
        }
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n + 2; i ++ ) {
            //如果当前值比栈顶小，就构成了一组可计算面积的
            while (!stack.isEmpty() && newheight[i] < newheight[stack.peek()]) {
                int cur = stack.pop();
                int peek = stack.peek();
                int tmpResult = (i - peek - 1) * newheight[cur];
                res = Math.max(res,tmpResult );
            }
            //比栈顶大，就入栈，维护单调递增栈
            stack.push(i);
        }
        return res;
    }

}
