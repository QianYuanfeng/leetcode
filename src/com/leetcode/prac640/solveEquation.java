package com.leetcode.prac640;

/**
 * 640. 求解方程
 * 求解一个给定的方程，将x以字符串 "x=#value"的形式返回。该方程仅包含 '+' ， '-' 操作，变量x和其对应系数。
 * 如果方程没有解，请返回"No solution"。如果方程有无限解，则返回 “Infinite solutions” 。
 * 如果方程中只有一个解，要保证返回值 'x'是一个整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/solve-the-equation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solveEquation {

    public String solveEquation(String equation) {
        String[] equationArray = equation.split("=");
        String[] leftArray = equationArray[0].replace("-", "+-").split("\\+");
        String[] rightArray = equationArray[1].replace("-", "+-").split("\\+");
        //系数
        int x = 0;
        int y = 0;
        for (String s : leftArray) {
            if (s.equals("x")) {
                x += 1;
            } else if (s.equals("-x")) {
                x -= 1;
            } else if (s.contains("x")) {
                x += Integer.parseInt(s.substring(0, s.length() - 1));
            } else if (!s.equals("")) {
                y -= Integer.parseInt(s);
            }
        }

        for (String s : rightArray) {
            if (s.equals("x")) {
                x -= 1;
            } else if (s.equals("-x")) {
                x += 1;
            } else if (s.contains("x")) {
                x -= Integer.parseInt(s.substring(0, s.length() - 1));
            } else if (!s.equals("")) {
                y += Integer.parseInt(s);
            }
        }
        if (x == 0) {
            if (y == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            return "x=" + y / x;
        }


    }

}
