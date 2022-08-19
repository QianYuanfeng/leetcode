package com.leetcode.prac1450;

/**
 * 1450. 在既定时间做作业的学生人数
 * 给你两个整数数组 startTime（开始时间）和 endTime（结束时间），并指定一个整数 queryTime 作为查询时间。
 * 已知，第 i 名学生在 startTime[i] 时开始写作业并于 endTime[i] 时完成作业。
 * 请返回在查询时间 queryTime 时正在做作业的学生人数。形式上，返回能够使 queryTime 处于区间 [startTime[i], endTime[i]]（含）的学生人数。
 * startTime.length == endTime.length
 * 1 <= startTime.length <= 100
 * 1 <= startTime[i] <= endTime[i] <= 1000
 * 1 <= queryTime <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class busyStudent {


    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int index = 0;
        int res = 0;
        while (index < startTime.length) {
            if (startTime[index] <= queryTime && endTime[index] >= queryTime) {
                res++;
            }
            index++;
        }

        return res;
    }

}
