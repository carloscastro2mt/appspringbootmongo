package com.app.webmongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "cosmetics")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cosmetic {

	@Id
	private String reference;
	private String brand;
	private String category;
	private String name;
	private String description;
	private boolean availability = true;
	private double price;
	private int quantity;
	private String photography;

}