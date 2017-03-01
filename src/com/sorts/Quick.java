package com.sorts;

import java.util.List;

/**
 * 
 * @title 快速排序
 * 
 * @author Canyon
 *
 * @time 2017年3月1日 下午3:17:16
 */
public class Quick {
	/**
	 * 快速排序<br/>
	 * <ul>
	 * <li>从数列中挑出一个元素，称为“基准”</li>
	 * <li>重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分割之后，
	 * 该基准是它的最后位置。这个称为分割（partition）操作。</li>
	 * <li>递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。</li>
	 * </ul>
	 * 
	 * @param numbers
	 * @param start
	 * @param end
	 */
	static private Integer[] quickSort(Integer[] numbers, int start, int end) {
		if (start < end) {
			int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）
			int temp; // 记录临时中间值
			int i = start, j = end;
			do {
				while ((numbers[i] < base) && (i < end))
					i++;
				while ((numbers[j] > base) && (j > start))
					j--;
				if (i <= j) {
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
					i++;
					j--;
				}
			} while (i <= j);
			if (start < j)
				quickSort(numbers, start, j);
			if (end > i)
				quickSort(numbers, i, end);
		}
		return numbers;
	}

	public static Integer[] quickSort(Integer[] numbers) {
		int start = 0;
		int end = numbers.length - 1;
		return quickSort(numbers, start, end);
	}

	static private int getMiddle(Integer[] numbers, int low, int high) {
		int temp = numbers[low]; // 数组的第一个作为中轴
		while (low < high) {
			while (low < high && numbers[high] > temp) {
				high--;
			}

			// 比中轴小的记录移到低端
			numbers[low] = numbers[high];
			while (low < high && numbers[low] < temp) {
				low++;
			}
			numbers[high] = numbers[low]; // 比中轴大的记录移到高端
		}
		numbers[low] = temp; // 中轴记录到尾
		return low; // 返回中轴的位置
	}

	public static Integer[] quickSort2(Integer[] numbers) {
		int low = 0;
		int high = numbers.length - 1;
		return quickSort2(numbers, low, high);
	}

	static private Integer[] quickSort2(Integer[] numbers, int low, int high) {
		if (low < high) {
			int middle = getMiddle(numbers, low, high); // 将numbers数组进行一分为二
			quickSort2(numbers, low, middle - 1); // 对低字段表进行递归排序
			quickSort2(numbers, middle + 1, high); // 对高字段表进行递归排序
		}
		return numbers;
	}

	// #####################################
	// ########### 以下是c#的实现 #############
	// #####################################

	public static void QuickSort(List<Integer> list) {
		int low = 0;
		int high = list.size() - 1;
		QuickSort(list, low, high);
	}

	// / <summary>
	// / 快速排序算法
	// / </summary>
	static private void QuickSort(List<Integer> list, int low, int high) {
		if (low < high) {
			// 分割数组，找到枢轴
			int pivot = Partition(list, low, high);

			// 递归调用，对低子表进行排序
			QuickSort(list, low, pivot - 1);
			// 对高子表进行排序
			QuickSort(list, pivot + 1, high);
		}
	}

	// / <summary>
	// / 分割列表，找到枢轴
	// / </summary>
	private static int Partition(List<Integer> list, int low, int high) {
		// 用列表的第一个记录作枢轴记录
		int pivotKey = list.get(low);

		while (low < high) {
			while (low < high && list.get(high) >= pivotKey)
				high--;
			Swap(list, low, high);// 交换

			while (low < high && list.get(low) <= pivotKey)
				low++;
			Swap(list, low, high);
		}
		// 返回枢轴所在位置
		return low;
	}

	// / <summary>
	// / 交换列表中两个位置的元素
	// / </summary>
	private static void Swap(List<Integer> list, int low, int high) {
		int temp = -1;
		if (list != null && list.size() > 0) {
			temp = list.get(low);
			list.set(low, list.get(high));
			list.set(high, temp);
		}
	}
}
