package parkinglot;

import java.util.List;

public class FourWheelerParkingSpotManager extends  ParkingSpotManager{
    public FourWheelerParkingSpotManager() {
        super(new NearExitStrategy(),new MinutePriceStrategy());
    }
}
