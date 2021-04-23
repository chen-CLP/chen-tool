package com.chen.letcode;

import java.util.Arrays;

/**
 * @ClassName: chen-tool
 * @Description: TODO
 * @Author: 陈亮平
 * @Date: 2021/4/16 13:52
 * @Version: v1.0
 */
public class ThreeSix {
    public boolean isValidSudoku(char[][] board) {
        int[] vis = new int[10];
        int c = board.length;
        if (c == 0) {
            return true;
        }
        int r = board[0].length;

        for (int i = 0; i < c; ++i) {
            Arrays.fill(vis, 0);
            for (int ii = 0; ii < r; ++ii) {
                if (board[i][ii] == '.') {
                    continue;
                }
                if (vis[board[i][ii] - '0'] == 1) {
                    return false;
                }
                vis[board[i][ii] - '0'] = 1;
            }
        }

        for (int i = 0; i < r; ++i) {
            Arrays.fill(vis, 0);
            for (int ii = 0; ii < c; ++ii) {
                if (board[ii][i] == '.') {
                    continue;
                }
                if (vis[board[ii][i] - '0'] == 1) {
                    return false;
                }
                vis[board[ii][i] - '0'] = 1;
            }
        }
        for (int i = 0; i < c; i += 3) {
            for (int ii = 0; ii < r; ii += 3) {
                Arrays.fill(vis, 0);
                for (int j = 0; j < 3; ++j) {
                    for (int jj = 0; jj < 3; ++jj) {
                        if (board[i + j][ii + jj] == '.') {
                            continue;
                        }
                        if (vis[board[i + j][ii + jj] - '0'] == 1) {
                            return false;
                        }
                        vis[board[i + j][ii + jj] - '0'] = 1;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(
                new ThreeSix().isValidSudoku(new char[][]{
                        {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                        {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                        {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                        {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                        {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                        {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                        {'.', '.', '4', '.', '.', '.', '.', '.', '.'}}));
    }
}
