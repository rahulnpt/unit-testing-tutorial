package com.mhuffers.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.mhuffers.unittesting.unittesting.model.Item;
import com.mhuffers.unittesting.unittesting.repository.ItemRepository;
import com.mhuffers.unittesting.unittesting.service.ItemBusinessService;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

	@InjectMocks
	private ItemBusinessService businessService;
	
	@Mock
	private ItemRepository itemRepository;
	
	@Test
	public void retrieveAll_test() {
		when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item(1, "Ball2", 10, 100),new Item(2, "Ball3", 100, 1020)));
		
		List<Item> items = businessService.retrieveAll();
		
		assertEquals(1000, items.get(0).getValue());
		assertEquals(102000, items.get(1).getValue());
	}
}
