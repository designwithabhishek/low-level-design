package parkinglot;

import java.util.List;

public class TwoWheelerParkingSpotManager extends ParkingSpotManager {


    public TwoWheelerParkingSpotManager() {
        super(new NearEntranceStrategy(),new HourlyPriceStrategy());
    }

}
