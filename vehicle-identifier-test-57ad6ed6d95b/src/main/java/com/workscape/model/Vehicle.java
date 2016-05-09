package com.workscape.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehicle")
@XmlAccessorType (XmlAccessType.FIELD)
public class Vehicle {
	private String id;
	private String type;
	private String frame;
	private String powertrain;
	@XmlElement(name = "wheels")
	private Wheels wheels;
	
	
	public Vehicle() {
		super();
	}

	public Vehicle(String type, String frame, String powertrain, Wheels wheels) {
		super();
		this.type = type;
		this.frame = frame;
		this.powertrain = powertrain;
		this.wheels = wheels;
	}
	public String getId() {
		return id;
	}
	public void setId1(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getFrame() {
		return frame;
	}
	public void setFrame(String frame) {
		this.frame = frame;
	}
	
	public String getPowertrain() {
		return powertrain;
	}
	public void setPowertrain(String powertrain) {
		this.powertrain = powertrain;
	}
	

	public Wheels getWheels() {
		return wheels;
	}

	public void setWheels(Wheels wheels) {
		this.wheels = wheels;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", type=" + type + ", frame=" + frame + ", powertrain=" + powertrain + ", wheels="
				+ wheels + "]";
	}
	
	
	
}
