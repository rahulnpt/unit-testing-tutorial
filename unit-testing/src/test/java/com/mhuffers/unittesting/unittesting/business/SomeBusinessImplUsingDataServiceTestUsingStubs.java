package com.mhuffers.unittesting.unittesting.business;

import static org.junit.Assert.*;

import org.junit.Test;

public class SomeBusinessImplUsingDataServiceTestUsingStubs {
	
	SomeDataService someDataServiceStub_basic = new SomeDataService() {
		@Override
		public int[] retrieveData() {
			return new int[]{1,2,3};
		}
	};
	
	SomeDataService someDataServiceStub_empty = new SomeDataService() {
		@Override
		public int[] retrieveData() {
			return new int[]{};
		}
	};
	SomeDataService someDataServiceStub_oneValue = new SomeDataService() {
		@Override
		public int[] retrieveData() {
			return new int[]{3};
		}
	};
	
	@Test
	public void  calculateSumUsingDataLayer_basic() {
		SomeBusinessImplUsingDataService businessImplUsingDataService = new SomeBusinessImplUsingDataService();
		businessImplUsingDataService.setSomeDataService(someDataServiceStub_basic);
		
		int actaul = businessImplUsingDataService.calculateSumUsingDataLayer();
		int expected = 6;
		assertEquals(actaul,expected);
	}
	
	@Test
	public void  calculateSumUsingDataLayer_empty() {
		SomeBusinessImplUsingDataService businessImplUsingDataService = new SomeBusinessImplUsingDataService();
		businessImplUsingDataService.setSomeDataService(someDataServiceStub_empty);
		
		int actaul = businessImplUsingDataService.calculateSumUsingDataLayer();
		int expected = 0;
		assertEquals(actaul,expected);
	}
	
	@Test
	public void  calculateSumUsingDataLayer_oneValue() {
		SomeBusinessImplUsingDataService businessImplUsingDataService = new SomeBusinessImplUsingDataService();
		businessImplUsingDataService.setSomeDataService(someDataServiceStub_oneValue);
		
		int actaul = businessImplUsingDataService.calculateSumUsingDataLayer();
		int expected = 3;
		assertEquals(actaul,expected);
	}
}
