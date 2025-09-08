package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    //Case 1-Given a parking lot,and a car,When park the car,Then return a parking ticket.
    @Test
    public void should_return_a_parking_ticket_when_Given_a_parking_lot_and_a_car() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("1");
        Ticket ticket = new Ticket(car,1,parkingLot);
        Ticket ticketResult = parkingLot.park(car);
        assertEquals(ticket,ticketResult);
    }
    //Case 2-Given a parking lot with a parked car,and a parking ticket,When fetch the car,Then return the parked car.
    @Test
    public void should_return_the_parked_car_when_Given_a_parking_lot_with_a_car_and_a_parking_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("1");

        Ticket ticketResult = parkingLot.park(car);
        Car car2 =parkingLot.fetch(ticketResult);
        assertEquals(car,car2);
    }


}
