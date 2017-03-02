package com.sorts;

/**
 * 
 * @title 插入排序
 * 
 * @author Canyon
 *
 * @time 2017年3月1日 下午4:06:23
 */
public class Insert {
	/**
	 * 插入排序<br/>
	 * <ul>
	 * <li>从第一个元素开始，该元素可以认为已经被排序</li>
	 * <li>取出下一个元素，在已经排序的元素序列中从后向前扫描</li>
	 * <li>如果该元素（已排序）大于新元素，将该元素移到下一位置</li>
	 * <li>重复步骤3，直到找到已排序的元素小于或者等于新元素的位置</li>
	 * <li>将新元素插入到该位置中</li>
	 * <li>重复步骤2</li>
	 * </ul>
	 * 
	 * @param numbers
	 */
	public static void insertSort(Integer[] numbers) {
		int size = numbers.length, temp, j;
		for (int i = 1; i < size; i++) {
			temp = numbers[i];
			for (j = i; j > 0 && temp < numbers[j - 1]; j--)
				numbers[j] = numbers[j - 1];
			numbers[j] = temp;
		}
	}
}
