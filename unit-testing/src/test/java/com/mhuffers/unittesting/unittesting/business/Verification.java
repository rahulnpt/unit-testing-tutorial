package com.mhuffers.unittesting.unittesting.business;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.atMost;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.junit.MockitoJUnitRunner;
/*
 * some times when the return type of the method is void 
 * and we want to verify that the some external api call happened or not
 * then we can make use of verify method. We can also verify the result it returned is as expected or not
 */
@RunWith(MockitoJUnitRunner.class)
public class Verification {

	@Mock
	List<String> mockList;
	
	@Test
	public void test() {
		
		//SUT(System under test)
		mockList.get(0);
		mockList.get(2);
		
		//verifying whether get of 0 was called or not
		verify(mockList).get(0);
		verify(mockList,times(1)).get(0);//verifying that the get(0) was called only once.
		verify(mockList,never()).get(3);
		verify(mockList,atMost(2)).get(anyInt());
	}

}
