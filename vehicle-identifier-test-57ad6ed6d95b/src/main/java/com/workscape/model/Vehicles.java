package com.workscape.model;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="vehicles")
@XmlAccessorType (XmlAccessType.FIELD)
public class Vehicles {
@XmlElement(name = "vehicle")
private List<Vehicle> Vehicles;

public Vehicles() {
	super();
}

public Vehicles(List<Vehicle> Vehicles) {
	super();
	this.Vehicles = Vehicles;
}

public List<Vehicle> getViList() {
	return Vehicles;
}

public void setViList(List<Vehicle> Vehicles) {
	this.Vehicles = Vehicles;
}

}
