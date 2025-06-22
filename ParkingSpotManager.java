package parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class ParkingSpotManager {
    List<ParkingSpot> parkingSpots = new ArrayList<>();

    ParkingSpotStrategy parkingSpotStrategy;

    PriceStrategy priceStrategy;

    public ParkingSpotManager(List<ParkingSpot> parkingSpots, ParkingSpotStrategy parkingSpotStrategy) {
        this.parkingSpots = parkingSpots;
        this.parkingSpotStrategy = parkingSpotStrategy;
    }



    public ParkingSpotManager(ParkingSpotStrategy parkingSpotStrategy, PriceStrategy priceStrategy) {
        this.parkingSpotStrategy = parkingSpotStrategy;
        this.priceStrategy=priceStrategy;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public ParkingSpotStrategy getParkingSpotStrategy() {
        return parkingSpotStrategy;
    }

    public void setParkingSpotStrategy(ParkingSpotStrategy parkingSpotStrategy) {
        this.parkingSpotStrategy = parkingSpotStrategy;
    }

    public PriceStrategy getPriceStrategy() {
        return priceStrategy;
    }

    public void setPriceStrategy(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public ParkingSpot findParkingSpot() {
        Optional<ParkingSpot> parkingSpot = parkingSpotStrategy.findAvailableParkingSpot(parkingSpots);
        return parkingSpot.orElse(null);
    }

    public boolean assignSpotToVehicle(ParkingSpot parkingSpot,Vehicle vehicle){
        parkingSpot.setVehicle(vehicle);
        parkingSpot.setAvailable(false);
        return true;
    }


    public void addParkingSpot(ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
    }

    public void removeParkingSpot(int parkingSpotNumber) {
        List<ParkingSpot> newParkingSpots = parkingSpots.stream().
                filter((ParkingSpot parkingSpot) -> parkingSpot.getNumber() != parkingSpotNumber)
                .toList();
        setParkingSpots(newParkingSpots);
    }

    public  void updateParkingSpot(ParkingSpot updatedParkingSpot) {
        // need to implement

    }


}
