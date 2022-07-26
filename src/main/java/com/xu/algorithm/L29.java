package com.xu.algorithm;

/**
 * @author chenxu
 * @version 1
 * @date 2022/6/13 10:47
 */
public class L29 {

    public static int divide(int dividend, int divisor) {

        int signal = 0;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            signal = -1;
        }
        if (divisor == 1) {
            return dividend;
        } else if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) {
                return -dividend;
            }
            return Integer.MAX_VALUE;
        }

        if(dividend == Integer.MIN_VALUE){
            dividend = Integer.MAX_VALUE;
        }else {
            dividend = Math.abs(dividend);
        }
        divisor = Math.abs(divisor);
        if (divisor > dividend) {
            return 0;
        } else if (divisor == dividend) {
            return signal == 0 ? 1 : -1;
        }

        int cursor = 0;
        int divisorTmp = 0;
        while ((divisorTmp < dividend) && cursor < 31) {
            divisorTmp = divisor << cursor;
            cursor++;
        }
        cursor -= 2;

        int remainder = dividend - (divisor << cursor);
        int count = 0;
        while (remainder >= divisor) {
            remainder = remainder - divisor;
            count++;
        }
        int result = (1 << cursor) + count;
        return signal == 0 ? result : -result;
    }


    public static void main(String[] args) {
        int divide = divide(-2147483648,2);
        System.out.println(divide);
    }
}
