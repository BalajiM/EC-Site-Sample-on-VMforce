package com.vmforce.demo.sobject;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.force.sdk.jpa.annotation.CustomObject;

@Entity
@CustomObject(enableFeeds = true)
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private BigDecimal price;

	private BigDecimal total;
	
	private Integer qty;
	
	@ManyToOne
	private Order order;
	
	@ManyToOne
	private Product2 product2;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Integer getQty() {
		return qty;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}

	public void setProduct2(Product2 product2) {
		this.product2 = product2;
	}

	public Product2 getProduct2() {
		return product2;
	}

}
