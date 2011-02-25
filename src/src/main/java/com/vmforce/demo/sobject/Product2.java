package com.vmforce.demo.sobject;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.force.sdk.jpa.annotation.CustomObject;

@Entity
@CustomObject(enableFeeds = true)
public class Product2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String name;

	private String description;

	private boolean isActive;

	private String imgbig;

	private String imgsmall;

	private BigDecimal price;
	
	private String ecsettingid;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getImgbig() {
		return imgbig;
	}

	public void setImgbig(String imgbig) {
		this.imgbig = imgbig;
	}

	public String getImgsmall() {
		return imgsmall;
	}

	public void setImgsmall(String imgsmall) {
		this.imgsmall = imgsmall;
	}

	public void setEcsettingid(String ecsettingid) {
		this.ecsettingid = ecsettingid;
	}

	public String getEcsettingid() {
		return ecsettingid;
	}

}
