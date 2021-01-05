package com.chen.ccf;

import java.util.Scanner;

/**
 * @ClassName: chen-tool
 * @Description: 第一次
 * @Author: 陈亮平
 * @Date: 2020/12/28 18:06
 * @Version: v1.0
 */
public class Topic202009_1 {
    static class Node implements Comparable {
        private int index;
        private double dist;

        @Override
        public int compareTo(Object o) {
            Node t = (Node) o;
            return this.dist < t.dist ? 1 : 0;
        }
    }

    public static double calculateDist(int x, int y, int xx, int yy) {
        return Math.pow((x - xx), 2) + Math.pow((y - yy), 2);
    }

    public static void main(String[] args) {
        int n, x, y;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        x = in.nextInt();
        y = in.nextInt();
        Node[] nodes = new Node[n];
        int tx, ty;
        for (int i = 0; i < n; ++i) {
            tx = in.nextInt();
            ty = in.nextInt();
            nodes[i].dist = calculateDist(x, y, tx, ty);
            nodes[i].index = i;
        }

    }
}
