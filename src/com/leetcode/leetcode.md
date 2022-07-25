# 3. 无重复字符的最长子串

**给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。**

示例 1:
输入: s = "abcabcbb"
输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

解法：滑动窗口；Hash

#921.排序数组
给你一个整数数组 nums，请你将该数组升序排列。
示例 1：

输入：nums = [5,2,3,1]
输出：[1,2,3,5]

#2224. 转化时间需要的最少操作数
给你两个字符串 current 和 correct ，表示两个 24 小时制时间 。
24 小时制时间 按 "HH:MM" 进行格式化，其中 HH 在 00 和 23 之间，而 MM 在 00 和 59 之间。最早的 24 小时制时间为 00:00 ，
最晚的是 23:59 。
在一步操作中，你可以将 current 这个时间增加 1、5、15 或 60 分钟。你可以执行这一操作 任意 次数。

返回将current 转化为 correct 需要的 最少操作数 。

示例 1：

输入：current = "02:30", correct = "04:35"
输出：3
解释：
可以按下述 3 步操作将 current 转换为 correct ：
- 为 current 加 60 分钟，current 变为 "03:30" 。
- 为 current 加 60 分钟，current 变为 "04:30" 。
- 为 current 加 5 分钟，current 变为 "04:35" 。
  可以证明，无法用少于 3 步操作将 current 转化为 correct 。`


来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/minimum-number-of-operations-to-convert-time
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。





