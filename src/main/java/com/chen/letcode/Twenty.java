package com.chen.letcode;

import java.util.Stack;

/**
 * @ClassName: chen-tool
 * @Description: 括号判断
 * @Author: 陈亮平
 * @Date: 2020/12/23 22:46
 * @Version: v1.0
 */
public class Twenty {
    public static boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char i : chars) {
            if (i == 32) {
                continue;
            }
            String te=String.valueOf(i);
            if (stack.empty()) {
                stack.add(te);
                continue;
            }
            if (")".equals(te) && "(".equals(stack.peek())) {
                stack.pop();
            } else if ("]".equals(te) && "[".equals(stack.peek())) {
                stack.pop();
            } else if ("}".equals(te) && "{".equals(stack.peek())) {
                stack.pop();
            } else {
                stack.add(te);
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        isValid("{}");
    }
}
