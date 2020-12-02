package com.mhuffers.unittesting.unittesting.business;

import java.util.Arrays;

public class SomeBusinessImpl {
	public int calculateSum(int a[]) {
		return Arrays.stream(a).sum();
	}
}
