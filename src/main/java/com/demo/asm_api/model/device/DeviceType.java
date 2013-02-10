package com.demo.asm_api.model.device;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "device_type")
@SequenceGenerator(name = "device_type_seq", sequenceName = "device_type_seq", allocationSize = 1)
public class DeviceType implements Serializable{
	
	private static final long serialVersionUID = -7520724946566388873L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="device_type_seq")
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "no_of_shelves")
	private int noOfShelves;	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfShelves() {
		return noOfShelves;
	}

	public void setNoOfShelves(int noOfShelves) {
		this.noOfShelves = noOfShelves;
	}

}
