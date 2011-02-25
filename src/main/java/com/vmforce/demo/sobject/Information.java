package com.vmforce.demo.sobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.force.sdk.jpa.annotation.CustomObject;

@Entity
@CustomObject(enableFeeds = true)
public class Information {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String name;
	
	private String description;
	
	private String ecsettingid;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setDescription(String description) {
		this.description=description;
	}

	public String getDescription() {
		return description;
	}

	public void setEcsettingid(String ecsettingid) {
		this.ecsettingid = ecsettingid;
	}

	public String getEcsettingid() {
		return ecsettingid;
	}	

}
