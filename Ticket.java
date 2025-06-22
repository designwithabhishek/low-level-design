package parkinglot;

import java.time.LocalDateTime;

public class Ticket {

    ParkingSpot parkingSpot;

    Vehicle vehicle;

    LocalDateTime startTime;
    LocalDateTime endTime;

    public Ticket(ParkingSpot parkingSpot, Vehicle vehicle, LocalDateTime startTime) {
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}
