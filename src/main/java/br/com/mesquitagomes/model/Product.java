package main.java.br.com.mesquitagomes.model;

import java.io.Serializable;

public class Product extends AbstractModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String description;
	private Integer quantity = 0;
	private Double unitPrice = 0.0;

	public enum ProductPropertyChangeEnum {

		description(), quantity(), unitPrice(), totalPrice();

	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		String oldValue = this.description;
		this.description = description;
		firePropertyChange(ProductPropertyChangeEnum.description.name(), oldValue, this.description);
	}

	public Integer getQuantity() {

		return quantity;
	}

	public void setQuantity(Integer quantity) {

		double totalPriceOld = getTotalPrice();
		int oldValue = this.quantity;
		this.quantity = quantity;
		firePropertyChange(ProductPropertyChangeEnum.quantity.name(), oldValue, this.quantity);
		firePropertyChange(ProductPropertyChangeEnum.totalPrice.name(), totalPriceOld, getTotalPrice());
	}

	public Double getUnitPrice() {

		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {

		double totalPriceOld = getTotalPrice();
		double oldValue = this.unitPrice;
		this.unitPrice = unitPrice;
		firePropertyChange(ProductPropertyChangeEnum.unitPrice.name(), oldValue, this.unitPrice);
		firePropertyChange(ProductPropertyChangeEnum.totalPrice.name(), totalPriceOld, getTotalPrice());
	}

	public Double getTotalPrice() {

		return quantity * unitPrice;
	}

}
