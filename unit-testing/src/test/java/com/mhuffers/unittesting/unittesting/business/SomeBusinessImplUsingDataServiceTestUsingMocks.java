package com.mhuffers.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class SomeBusinessImplUsingDataServiceTestUsingMocks {
	
	private SomeBusinessImplUsingDataService businessImplUsingDataService = new SomeBusinessImplUsingDataService();
	
	//private SomeDataService dataService = mock(SomeDataService.class);
	private SomeDataService dataService;
	
	/*
	 * @Before will help setting the mock service before execution of every test case.
	 * Other option is to call the setter explicitly inside every method 
	 */
	@Before
	public void before() {
		businessImplUsingDataService.setSomeDataService(dataService);
	}
	
	@Test
	public void  calculateSumUsingDataLayer_basic() {
		when(dataService.retrieveData()).thenReturn(new int[]{1,2,3});
		assertEquals(businessImplUsingDataService.calculateSumUsingDataLayer(),6);
	}
	
	@Test
	public void  calculateSumUsingDataLayer_empty() {
		when(dataService.retrieveData()).thenReturn(new int[]{});
		assertEquals(businessImplUsingDataService.calculateSumUsingDataLayer(),0);
	}
	
	@Test
	public void  calculateSumUsingDataLayer_oneValue() {
		when(dataService.retrieveData()).thenReturn(new int[]{3});
		assertEquals(businessImplUsingDataService.calculateSumUsingDataLayer(),3);
	}
}
