package parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingSpotManagerFactory {

    Map<VehicleType,ParkingSpotManager> registry=new HashMap<>();
    ParkingSpotManager getParkingSpotManager(VehicleType vehicleType) throws Exception {

        if(registry.containsKey(vehicleType)){
            return registry.get(vehicleType);
        }else{
            throw new Exception("Invalid vehicle type");
        }

    }

    void addParkingSpotManager(VehicleType vehicleType,ParkingSpotManager parkingSpotManager){
        registry.put(vehicleType,parkingSpotManager);
    }
}
