package com.chen.letcode;

import java.util.Stack;

/**
 * @ClassName: chen-tool
 * @Description: TODO
 * @Author: 陈亮平
 * @Date: 2021/2/5 16:56
 * @Version: v1.0
 */
public class ThirtyThree {
    public static int longestValidParentheses(String s) {
        int result = 0;
        char[] tc = s.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tc.length; ++i) {
            if (tc[i] == ')' && !stack.empty() && tc[stack.peek()] == '(') {
                tc[i] = '.';
                tc[stack.peek()] = '.';
                stack.pop();
            } else {
                stack.add(i);
            }
        }
        int tm = 0;
        for (char i : tc) {
            if (i == '.') {
                tm++;
            } else {
                result = Math.max(tm, result);
                tm = 0;
            }
        }
        result = Math.max(tm, result);
        return result ;
    }

    public static void main(String[] args) {
        longestValidParentheses("()(())");
    }
}
