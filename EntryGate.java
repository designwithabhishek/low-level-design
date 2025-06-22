package parkinglot;

import java.time.LocalDateTime;
import java.util.Optional;

public class EntryGate {
    ParkingSpotManager parkingSpotManager;
    ParkingSpotManagerFactory parkingSpotManagerFactory;

    public EntryGate(ParkingSpotManagerFactory parkingSpotManagerFactory) {
        this.parkingSpotManagerFactory = parkingSpotManagerFactory;
    }

    public ParkingSpot findAndAssignAvailableParkingSpot(Vehicle vehicle) throws Exception {

            ParkingSpotManager parkingSpotManager=parkingSpotManagerFactory.getParkingSpotManager(vehicle.getVehicleType());
            ParkingSpot parkingSpot=parkingSpotManager.findParkingSpot();

            if(parkingSpot==null){
                System.out.println("Parking Spot not available");
                return null;
            }
            System.out.println("Parking Spot Found: "+parkingSpot.getNumber());
            parkingSpotManager.assignSpotToVehicle(parkingSpot,vehicle);
            return parkingSpot;

    }
    public Ticket  generateTicket(ParkingSpot parkingSpot){
        System.out.println("New Ticket generated ");
        return  new Ticket(parkingSpot,parkingSpot.getVehicle(), LocalDateTime.now());
    }
}
