package com.mhuffers.unittesting.unittesting.business;

import static org.junit.Assert.*;

import org.junit.Test;

public class SomeBusinessImplTest {

	@Test
	public void calculateSum_basic() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		int actual = businessImpl.calculateSum(new int[]{1,2,3});
		int expected = 6;
		assertEquals(expected, actual);
	}

	@Test
	public void calculateSum_empty() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		int actual = businessImpl.calculateSum(new int[]{});
		int expected = 0;
		assertEquals(expected, actual);
	}
	@Test
	public void calculateSum_oneValue() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		int actual = businessImpl.calculateSum(new int[]{3});
		int expected = 3;
		assertEquals(expected, actual);
	}

}
