package com.leetcode.prac761;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class makeLargestSpecial {

    public String makeLargestSpecial(String s) {
        if (s.length() == 0) {
            return "";
        }
        List<String> list = new ArrayList<>();
        int count = 0;
        int last = 0;
        for (int i = 0, cur = 0; i < s.length(); i++, cur++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
            }
            //
            if (count == 0) {
                String str = "1" + makeLargestSpecial(s.substring(last + 1, cur)) + "0";
                list.add(str);
                last = cur + 1;
            }
        }
        list.sort(Comparator.reverseOrder());
        //拼成完整的字符串
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }


}
