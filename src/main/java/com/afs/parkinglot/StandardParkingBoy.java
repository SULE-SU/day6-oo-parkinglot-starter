package com.afs.parkinglot;

import java.util.List;

public class StandardParkingBoy {

    private List<ParkingLot> parkingLots;

    public StandardParkingBoy(ParkingLot parkingLot) {
        this(List.of(parkingLot));
    }

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        return parkingLots.stream()
                .map(parkingLot -> parkingLot.park(car))
                .filter(ticket -> ticket != null)
                .findFirst()
                .orElse(null);
    }


    public Car fetch(Ticket ticket) {
        return parkingLots.stream()
                .map(parkingLot -> parkingLot.fetch(ticket))
                .filter(car -> car != null)
                .findFirst()
                .orElse(null);
    }
}
