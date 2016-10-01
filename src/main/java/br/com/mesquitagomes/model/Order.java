package main.java.br.com.mesquitagomes.model;

public class Order {

	private Person owner;
	private Person client;
	private Products products;

	public Person getOwner() {

		return owner;
	}

	public void setOwner(Person owner) {

		this.owner = owner;
	}

	public Person getClient() {

		return client;
	}

	public void setClient(Person client) {

		this.client = client;
	}

	public Products getProducts() {

		return products;
	}

	public void setProducts(Products products) {

		this.products = products;
	}

}
