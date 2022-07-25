package com.leetcode.prac2445;

/**
 * 2224. 转化时间需要的最少操作数
 * 给你两个字符串 current 和 correct ，表示两个 24 小时制时间 。
 * 24 小时制时间 按 "HH:MM" 进行格式化，其中 HH 在 00 和 23 之间，而 MM 在 00 和 59 之间。最早的 24 小时制时间为 00:00 ，最晚的是 23:59 。
 * 在一步操作中，你可以将 current 这个时间增加 1、5、15 或 60 分钟。你可以执行这一操作 任意 次数。
 * 返回将current 转化为 correct 需要的 最少操作数 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-number-of-operations-to-convert-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class convertTime {
    public static void main(String[] args) {
        String current = "03:04";
        String correct = "04:42";
        int i = convertTime(current, correct);
        int j = convertTime2(current, correct);
        System.out.println(i + ";" + j);
    }

    /**
     * @param current
     * @param correct
     * @return
     */
    public static int convertTime(String current, String correct) {
        String[] currentArr = current.split(":");
        int currentHour = Integer.parseInt(currentArr[0]);
        int currentMinute = Integer.parseInt(currentArr[1]);

        String[] correctArr = correct.split(":");
        int correctHour = Integer.parseInt(correctArr[0]);
        int correctMinute = Integer.parseInt(correctArr[1]);

        int allMinutes = correctHour * 60 + correctMinute - (currentHour * 60 + currentMinute);
        int hour = allMinutes / 60;
        int minute = allMinutes % 60;

        int res =  hour + minute / 15 + (minute % 15 / 5) + (minute - minute / 15 * 15 - (minute % 15 / 5) * 5);


        return res;


    }

    /**
     * @param current
     * @param correct
     * @return
     */
    public static int convertTime2(String current, String correct) {
        String[] currentTime = current.split(":");
        int currentSecond = Integer.parseInt(currentTime[0]) * 60 + Integer.parseInt(currentTime[1]);
        String[] correctTime = correct.split(":");
        int correctSecond = Integer.parseInt(correctTime[0]) * 60 + Integer.parseInt(correctTime[1]);

        int difSecond = correctSecond - currentSecond;
        int cnt = 0;
        cnt += difSecond / 60;
        difSecond = difSecond % 60;
        cnt += difSecond / 15;
        difSecond = difSecond % 15;
        cnt += difSecond / 5;
        difSecond = difSecond % 5;
        cnt += difSecond / 1;
        difSecond = difSecond % 1;
        return cnt;

    }


}
