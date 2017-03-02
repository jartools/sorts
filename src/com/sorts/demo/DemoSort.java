package com.sorts.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.sorts.Bubble;
import com.sorts.Insert;
import com.sorts.Merge;
import com.sorts.Quick;
import com.sorts.Selection;
import com.sorts.Shell;

public class DemoSort {

	// / <summary>
	// / 打印列表元素
	// / </summary>
	public static void Display(List<Integer> list) {
		Integer[] arrs = {};
		arrs = list.toArray(arrs);
		Display(arrs);
	}

	public static void Display(Integer... list) {
		System.out.println("**********展示结果**********");
		if (list != null && list.length > 0) {
			for (int item : list) {
				System.out.print(item);
				System.out.print("_");
			}
			System.out.println();
		}
		System.out.println("**********展示完毕**********");
	}

	public static void main(String[] args) throws Exception {
		testSorts();
	}

	static void test() throws Exception {
		long start = System.currentTimeMillis();
		Thread.sleep(1000);
		long end = System.currentTimeMillis();
		System.out.println(end - start + "ms");
	}

	static void testSorts() throws Exception {

		// 共进行三次比较
		Integer[] arrs = {};
		long beg = 0, diff = 0;
		List<Integer> listTemp = new ArrayList<Integer>();
		for (int i = 1; i <= 3; i++) {
			// 初始化List
			List<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < 1000; j++) {
				Thread.sleep(1);
				list.add(new Random(System.currentTimeMillis()).nextInt(10000));
			}

			// 快速排序(系统内置)耗费时间
			System.out.println("\n第" + i + "次比较:");
			Display(list);

			beg = System.currentTimeMillis();
			arrs = list.toArray(arrs);
			Quick.quickSort(arrs);
			diff = System.currentTimeMillis() - beg;
			System.out.println("快速排序1(系统)耗费时间:" + diff + " ms");
			Display(arrs);

			beg = System.currentTimeMillis();
			arrs = list.toArray(arrs);
			Quick.quickSort2(arrs);
			diff = System.currentTimeMillis() - beg;
			System.out.println("快速排序2(系统)耗费时间:" + diff + " ms");
			Display(arrs);

			listTemp.clear();
			listTemp.addAll(list);
			beg = System.currentTimeMillis();
			Quick.QuickSort(listTemp);
			diff = System.currentTimeMillis() - beg;
			System.out.println("快速排序(系统)耗费时间:" + diff + " ms");
			Display(listTemp);

			beg = System.currentTimeMillis();
			arrs = list.toArray(arrs);
			Bubble.bubbleSort(arrs);
			diff = System.currentTimeMillis() - beg;
			System.out.println("冒泡排序耗费时间:" + diff + " ms");
			Display(arrs);
			
			beg = System.currentTimeMillis();
			arrs = list.toArray(arrs);
			Insert.insertSort(arrs);
			diff = System.currentTimeMillis() - beg;
			System.out.println("插入排序耗费时间:" + diff + " ms");
			Display(arrs);
			
			beg = System.currentTimeMillis();
			arrs = list.toArray(arrs);
			Merge.mergeSort(arrs);
			diff = System.currentTimeMillis() - beg;
			System.out.println("归并排序耗费时间:" + diff + " ms");
			Display(arrs);
			
			beg = System.currentTimeMillis();
			arrs = list.toArray(arrs);
			Selection.selectSort(arrs);
			diff = System.currentTimeMillis() - beg;
			System.out.println("选择排序耗费时间:" + diff + " ms");
			Display(arrs);
			
			beg = System.currentTimeMillis();
			arrs = list.toArray(arrs);
			Shell.shellSort(arrs);
			diff = System.currentTimeMillis() - beg;
			System.out.println("希尔算法耗费时间:" + diff + " ms");
			Display(arrs);
		}
	}

}
