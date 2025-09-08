package com.afs.parkinglot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StandardParkingBoyMultipleLotsTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    //Case 1 - Given a standard parking boy managing two empty parking lots, When park a car, Then park to the first parking lot
    @Test
    public void should_park_to_first_parking_lot_when_both_are_empty() {
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = Arrays.asList(firstParkingLot, secondParkingLot);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car car = new Car("1");

        Ticket ticket = standardParkingBoy.park(car);

        assertNotNull(ticket);
        assertEquals(firstParkingLot, ticket.getParkingLot());
    }

    //Case 2 - Given a standard parking boy managing two parking lots with first lot full, When park a car, Then park to the second parking lot
    //Case 3 - Given a standard parking boy managing two parking lots with both lots full, When park a car, Then return nothing
    //Case 4 - Given a standard parking boy managing two parking lots with cars parked in both lots, When fetch cars with tickets, Then return the right car from the correct parking lot


}
