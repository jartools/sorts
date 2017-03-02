package com.sorts;

/**
 * 
 * @title 选择排序
 * 
 * @author Canyon
 *
 * @time 2017年3月1日 下午3:59:48
 */
public class Selection {
	/**
	 * 选择排序<br/>
	 * <li>在未排序序列中找到最小元素，存放到排序序列的起始位置</li> 
	 * <li>再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。</li>
	 * <li>以此类推，直到所有元素均排序完毕。</li>
	 * 
	 * 循环一次i只排序了一次，冒泡排序循环一次，会至少排序N次(非负数整数)
	 * @param numbers
	 */
	public static void selectSort(Integer[] numbers) {
		int size = numbers.length, temp;
		int k = 0;
		for (int i = 0; i < size; i++) {
			k = i;
			for (int j = size - 1; j > i; j--) {
				if (numbers[j] < numbers[k])
					k = j;
			}
			temp = numbers[i];
			numbers[i] = numbers[k];
			numbers[k] = temp;
		}
	}

}
