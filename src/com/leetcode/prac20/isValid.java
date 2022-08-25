package com.leetcode.prac20;

import java.util.HashMap;

/**
 *
 */
public class isValid {
    public static void main(String[] args) {
        String s = "()";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        HashMap<String, String> bracketMap = new HashMap<>();
        bracketMap.put("(", ")");
        bracketMap.put("{", "}");
        bracketMap.put("[", "]");

        if (s.length() % 2 != 0) {
            return false;
        }

        if (s.length() == 2) {
            if (s.charAt(0) != s.charAt(1)) {
                return false;
            } else {
                return true;
            }
        }
        String leftStr = s.substring(0, s.length() / 2 - 1);
        String rightStr = s.substring(s.length() / 2, s.length() - 1);
        int index = 0;
        while (index < leftStr.length()) {
            Boolean flag = false;
            for (int i = 0; i < rightStr.length() && !flag; i++) {
                if (i == rightStr.length()) {
                    if (String.valueOf(rightStr.charAt(i)) == bracketMap.get(leftStr.charAt(index))) {
                        flag = true;
                        StringBuffer stringBuffer = new StringBuffer(rightStr);
                        stringBuffer.deleteCharAt(index);
                        break;
                    } else {
                        return false;
                    }
                } else {
                    if (String.valueOf(rightStr.charAt(i)) == bracketMap.get(leftStr.charAt(index))) {
                        flag = true;
                        StringBuffer stringBuffer = new StringBuffer(rightStr);
                        stringBuffer.deleteCharAt(index);
                        break;
                    }
                }

            }

            index++;
        }

        return true;
    }


}
