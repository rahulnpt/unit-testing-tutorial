package com.mhuffers.unittesting.unittesting.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Entity
public class Item {
	@Id
	private int id;
	private String name;
	private int price;
	private int quantity;
		
	public Item() {}
	
	public Item(int id, String name, int price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	@Setter
	@Transient
	private int value;
}
