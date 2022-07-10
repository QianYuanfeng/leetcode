package com.huawei.prac02;

import java.util.Scanner;

public class timesOfWord {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String target = in.nextLine();

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equalsIgnoreCase(target)) {
                result++;
            }
        }
        System.out.println(result);


    }
}
