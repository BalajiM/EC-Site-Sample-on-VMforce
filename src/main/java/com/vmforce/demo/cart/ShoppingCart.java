package com.vmforce.demo.cart;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ItemSet> itemList = new ArrayList<ItemSet>();

	public List<ItemSet> getItemList() {
		return this.itemList;
	}

	public boolean isEmpty() {
		return (itemList == null || itemList.isEmpty()) ? true : false;
	}

	public BigDecimal getTotal() {
		BigDecimal total = new BigDecimal(0);
		for (ItemSet item : itemList) {
			total = total.add(item.getTotal());
		}
		return total;
	}

	public void delete(String pid) {
		for (ItemSet cartItemSet : itemList) {
			Item item = cartItemSet.getItem();
			if (item.getItemId().equals(pid)) {
				itemList.remove(cartItemSet);
				return;
			}
		}
	}

	public void push(ItemSet pushedItemSet) {
		boolean itemExistInCart = false;

		Item pushedItem = pushedItemSet.getItem();
		String pushedItemId = pushedItem.getItemId();

		for (ItemSet cartItemSet : itemList) {
			Item cartItem = cartItemSet.getItem();
			String cartItemId = cartItem.getItemId();

			if (cartItemId.equals(pushedItemId)) {
				cartItemSet.addQuantity(pushedItemSet.getQuantity());
				itemExistInCart = true;
				break;
			}
		}

		if (!itemExistInCart) {
			itemList.add(pushedItemSet);
		}
	}

	public void clearAll() {
		itemList = new ArrayList<ItemSet>();
	}
}