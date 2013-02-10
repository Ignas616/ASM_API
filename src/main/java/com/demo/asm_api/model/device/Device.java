package com.demo.asm_api.model.device;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "device")
@SequenceGenerator(name = "device_seq", sequenceName = "device_seq", allocationSize = 1)
public class Device implements Serializable{
	
	private static final long serialVersionUID = -7520724946566388839L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="device_seq")
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;

    @OneToOne
    @JoinColumn(name = "device_type")
    private DeviceType deviceType;

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

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}


}
