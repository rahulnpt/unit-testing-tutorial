package com.mhuffers.unittesting.unittesting.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mhuffers.unittesting.unittesting.model.Item;
import com.mhuffers.unittesting.unittesting.service.ItemBusinessService;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	//@MockBean would register the below component with the Application Context
	@MockBean
	private ItemBusinessService itemService;
	
	@Test
	public void getDummyItemTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);
		
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				//using .string function for content comparison would expect the response to be exactly same which is not good for JSON 
				//comparison, therefore we are using .json. Using .json function would compare only those fields which are currently present in the
				//expected response 
				.andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
				.andReturn();
	}
	
	@Test
	public void getHardcodedResponse_test() throws Exception {
		when(itemService.getHardCodedResponse()).thenReturn(new Item(1, "Ball2", 10, 100));
		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item-from-service").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\": 1,\"name\":\"Ball2\",\"price\":10,\"quantity\":100}"))
				.andReturn();
	}
	
	@Test
	public void getAllItemsResponse_test() throws Exception {
		when(itemService.retrieveAll()).thenReturn(Arrays.asList(new Item(1, "Ball2", 10, 100),new Item(2, "Ball3", 120, 1020)));
		RequestBuilder request = MockMvcRequestBuilders.get("/all-items").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id: 1,name:Ball2,price:10,quantity:100},{id: 2,name:Ball3,price:120,quantity:1020}]"))
				.andReturn();
	}
	
}
