package com.mhuffers.unittesting.unittesting.business;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMatchersTest {

	@Test
	public void assertsUsingHamcrest() {
		List<Integer> list = Arrays.asList(1,2,3,4);
		
		assertThat(list,hasSize(4));
		assertThat(list,hasItems(3,1));
		assertThat(list,everyItem(greaterThan(0)));
		assertThat(list,everyItem(lessThan(5)));
		
		assertThat("",isEmptyString());
		assertThat("ABCD",containsString("BC"));
		assertThat("ABCD",startsWith("AB"));
	}

}
