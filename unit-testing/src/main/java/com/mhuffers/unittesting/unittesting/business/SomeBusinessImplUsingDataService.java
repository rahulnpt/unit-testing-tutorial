package com.mhuffers.unittesting.unittesting.business;

import java.util.Arrays;
import lombok.Setter;

@Setter
public class SomeBusinessImplUsingDataService {
	
	private SomeDataService someDataService;
	
	public int calculateSumUsingDataLayer() {
		int a[] = someDataService.retrieveData();
		return Arrays.stream(a).sum();
	}
}
