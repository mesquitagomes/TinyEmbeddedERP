package main.java.br.com.mesquitagomes.model;

public class Order extends AbstractModel {

	public static final Integer OWNER_DEFAULT_ID = 1;

	private Person owner = new Person();
	private Person client = new Person();
	private Products products = new Products();

	public Person getOwner() {

		return owner;
	}

	public void setOwner(Person owner) {

		Person oldValue = this.owner;
		this.owner = owner;
		firePropertyChange("owner", oldValue, this.owner);
	}

	public Person getClient() {

		return client;
	}

	public void setClient(Person client) {

		Person oldValue = this.client;
		this.client = client;
		firePropertyChange("client", oldValue, this.client);
	}

	public Products getProducts() {

		return products;
	}

	public void setProducts(Products products) {

		Products oldValue = this.products;
		this.products = products;
		firePropertyChange("products", oldValue, this.products);
	}

	public String toString() {

		return "Owner: " + owner.getName() + "\nClient: " + client.getName() + "\nProducts Quantity: " + products.getProductsCount();
	}

}
