package com.workscape.vehicleidentifier;


import static junit.framework.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.workscape.model.Vehicle;
import com.workscape.model.Wheel;
import com.workscape.model.Wheels;

import static org.junit.Assert.*;


/**
 * Unit test for simple App.
 */
public class VehicleIdentifierTest {

	
	
	@Test
    public void testBigWheel() {
		List<Wheel> wheelList = new ArrayList<Wheel>();
		Vehicle vehicle = new Vehicle("", "plastic", "Human", null);
		Wheel wheel1 = new Wheel("plastic", "front");
		Wheel wheel2 = new Wheel("plastic", " rear left");
		Wheel wheel3 = new Wheel("plastic", " rear right");
		wheelList.add(wheel1);
		wheelList.add(wheel2);
		wheelList.add(wheel3);
		vehicle.setWheels(new Wheels(wheelList));
        String result = VehicleIdentifier.identifierTest(vehicle);
        assertEquals("Big Wheel", result);

    }
	@Test
    public void testBicycle() {
		List<Wheel> wheelList1 = new ArrayList<Wheel>();
		Vehicle vehicle = new Vehicle("", "metal", "Human", null);
		wheelList1.add(new Wheel("plastic", "front"));
		wheelList1.add(new Wheel("plastic", " rear"));
		vehicle.setWheels(new Wheels(wheelList1));
        String result = VehicleIdentifier.identifierTest(vehicle);
        assertEquals("Bicycle", result);

    }
	@Test
    public void testNull() {
		List<Wheel> wheelList1 = new ArrayList<Wheel>();
		Vehicle vehicle = new Vehicle("", "metal1", "Human", null);
		wheelList1.add(new Wheel("plastic", "front"));
		wheelList1.add(new Wheel("plastic", " rear"));
		vehicle.setWheels(new Wheels(wheelList1));
        String result = VehicleIdentifier.identifierTest(vehicle);
        assertNull(result);

    }
}
