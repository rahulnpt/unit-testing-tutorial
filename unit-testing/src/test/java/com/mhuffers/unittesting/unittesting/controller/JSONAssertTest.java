package com.mhuffers.unittesting.unittesting.controller;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JSONAssertTest {
	
	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
	
	@Test
	public void jsonAssert_strictFalse() throws JSONException{
		String expected = "{\"id\":1,\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expected, actualResponse, false);
	}
	
	@Test
	public void jsonAssert_strictTrue() throws JSONException{
		String expected = "{\"id\":1,\"name\": \"Ball\",\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expected, actualResponse, true);
	}
	
	@Test
	public void jsonAssert_withoutEscapeCharacters() throws JSONException{
		String expected = "{id:1,name: Ball,price:10,quantity:100}";
		JSONAssert.assertEquals(expected, actualResponse, true);
	}
}
