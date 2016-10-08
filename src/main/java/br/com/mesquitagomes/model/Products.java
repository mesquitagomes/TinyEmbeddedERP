package main.java.br.com.mesquitagomes.model;

import java.util.ArrayList;
import java.util.List;

public class Products extends AbstractModel {

	protected List<Product> products = new ArrayList<Product>();

	public enum ProductsPropertyChangeEnum {

		products();

	}

	public List<Product> getProducts() {

		return products;
	}

	public void setProducts(List<Product> products) {

		List<Product> oldValue = this.products;
		this.products = new ArrayList<Product>(products);
		firePropertyChange(ProductsPropertyChangeEnum.products.name(), oldValue, this.products);
	}

	public void addProduct(Product product) {

		List<Product> oldValue = products;
		products = new ArrayList<Product>(products);
		products.add(product);
		firePropertyChange(ProductsPropertyChangeEnum.products.name(), oldValue, products);
	}

	public void removeProduct(Product product) {

		double totalPriceOld = getTotalPrice();
		List<Product> oldValue = products;
		products = new ArrayList<Product>(products);
		products.remove(product);
		firePropertyChange(ProductsPropertyChangeEnum.products.name(), oldValue, products);
		firePropertyChange("totalPrice", totalPriceOld, getTotalPrice());
	}

	public Product getProduct(int index) {

		Product product = null;
		if (index >= 0 && index < products.size()) product = products.get(index);
		return product;
	}

	public int getProductsCount() {

		return products.size();
	}

	public Double getTotalPrice() {

		double totalPrice = 0;

		for (Product product : products)
			totalPrice += product.getTotalPrice();

		return totalPrice;
	}

}
