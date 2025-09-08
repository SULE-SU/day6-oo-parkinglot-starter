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
    //Case 3-Given a parking lot with two parked cars,and two parking tickets,When fetch the car twice,Then return the right car with each ticket
    @Test
    public void should_return_the_right_car_with_each_ticket_when_Given_a_parking_lot_with_two_car_and_two_parking_tickets() {
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car("1");
        Car car2 = new Car("2");
        Ticket ticketResult1 = parkingLot.park(car1);
        Ticket ticketResult2 = parkingLot.park(car2);

        Car car1Result = parkingLot.fetch(ticketResult1);
        Car car2Result = parkingLot.fetch(ticketResult2);
        assertEquals(car1,car1Result);
        assertEquals(car2,car2Result);
    }

}
