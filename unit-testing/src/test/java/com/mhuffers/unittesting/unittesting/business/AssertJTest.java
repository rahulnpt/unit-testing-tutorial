package com.mhuffers.unittesting.unittesting.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/*
 * this has advantage over hamcrest that we can avoid to many static imports
 * and make use of chaining
 */
public class AssertJTest {

	@Test
	public void assertsUsingAssertJ() {
		List<Integer> list = Arrays.asList(1,2,3,4);
		assertThat(list)
			.hasSize(4)
			.allMatch(x->x<5)
			.noneMatch(x->x>5);
		
		assertThat("ABCD")
			.contains("BC")
			.startsWith("ABC")
			.endsWith("CD");
	}

}
