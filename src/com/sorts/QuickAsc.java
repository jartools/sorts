package com.sorts;

import java.util.Arrays;

/**
 * 
 * @title 快速排序2
 * 
 * @author Canyon
 *
 * @time 2022年05月15日 下午7:57:26
 */
public class QuickAsc extends Cocktail {
	static void quickAsc(int low, int high, int[] arr) {
		// 递归返回条件
		if (low >= high) {
			return;
		}
		/*
		 * 为什么要定义i和j来代替low和high呢，因为后续左右区间元素还需要用到
		 * low和high两个变量，至于key值得引入，其实用arr[low]代替完全没有 影响
		 */
		int j = high;
		int i = low;
		int key = arr[i];// 基准值
		/*
		 * 当这个while内部达到i==j的田间时，while循环终止
		 */
		while (i < j) {
			/*
			 * 解释一下内层两个while的"i<j":
			 *
			 * 当数组元素为{2，3}时，第一次j--后i=j,arr[j]=arr[0]=2=key,不加
			 * "i<j"，则j继续j--,则出现arr[-1]，数组下标越界
			 */
			while (arr[j] >= key && i < j) {
				j--;
			}

			while (arr[i] <= key && i < j) {
				i++;
			}

			/*
			 * i!=j时交换arr[i]和arr[j] i=j时交换arr[i]等于arr[j],交换arr[i]和基准处的值 不要想着可以
			 * arr[i]=arr[low];arr[low]=arr[j]; 这是很傻的
			 *
			 */
			if (i != j) {
				int temp;
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				System.out.println(Arrays.toString(arr) + " 正在排序中5.........");
			} else {
				int temp;
				temp = arr[j];
				arr[j] = arr[low];
				arr[low] = temp;
				System.out.println(Arrays.toString(arr) + " 正在排序中6.........");
			}
		}

		/*
		 * 你可能觉得当一个数组中最小元素在第一个的时候，i-1小于0，后续代码中 使用arr[i-1]的时候可能数组下标越界，放心，当i-1小于0时首先不满足递
		 * 归边界条件，递归就会返回。
		 */
		quickAsc(low, i - 1, arr);

		/*
		 * 你可能觉得当一个数组中最大元素在最后的时候，i+1大于0，后续代码中 使用arr[i+1]的时候可能数组下标越界，放心，当i+1大于0时首先不满足递
		 * 归边界条件，递归就会返回。
		 */
		quickAsc(i + 1, high, arr);
	}

	static public void quick(int low, int high, int... arrs) {
		if (low >= high)
			return;
		/*
		 * 为什么要定义i和j来代替low和high呢，因为后续左右区间元素还需要用到
		 * low和high两个变量，至于key值得引入，其实用arr[low]代替完全没有 影响
		 */
		int i = low;
		int j = high;
		int key = arrs[i];
		// 当这个while内部达到 i==j 时，while循环终止
		while (i < j) {
			/*
			 * 解释一下内层两个while的"i<j":
			 *
			 * 当数组元素为{2，3}时，第一次j--后i=j,arr[j]=arr[0]=2=key,不加
			 * "i<j"，则j继续j--,则出现arr[-1]，数组下标越界
			 */
			while (i < j && arrs[j] >= key) {
				j--;
			}
			while (i < j && arrs[i] <= key) {
				i++;
			}

			if (i != j) {
				swap(arrs, i, j);
				System.out.println(Arrays.toString(arrs) + " 正在排序中3.........");
			} else {
				swap(arrs, low, j);
				System.out.println(Arrays.toString(arrs) + " 正在排序中4.........");
			}
		}
		/*
		 * 你可能觉得当一个数组中最小元素在第一个的时候，i-1小于0，后续代码中 使用arr[i-1]的时候可能数组下标越界， 放心，当i-1小于0时首先不满足递
		 * 归边界条件，递归就会返回。
		 */
		quick(low, i - 1, arrs);

		/*
		 * 你可能觉得当一个数组中最大元素在最后的时候，i+1大于0，后续代码中 使用arr[i+1]的时候可能数组下标越界， 放心，当i+1大于0时首先不满足递
		 * 归边界条件，递归就会返回。
		 */
		quick(i + 1, high, arrs);
	}

	static public void sort(int low, int high, int... arrs) {
		if (low >= high)
			return;
		/*
		 * 为什么要定义i和j来代替low和high呢，因为后续左右区间元素还需要用到
		 * low和high两个变量，至于key值得引入，其实用arr[low]代替完全没有 影响
		 */
		int i = low;
		int j = high;
		int key = arrs[i];
		// 当这个while内部达到 i==j 时，while循环终止
		while (i < j) {
			/*
			 * 解释一下内层两个while的"i<j":
			 *
			 * 当数组元素为{2，3}时，第一次j--后i=j,arr[j]=arr[0]=2=key,不加
			 * "i<j"，则j继续j--,则出现arr[-1]，数组下标越界
			 */
			while (i < j && arrs[j] >= key) {
				j--;
			}
			swap(arrs, i, j);
			System.out.println(Arrays.toString(arrs) + " 正在排序中1.........");

			while (i < j && arrs[i] <= key) {
				i++;
			}
			swap(arrs, i, j);
			System.out.println(Arrays.toString(arrs) + " 正在排序中2.........");
		}
		/*
		 * 你可能觉得当一个数组中最小元素在第一个的时候，i-1小于0，后续代码中 使用arr[i-1]的时候可能数组下标越界， 放心，当i-1小于0时首先不满足递
		 * 归边界条件，递归就会返回。
		 */
		sort(low, i - 1, arrs);

		/*
		 * 你可能觉得当一个数组中最大元素在最后的时候，i+1大于0，后续代码中 使用arr[i+1]的时候可能数组下标越界， 放心，当i+1大于0时首先不满足递
		 * 归边界条件，递归就会返回。
		 */
		sort(i + 1, high, arrs);
	}

	public static void main(String[] args) {
		int[] arr = { 6, 1, 2, 7, 9, 3, 4, 5, 10, 8 };
		System.out.println(Arrays.toString(arr) + " 原始数据。。。。。");
		sort(0, arr.length - 1, arr);
		System.out.println(Arrays.toString(arr) + " 排序完成1。。。。。。");
		arr = new int[] { 6, 1, 2, 7, 9, 3, 4, 5, 10, 8 };
		quick(0, arr.length - 1, arr);
		System.out.println(Arrays.toString(arr) + " 排序完成2。。。。。。");
		arr = new int[] { 6, 1, 2, 7, 9, 3, 4, 5, 10, 8 };
		quickAsc(0, arr.length - 1, arr);
	}

}
