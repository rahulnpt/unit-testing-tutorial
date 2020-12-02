package com.mhuffers.unittesting.unittesting.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhuffers.unittesting.unittesting.model.Item;
import com.mhuffers.unittesting.unittesting.repository.ItemRepository;

@Service
public class ItemBusinessService {

	@Autowired
	private ItemRepository itemRepo;

	public Item getHardCodedResponse() {
		return new Item(1, "Ball", 10, 100);
	}

	public List<Item> retrieveAll() {
		List<Item> itemList = itemRepo.findAll();

		return itemList.stream().map(item -> {
			item.setValue(item.getPrice() * item.getQuantity());
			return item;
		}).collect(Collectors.toList());
	}

}
