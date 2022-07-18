package com.offer.prac40;

import java.util.Arrays;

/**
 * 面试题40. 最小的k个数
 * <p>
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class getLeastNumbers {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int k = 2;
        int[] leastNumbers = getLeastNumbers(arr, k);
        for (int i : leastNumbers) {
            System.out.println(i);
        }
    }


    /**
     * 快速选择排序
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    public static void quickSort(int[] arr, int l, int r) {

        if (l >= r) {
            return;
        }

        int i = l;
        int j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) {
                j--;
            }
            while (i < j && arr[i] <= arr[l]) {
                i++;
            }

            //交换
            swap(arr, i, j);
        }

        //交换
        swap(arr, i, l);

        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);


    }

    public static void swap(int[] arr, int i, int j) {
        //交换
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }


}
