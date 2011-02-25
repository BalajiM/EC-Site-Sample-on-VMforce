package com.vmforce.demo.cart;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemSet implements Serializable {

	private static final long serialVersionUID = 1L;

	private Item item;

	private Integer quantity;

	public ItemSet(Item item, Integer quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	public void addQuantity(Integer addQuantity) {
		int addQuantityInt = addQuantity.intValue();
		int existQuantityInt = getQuantity().intValue();
		setQuantity(new Integer(addQuantityInt + existQuantityInt));
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotal() {
		return item.getPrice().multiply(BigDecimal.valueOf(quantity.doubleValue()));
	}
}