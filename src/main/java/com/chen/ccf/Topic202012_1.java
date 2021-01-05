package com.chen.ccf;

import java.util.Scanner;

/**
 * @ClassName: chen-tool
 * @Description: TODO
 * @Author: 陈亮平
 * @Date: 2020/12/28 22:35
 * @Version: v1.0
 */
public class Topic202012_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int score, w;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            score = in.nextInt();
            w = in.nextInt();
            sum += score * w;
        }
        System.out.println(Math.max(0, sum));
    }
}
