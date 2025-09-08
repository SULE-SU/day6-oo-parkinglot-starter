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
    @Test
    public void should_park_to_second_parking_lot_when_first_is_full() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = Arrays.asList(firstParkingLot, secondParkingLot);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);

        Car car1 = new Car("1");
        Car car2 = new Car("2");


        Ticket ticket1 = standardParkingBoy.park(car1);
        Ticket ticket2 = standardParkingBoy.park(car2);

        assertNotNull(ticket1);
        assertNotNull(ticket2);
        assertEquals(firstParkingLot, ticket1.getParkingLot());
        assertEquals(secondParkingLot, ticket2.getParkingLot());
    }
    //Case 3 - Given a standard parking boy managing two parking lots with both lots full, When park a car, Then return nothing
    @Test
    public void should_return_nothing_when_all_parking_lots_are_full() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = Arrays.asList(firstParkingLot, secondParkingLot);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);

        Car car1 = new Car("1");
        Car car2 = new Car("2");
        Car car3 = new Car("3");

        Ticket ticket1 = standardParkingBoy.park(car1);
        Ticket ticket2 = standardParkingBoy.park(car2);
        Ticket ticket3 = standardParkingBoy.park(car3);

        assertNotNull(ticket1);
        assertNotNull(ticket2);
        assertNull(ticket3);
    }



}
