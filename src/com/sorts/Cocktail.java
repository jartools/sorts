package com.sorts;

import java.util.Arrays;

/**
 * 
 * @title 鸡尾酒排序(双向冒泡排序)
 * 
 * @author Canyon
 *
 * @description 优点：在大部分元素已经有序的条件下，可以减少排序的回合数；缺点： 代码量增加。<br/>
 *              鸡尾酒排序是冒泡排序的一种改进，并未有本质的改变，与冒泡排序的时间复杂度和空间复杂度相近，整体的性能都比较差。
 * 
 * @time 2022年5月14日 下午7:07:08
 */
public class Cocktail extends Bubble {

	/**
	 * 鸡尾酒排序(双向冒泡排序)<br/>
	 * <li>先对数组从左到右进行升序的冒泡排序。</li>
	 * <li>再对数组进行从右到左的降序的冒泡排序。</li>
	 * <li>以此类推，持续的、依次的改变冒泡的方向，并不断缩小没有排序的数组范围。</li>
	 * 
	 * @param numbers 需要排序的整型数组
	 */
	public static int cocktailSort(int[] numbers) {
		int lens = numbers.length; // 数组大小
		int count = 0;
		for (int i = 0; i < lens / 2; i++) {
			for (int j = i; j < lens - 1 - i; j++) {
				if (numbers[j] > numbers[j + 1]) { // 交换两数的位置
					swap(numbers, j, j + 1);
				}
				++count;
			}

			for (int j = lens - 1 - i; j > i; j--) {
				if (numbers[j] < numbers[j - 1]) { // 交换两数的位置
					swap(numbers, j, j - 1);
				}
				++count;
			}
		}
		return count;
	}

	public static int cocktailSort2(int[] numbers) {
		int lens = numbers.length; // 数组大小
		int count = 0;
		for (int i = 0; i < lens / 2; i++) {
			boolean isSorted = true;
			for (int j = i; j < lens - 1 - i; j++) {
				if (numbers[j] > numbers[j + 1]) { // 交换两数的位置
					swap(numbers, j, j + 1);
					isSorted = false;
				}
				++count;
			}
			if (isSorted)
				break;
			isSorted = true;
			for (int j = lens - 1 - i; j > i; j--) {
				if (numbers[j] < numbers[j - 1]) { // 交换两数的位置
					swap(numbers, j, j - 1);
					isSorted = false;
				}
				++count;
			}
			if (isSorted)
				break;
		}
		return count;
	}

	public static int cocktailSort3(int[] numbers) {
		int begin = 0;
		int end = numbers.length - 1;
		int count = 0;
		while (begin < end) {
			for (int j = begin; j < end; j++) {
				if (numbers[j] > numbers[j + 1]) { // 交换两数的位置
					swap(numbers, j, j + 1);
				}
				++count;
			}
			--end;
			for (int j = end; j > begin; j--) {
				if (numbers[j] < numbers[j - 1]) { // 交换两数的位置
					swap(numbers, j, j - 1);
				}
				++count;
			}
			++begin;
		}
		return count;
	}

	static void testEntry(int... numbers) {
		int lens = numbers.length;
		int[] arrs = Arrays.copyOf(numbers, lens);
		// System.out.println(arrs == numbers);
		int count = bubbleSort(arrs);
		print("bubbleSort = " + count,arrs);

		arrs = Arrays.copyOf(numbers, lens);
		count = bSortAse(arrs);
		print("bSortAse = " + count,arrs);

		arrs = Arrays.copyOf(numbers, lens);
		count = bSortDesc(arrs);
		print("bSortDesc = " + count,arrs);

		arrs = Arrays.copyOf(numbers, lens);
		count = cocktailSort(arrs);
		print("cocktail = " + count,arrs);

		arrs = Arrays.copyOf(numbers, lens);
		count = cocktailSort2(arrs);
		print("cocktail2 = " + count,arrs);

		arrs = Arrays.copyOf(numbers, lens);
		count = cocktailSort3(arrs);
		print("cocktail3 = " + count,arrs);
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("=========main beg");
		testEntry(3, 6, 4, 2, 11, 10, 5);
		
		testEntry(2,3,4,5,6,7,8,1);
		
		testEntry(88, 7, 79, 64, 55, 98, 48, 52, 4, 13);
		System.out.println("=========main end");
	}

}
