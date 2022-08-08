package com.offersecond.prac091;

/**
 * 剑指 Offer II 091. 粉刷房子
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个n x 3的正整数矩阵 costs 来表示的。
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2]表示第 1 号房子粉刷成绿色的花费，以此类推。
 * 请计算出粉刷完所有房子最少的花费成本。
 */
public class minCost {


    public static int minCost(int[][] costs) {
        int res;
        int length = costs.length;
        int a = costs[0][0];
        int b = costs[0][1];
        int c = costs[0][2];
        for (int i = 1; i < length; i++) {
            int d = Math.min(b, c) + costs[i][0];
            int e = Math.min(a, c) + costs[i][1];
            int f = Math.min(a, b) + costs[i][2];
            a = d;
            b = e;
            c = f;
        }
        res = Math.min(a, Math.min(b, c));
        return res;

    }


}
