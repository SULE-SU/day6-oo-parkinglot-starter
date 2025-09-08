package com.afs.parkinglot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class StandardParkingBoyTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    //Case 1-Given a standard parking boy,and a car,When park the car,Then return a parking ticket.
    @Test
    public void should_return_a_parking_ticket_when_Given_a_standard_parking_boy_and_a_car() {
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car("1");
        
        Ticket ticketResult = standardParkingBoy.park(car);
        assertNotNull(ticketResult);
    }

    //Case 2-Given a standard parking boy with a parked car,and a parking ticket,When fetch the car,Then return the parked car.
    @Test
    public void should_return_the_parked_car_when_Given_a_standard_parking_boy_with_a_car_and_a_parking_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car("1");

        Ticket ticketResult = standardParkingBoy.park(car);
        Car car2 = standardParkingBoy.fetch(ticketResult);
        assertEquals(car, car2);
    }
}
