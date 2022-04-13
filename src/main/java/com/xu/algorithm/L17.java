package com.xu.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxu
 * @version 1
 * @date 2022/4/1 6:36 下午
 */
public class L17 {

    String[] numStringArr = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> resultString = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (null == digits || digits.isEmpty()) {
            return resultString;
        }
        sera(digits, 0);
        return resultString;
    }

    StringBuilder sb = new StringBuilder();

    private void sera(String digits, int index) {

        if (sb.length() == digits.length()) {
            resultString.add(sb.toString());
            return;
        }

        int c = digits.charAt(index) - 50;
        String numString = numStringArr[c];
        for (int j = 0; j < numString.length(); j++) {
            sb.append(numString.charAt(j));
            sera(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        L17 l17 = new L17();
        l17.letterCombinations("23");
    }

}
