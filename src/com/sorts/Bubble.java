package com.sorts;
/**
 * 
 * @title 冒泡排序
 * 
 * @author Canyon
 *
 * @time 2017年3月1日 下午3:08:58
 */
public class Bubble extends BasicSort {
	/**  
	 * 冒泡法排序(由小到大)<br/>  
	 * <li>比较相邻的元素。如果第一个比第二个大，就交换他们两个。</li>  
	 * <li>对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。</li>  
	 * <li>针对所有的元素重复以上的步骤，除了最后一个。</li>  
	 * <li>持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。</li> 
	 *   
	 * @param numbers  
	 *            需要排序的整型数组  
	 */  
	public static Integer[] bubbleSort(Integer[] numbers) {   
	    int temp; // 记录临时中间值   
	    int size = numbers.length; // 数组大小   
	    for (int i = 0; i < size - 1; i++) {   
	        for (int j = i + 1; j < size; j++) {   
	            if (numbers[i] > numbers[j]) { // 交换两数的位置   
	                temp = numbers[i];   
	                numbers[i] = numbers[j];   
	                numbers[j] = temp;   
	            }   
	        }   
	    }   
	    return numbers;
	}
	
	public static int bubbleSort(int[] numbers) {   
	    int size = numbers.length; // 数组大小
	    int count = 0;
	    for (int i = 0; i < size - 1; i++) {   
	        for (int j = i + 1; j < size; j++) {   
	            if (numbers[i] > numbers[j]) { // 交换两数的位置   
	                swap(numbers, i, j);
	            }
	            ++count;
	        }   
	    }   
	    return count;
	}
	
	// desc - 降序， asc - 升序
	static public int bSortAse(int... nums) {
		int len1 = nums.length - 1;
		int count = 0;
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len1 - i; j++) {
				if(nums[j] > nums[j+1]) {
					swap(nums, j, j+1);
				}
				++count;
			}
		}
		return count;
	}
	
	static public int bSortDesc(int... nums) {
		int len1 = nums.length - 1;
		int count = 0;
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len1 - i; j++) {
				if(nums[j] < nums[j+1]) {
					swap(nums, j, j+1);
				}
				++count;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] arrs = {3,6,4,2,11,10,5};
		bubbleSort(arrs);
		print(arrs);
		arrs = new int[]{3,6,4,2,11,10,5};
		bSortAse(arrs);
		print(arrs);
		
		arrs = new int[]{3,6,4,2,11,10,5};
		bSortDesc(arrs);
		print(arrs);
	}
}
