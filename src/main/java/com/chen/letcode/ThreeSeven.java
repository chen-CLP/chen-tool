package com.chen.letcode;

import java.util.Arrays;

/**
 * @ClassName: chen-tool
 * @Description: TODO
 * @Author: 陈亮平
 * @Date: 2021/4/16 14:51
 * @Version: v1.0
 */
public class ThreeSeven {

    public static void solveSudoku(char[][] board) {
        int[] visR = new int[10];
        int[] visC = new int[10];
        int[][] visB = new int[10][10];
        for (int i = 0; i < 9; ++i) {
            for (int ii = 0; ii < 9; ++ii) {
                if (board[i][ii] == '.') {
                    continue;
                }
                visR[i] = visR[i] | (1 << (board[i][ii] - '0'));
            }
        }

        for (int i = 0; i < 9; ++i) {
            for (int ii = 0; ii < 9; ++ii) {
                if (board[ii][i] == '.') {
                    continue;
                }
                visC[i] = visC[i] | (1 << (board[ii][i] - '0'));
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int ii = 0; ii < 9; ii += 3) {
                for (int j = 0; j < 3; ++j) {
                    for (int jj = 0; jj < 3; ++jj) {
                        if (board[i + j][ii + jj] == '.') {
                            continue;
                        }
                        visB[i][ii] = visB[i][ii] | (1 << (board[i + j][ii + jj] - '0'));
                    }
                }
            }
        }
        solve(visR, visC, visB, 0, 0, board);
    }

    public static boolean solve(int[] visR, int[] visC, int[][] visB, int r, int c, char[][] board) {
        if (c >= 9) {
            r++;
            c = 0;
        }
        if (r >= 9) {
            return true;
        }
        if (board[r][c] != '.') {
            return solve(visR, visC, visB, r, c + 1, board);
        }
        int b1 = visR[r];
        int b2 = visC[c];
        int b3 = visB[(r / 3) * 3][(c / 3) * 3];
        char b4 = board[r][c];
        for (int ii = 1; ii <= 9; ++ii) {
            if ((b1 & (1 << ii)) == 0 && (b2 & (1 << ii)) == 0 && (b3 & (1 << ii)) == 0) {
                board[r][c] = (char) ('0' + ii);
                visR[r] = b1 | (1 << ii);
                visC[c] = b2 | (1 << ii);
                visB[(r / 3) * 3][(c / 3) * 3] = b3 | (1 << ii);
                if (solve(visR, visC, visB, r, c + 1, board)) {
                    return true;
                }
            }
        }
        visR[r] = b1;
        visC[c] = b2;
        visB[(r / 3) * 3][(c / 3) * 3] = b3;
        board[r][c] = b4;
        return false;
    }


    public static void main(String[] args) {
        char[][] a = new char[][]
                {
                        {'.', '.', '.', '2', '.', '.', '.', '6', '3'},
                        {'3', '.', '.', '.', '.', '5', '4', '.', '1'},
                        {'.', '.', '1', '.', '.', '3', '9', '8', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '9', '.'},
                        {'.', '.', '.', '5', '3', '8', '.', '.', '.'},
                        {'.', '3', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '2', '6', '3', '.', '.', '5', '.', '.'},
                        {'5', '.', '3', '7', '.', '.', '.', '.', '8'},
                        {'4', '7', '.', '.', '.', '1', '.', '.', '.'}
                };
        solveSudoku(a);
        for (int i = 0; i < 9; ++i) {
            for (int ii = 0; ii < 9; ++ii) {
                System.out.print(a[i][ii]);
            }
            System.out.println();
        }

    }
}
