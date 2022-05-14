package com.sorts;

public class BasicSort {
	static protected void print(int... nums) {
		System.out.println("=== beg ===");
		for (int i : nums) {
			System.out.print("[");
			System.out.print(i);
			System.out.print("]");
			System.out.print("_");
		}
		System.out.println();
		System.out.println("=== end ===");
	}
}
