package main.java.br.com.mesquitagomes.model;

public class Order extends AbstractModel {

	public static final Integer OWNER_DEFAULT_ID = 1;

	private Person owner = new Person();
	private Person client = new Person();
	private Products products = new Products();

	public enum OrderPropertyChangeEnum {

		owner(), client(), products();

	}

	public Person getOwner() {

		return owner;
	}

	public void setOwner(Person owner) {

		Person oldValue = this.owner;
		this.owner = owner;
		firePropertyChange(OrderPropertyChangeEnum.owner.name(), oldValue, this.owner);
	}

	public Person getClient() {

		return client;
	}

	public void setClient(Person client) {

		Person oldValue = this.client;
		this.client = client;
		firePropertyChange(OrderPropertyChangeEnum.client.name(), oldValue, this.client);
	}

	public Products getProducts() {

		return products;
	}

	public void setProducts(Products products) {

		Products oldValue = this.products;
		this.products = products;
		firePropertyChange(OrderPropertyChangeEnum.products.name(), oldValue, this.products);
	}

	public String toString() {

		return "Owner: " + owner.getName() + "\nClient: " + client.getName() + "\nProducts Quantity: " + products.getProductsCount();
	}

}
