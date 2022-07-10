package com.huawei.prac01;

import java.util.Scanner;
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
