package com.mhuffers.unittesting.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhuffers.unittesting.unittesting.model.Item;
import com.mhuffers.unittesting.unittesting.service.ItemBusinessService;

@RestController
public class ItemController {

	@Autowired 
	private ItemBusinessService itemService;
	
	@GetMapping("/dummy-item")
	public Item getDummyItem() {
		return new Item(1,"Ball",10,100);
	}
	
	@GetMapping("/dummy-item-from-service")
	public Item getHardcodedResponse() {
		return itemService.getHardCodedResponse();
	}
	
	@GetMapping("/all-items")
	public List<Item> getAllItemsResponse() {
		return itemService.retrieveAll();
	}
}
