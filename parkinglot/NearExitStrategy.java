package parkinglot;

import java.util.List;
import java.util.Optional;

public class NearExitStrategy implements ParkingSpotStrategy {
    @Override
    public Optional<ParkingSpot> findAvailableParkingSpot(List<ParkingSpot> parkingSpots) {
        System.out.println("Finding parking Spot which are available and near entrance");


        // Replace with actual algo
        return parkingSpots.stream()
                .filter((ParkingSpot parkingSpot)->parkingSpot.isAvailable()==true)
                .findAny();


    }
}
