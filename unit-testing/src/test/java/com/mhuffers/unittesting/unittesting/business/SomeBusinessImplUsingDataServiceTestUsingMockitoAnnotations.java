package com.mhuffers.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/*
 * when using @RunWith(MockitoJUnitRunner.class) we don't need to use @before as it will be automatically invoked by mockito.
 * If a JUnit class or its parent class is annotated with @RunWith, 
 * JUnit framework invokes the specified class as a test runner instead of running the default runner.
 * A Runner class is responsible to run JUnit test, typically by reflection.
 */
@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessImplUsingDataServiceTestUsingMockitoAnnotations {
	
	@InjectMocks
	private SomeBusinessImplUsingDataService businessImplUsingDataService;
	
	@Mock
	private SomeDataService dataService; 
	
	/*
	 * @Before will help setting the mock service before execution of every test case.
	 * Other option is to call the setter explicitly inside every method 
	 */
	/*@Before
	public void before() {
		businessImplUsingDataService.setSomeDataService(dataService);
	}*/
	
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
