package com.afs.parkinglot;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ParkingLot {
    private Integer capacity;
    private static final Integer CAPACITY = 10;
    private Map<Ticket, Car> ticketCars = new HashMap<>();

    public ParkingLot() {
        this.capacity = CAPACITY;
    }

    public ParkingLot(Integer capacity) {
        this.capacity = capacity;
    }

}
