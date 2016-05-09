package com.workscape.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="wheel")
@XmlAccessorType (XmlAccessType.FIELD)
public class Wheel {
private String material;
private String position;

public Wheel() {
	super();
}
public Wheel(String material, String position) {
	super();
	this.material = material;
	
	this.position = position;
}
public String getMaterial() {
	return material;
}
public void setMaterial(String material) {
	this.material = material;
}
public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}
@Override
public String toString() {
	return "Wheel [Matmaterial=" + material + ", position=" + position + "]";
}

}
