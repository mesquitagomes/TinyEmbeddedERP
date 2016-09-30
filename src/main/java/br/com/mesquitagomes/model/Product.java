package main.java.br.com.mesquitagomes.model;

import java.io.Serializable;

public class Product extends AbstractModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String description;
	private Integer quantity;
	private Float price;

	public enum ProductColumns {

		DESCRIPTION("description"), QUANTITY("quantity"), PRICE("price");

		private String name;

		ProductColumns(String name) {
			this.name = name;
		}

		public String getName() {

			return name;
		}
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		String oldValue = this.description;
		this.description = description;
		firePropertyChange(ProductColumns.DESCRIPTION.getName(), oldValue, this.description);
	}

	public Integer getQuantity() {

		return quantity;
	}

	public void setQuantity(Integer quantity) {

		Integer oldValue = this.quantity;
		this.quantity = quantity;
		firePropertyChange(ProductColumns.QUANTITY.getName(), oldValue, this.quantity);
	}

	public Float getPrice() {

		return price;
	}

	public void setPrice(Float price) {

		Float oldValue = this.price;
		this.price = price;
		firePropertyChange(ProductColumns.PRICE.getName(), oldValue, this.price);
	}

}
