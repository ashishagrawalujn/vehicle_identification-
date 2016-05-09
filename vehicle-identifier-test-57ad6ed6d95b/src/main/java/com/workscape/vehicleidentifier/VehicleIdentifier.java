package com.workscape.vehicleidentifier;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;

import com.workscape.model.Vehicle;
import com.workscape.model.Vehicles;
import com.workscape.model.Wheel;
import com.workscape.model.Wheels;

/**
 * Hello world!
 * 
 */
public class VehicleIdentifier {

	public static void main(String[] args) {

		List<Vehicle> veList = new ArrayList<Vehicle>();
		List<Wheel> wheelList = new ArrayList<Wheel>();
		Vehicle vehicle = new Vehicle("Big Wheel", "plastic", "Human", null);
		Wheel wheel1 = new Wheel("plastic", "front");
		Wheel wheel2 = new Wheel("plastic", " rear left");
		Wheel wheel3 = new Wheel("plastic", " rear right");
		wheelList.add(wheel1);
		wheelList.add(wheel2);
		wheelList.add(wheel3);
		vehicle.setWheels(new Wheels(wheelList));
		veList.add(vehicle);

		List<Wheel> wheelList1 = new ArrayList<Wheel>();
		Vehicle vehicle2 = new Vehicle("Bicycle", "metal", "Human", null);
		wheelList1.add(new Wheel("plastic", "front"));
		wheelList1.add(new Wheel("plastic", " rear"));
		vehicle2.setWheels(new Wheels(wheelList1));
		veList.add(vehicle2);

		List<Wheel> wheelList3 = new ArrayList<Wheel>();
		Vehicle vehicle3 = new Vehicle("Motorcycle", "metal", "Internal Combustion", null);
		wheelList3.add(new Wheel("metal", "front"));
		wheelList3.add(new Wheel("metal", " rear"));
		vehicle3.setWheels(new Wheels(wheelList3));
		veList.add(vehicle3);
		Vehicles vehiclesMaster= new Vehicles(veList);
		VehicleIdentifier.identifier(vehiclesMaster);


	}
	
	public static void identifier(Vehicles vehiclesMaster){
		try {
			File file = new File("src\\main\\resources\\vehicles.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Vehicles.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Vehicles vehicles = (Vehicles) jaxbUnmarshaller.unmarshal(file);
			Vehicles outVehicles= new Vehicles(new ArrayList<Vehicle>());
			for (Vehicle iVehicle : vehicles.getViList()) {

			
				for (Vehicle vehicle4 : vehiclesMaster.getViList()) {
					if (vehicle4.getFrame().equalsIgnoreCase(iVehicle.getFrame())
							&& vehicle4.getPowertrain().equalsIgnoreCase(iVehicle.getPowertrain())
							&& vehicle4.getWheels().getWheels().size() == iVehicle.getWheels().getWheels().size()) {

						if (iVehicle.getWheels().getWheels().get(0).getMaterial()
								.equalsIgnoreCase(iVehicle.getWheels().getWheels().get(0).getMaterial())) {
							iVehicle.setType(vehicle4.getType());
							outVehicles.getViList().add(iVehicle);
							break;
						}

					}
				}
			}
			
			
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			File file1 = new File("src\\main\\resources\\vehicles_output.xml");
			 jaxbMarshaller.marshal(outVehicles, file1);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
	
	
	public static String identifierTest(Vehicle iVehicle){
		
		List<Vehicle> veList = new ArrayList<Vehicle>();
		List<Wheel> wheelList = new ArrayList<Wheel>();
		Vehicle vehicle = new Vehicle("Big Wheel", "plastic", "Human", null);
		Wheel wheel1 = new Wheel("plastic", "front");
		Wheel wheel2 = new Wheel("plastic", " rear left");
		Wheel wheel3 = new Wheel("plastic", " rear right");
		wheelList.add(wheel1);
		wheelList.add(wheel2);
		wheelList.add(wheel3);
		vehicle.setWheels(new Wheels(wheelList));
		veList.add(vehicle);

		List<Wheel> wheelList1 = new ArrayList<Wheel>();
		Vehicle vehicle2 = new Vehicle("Bicycle", "metal", "Human", null);
		wheelList1.add(new Wheel("plastic", "front"));
		wheelList1.add(new Wheel("plastic", " rear"));
		vehicle2.setWheels(new Wheels(wheelList1));
		veList.add(vehicle2);

		List<Wheel> wheelList3 = new ArrayList<Wheel>();
		Vehicle vehicle3 = new Vehicle("Motorcycle", "metal", "Internal Combustion", null);
		wheelList3.add(new Wheel("metal", "front"));
		wheelList3.add(new Wheel("metal", " rear"));
		vehicle3.setWheels(new Wheels(wheelList3));
		veList.add(vehicle3);
		Vehicles vehiclesMaster= new Vehicles(veList);
		
		try {
			
			
				for (Vehicle vehicle4 : vehiclesMaster.getViList()) {
					if (vehicle4.getFrame().equalsIgnoreCase(iVehicle.getFrame())
							&& vehicle4.getPowertrain().equalsIgnoreCase(iVehicle.getPowertrain())
							&& vehicle4.getWheels().getWheels().size() == iVehicle.getWheels().getWheels().size()) {

						if (iVehicle.getWheels().getWheels().get(0).getMaterial()
								.equalsIgnoreCase(iVehicle.getWheels().getWheels().get(0).getMaterial())) {
							return vehicle4.getType();
							
						}

					}
				}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
