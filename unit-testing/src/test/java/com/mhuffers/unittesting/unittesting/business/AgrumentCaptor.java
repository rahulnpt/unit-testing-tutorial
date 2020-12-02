package com.mhuffers.unittesting.unittesting.business;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.atMost;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
/*
 * ArgumentCaptor is used to capture the argument passed to any method so that we can ensure that the passed argument is same
 * as expected
 */
@RunWith(MockitoJUnitRunner.class)
public class AgrumentCaptor {

	@Mock
	List<String> mockList;
	
	@Test
	public void singleArgumentCapture() {
		
		//SUT(System under test)
		mockList.add("someString");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mockList).add(captor.capture());
		
		assertEquals("someString", captor.getValue());
	}

	@Test
	public void multipleArgumentCapture() {
		
		//SUT(System under test)
		mockList.add("someString1");
		mockList.add("someString2");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		
		//by default verify would check that the given method was called only once, otherwise it would fail. So we need to specify how
		//many times the method would have got called
		
		//this will fail as add is called two times
		//verify(mockList).add(captor.capture());
		
		verify(mockList,times(2)).add(captor.capture());
		
		List<String> values = captor.getAllValues();
		assertEquals("someString1", values.get(0));
		assertEquals("someString2", values.get(1));
	}
}
