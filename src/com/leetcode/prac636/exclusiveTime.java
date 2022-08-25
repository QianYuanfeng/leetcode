package com.leetcode.prac636;

import java.util.List;
import java.util.Stack;

/**
 * 函数的独占时间
 * 有一个 单线程 CPU 正在运行一个含有 n 道函数的程序。每道函数都有一个位于 0 和 n-1 之间的唯一标识符。
 * 函数调用 存储在一个 调用栈 上 ：当一个函数调用开始时，它的标识符将会推入栈中。而当一个函数调用结束时，它的标识符将会从栈中弹出。标识符位于栈顶的函数是 当前正在执行的函数 。每当一个函数开始或者结束时，将会记录一条日志，包括函数标识符、是开始还是结束、以及相应的时间戳。
 * 给你一个由日志组成的列表 logs ，其中 logs[i] 表示第 i 条日志消息，该消息是一个按 "{function_id}:{"start" | "end"}:{timestamp}" 进行格式化的字符串。例如，"0:start:3" 意味着标识符为 0 的函数调用在时间戳 3 的 起始开始执行 ；而 "1:end:2" 意味着标识符为 1 的函数调用在时间戳 2 的 末尾结束执行。注意，函数可以 调用多次，可能存在递归调用 。
 * 函数的 独占时间 定义是在这个函数在程序所有函数调用中执行时间的总和，调用其他函数花费的时间不算该函数的独占时间。例如，如果一个函数被调用两次，一次调用执行 2 单位时间，另一次调用执行 1 单位时间，那么该函数的 独占时间 为 2 + 1 = 3 。
 * 以数组形式返回每个函数的 独占时间 ，其中第 i 个下标对应的值表示标识符 i 的函数的独占时间。
 */
public class exclusiveTime {

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[n];
        for (String log : logs) {
            String[] logDetail = log.split(":");
            int s0 = Integer.parseInt(logDetail[0]);
            String s1 = logDetail[1];
            int s2 = Integer.parseInt(logDetail[2]);
            if (s1.equals("start")) {
                if (!stack.isEmpty()) {
                    int[] peek = stack.peek();
                    res[peek[0]] += s2 - peek[1];
                    peek[1] = s2;
                }
                stack.push(new int[]{s0, s2});

            } else {
                int[] t = stack.pop();
                res[t[0]] += s2 - t[1] + 1;
                if (!stack.isEmpty()) {
                    stack.peek()[1] = s2 + 1;
                }
            }
        }
        return res;
    }
}
