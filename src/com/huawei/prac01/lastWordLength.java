package com.huawei.prac01;

import java.util.Scanner;

/**
 * 华为HJ1 字符串最后一个单词的长度
 * 描述
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
 * 输入描述：
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 *
 * 输出描述：
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 */
public class lastWordLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int length = s.length();
        int index = length - 1;
        while (index >= 0) {
            if (s.charAt(index) == ' ') {
                break;
            }
            index--;

        }
        int result = length - 1 - index;
        System.out.println(result);

    }


}
