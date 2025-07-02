package parkinglot;

import java.util.List;
import java.util.Optional;

public interface ParkingSpotStrategy {

    Optional<ParkingSpot> findAvailableParkingSpot(List<ParkingSpot> parkingSpots);
}
