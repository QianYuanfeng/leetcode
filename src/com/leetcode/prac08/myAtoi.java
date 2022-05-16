package com.leetcode.prac08;


/**
 * 8. 字符串转换整数 (atoi)
 * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * <p>
 * 函数myAtoi(string s) 的算法如下：
 * <p>
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231, 231− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231− 1 的整数应该被固定为 231− 1 。
 * 返回整数作为最终结果。
 * 注意：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 * <p>
 * 0 <= s.length <= 200
 * s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
 */
public class myAtoi {


    public static void main(String[] args) {
        String s = "4193 with words";
        int i = myAtoi(s);
        System.out.println("输出：" + i);
    }

    public static int myAtoi(String s) {
        Long atoiResult = 0L;
        s = s.trim();
        String symbol = "+";
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                symbol = "-";
                continue;
            }

            if (i == 0 && s.charAt(i) == '+') {
                symbol = "+";
                continue;
            }

            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                break;
            }
            atoiResult = atoiResult * 10 + s.charAt(i) - '0';

            if ("-".equalsIgnoreCase(symbol)) {
                if (-atoiResult < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                if (atoiResult > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            }
        }
        if ("-".equalsIgnoreCase(symbol)) {
            atoiResult = -atoiResult;
        }
        return Math.toIntExact(atoiResult);
    }


    public static Long toStr(String s) {

        Long result = 0L;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                result = result * 10 + (s.charAt(i) - '0');
                if (result > Integer.MAX_VALUE) {
                    result = Long.valueOf(Integer.MAX_VALUE) - 1;
                    break;
                }
            } else {
                break;
            }
        }

        return result;
    }


}
