package main.java.br.com.mesquitagomes.model;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	private String description;
	private Integer quantity;
	private Float price;

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public Integer getQuantity() {

		return quantity;
	}

	public void setQuantity(Integer quantity) {

		this.quantity = quantity;
	}

	public Float getPrice() {

		return price;
	}

	public void setPrice(Float price) {

		this.price = price;
	}

}
