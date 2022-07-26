package com.xu.algorithm;

import java.util.Arrays;

/**
 * @author chenxu
 * @version 1
 * @date 2022/5/10 20:13
 */
public class L6 {

    public String convert(String s, int numRows) {
        //如果numRows ==1，说明只有一行，则直接输出原来字符即可。
        if (numRows == 1 || s.length() == numRows) {
            return s;
        }
        //如果numRows > 1，则先把周期计算出来
        int period = 2 * numRows - 2;
        StringBuilder[] rowsString = new StringBuilder[numRows];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int mod = i % period;
            //然后判断，如果索引小于行数，则直接添加进行数组中
            if (mod < numRows) {
                if (null == rowsString[mod]) {
                    rowsString[mod] = new StringBuilder();
                }
                rowsString[mod].append(charArray[i]);
            } else {//如果不是，则需要递减行的索引
                if (null == rowsString[period - mod]) {
                    rowsString[period - mod] = new StringBuilder();
                }
                rowsString[period - mod].append(charArray[i]);
            }
        }
        //把数组拼接在一起
        for (int i = 1; i < rowsString.length; i++) {
            if (null != rowsString[i]) {
                rowsString[0].append(rowsString[i].toString());
            }
        }
        return rowsString[0].toString();
    }


    public static void main(String[] args) {
        L6 l6 = new L6();
        String convert = l6.convert("PAYPALISHIRING", 3);
        System.out.println(convert);
    }
}
