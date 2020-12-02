package com.mhuffers.unittesting.unittesting.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {

	@Test
	public void jsonPathTest() {
		
		String response = "[\n" + 
				"{\"id\":1001,\"price\":100,\"quantity\":20,\"name\":pen},\n" + 
				"{\"id\":1002,\"price\":200,\"quantity\":30,\"name\":pencil},\n" + 
				"{\"id\":1003,\"price\":300,\"quantity\":40,\"name\":rubber},\n" + 
				"]";
		DocumentContext context = JsonPath.parse(response);
		
		int length = context.read("$.length()");
		
		assertThat(length).isEqualTo(3);
		
		List<Integer> ids = context.read("$..id");
		
		assertThat(ids).containsExactly(1001,1002,1003);
		
		//this will get the second json object inside that array
		System.out.println("$.[1]"+context.read("$.[1]").toString());
		
		//below will get the first two json object, last index is exclusive
		System.out.println("$.[0:2]"+context.read("$.[0:2]").toString());
		
		//this will get json object which has any attribute with the name:pen 
		System.out.println("$.[?(@.name=='pen')]"+context.read("$.[?(@.name=='pen')]").toString());
		
		//this will get the json object where quantity is 40
		System.out.println("$.[?(@.quantity==40)]"+context.read("$.[?(@.quantity==40)]").toString());
	}

}
