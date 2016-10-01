package main.java.br.com.mesquitagomes.model;

import java.util.ArrayList;
import java.util.List;

public class Products extends AbstractModel {

	protected List<Product> products = new ArrayList<Product>();

	public List<Product> getProducts() {

		return products;
	}

	public void setProducts(List<Product> products) {

		List<Product> oldValue = this.products;
		this.products = new ArrayList<Product>(products);
		firePropertyChange(getPropertyChangeName(), oldValue, this.products);
	}

	public int getProductsCount() {

		return products.size();
	}

	public void addProduct(Product product) {

		List<Product> oldValue = products;
		products = new ArrayList<Product>(products);
		products.add(product);
		firePropertyChange(getPropertyChangeName(), oldValue, products);
	}

	public void removeProduct(Product product) {

		List<Product> oldValue = products;
		products = new ArrayList<Product>(products);
		products.remove(product);
		firePropertyChange(getPropertyChangeName(), oldValue, products);
	}

	public String getPropertyChangeName() {

		return "products";
	}

	public Integer getTotalPrice() {

		int totalPrice = 0;

		for (Product product : products)
			totalPrice += product.getPrice();

		return totalPrice;
	}

}
