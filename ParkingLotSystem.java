package parkinglot;

import java.time.LocalDateTime;

public class ParkingLotSystem {

    public static void main(String[] args){



        try {

            ParkingSpotManagerFactory parkingSpotManagerFactory = new ParkingSpotManagerFactory();
            PaymentProcessorFactory paymentProcessorFactory=new PaymentProcessorFactory();
            parkingSpotManagerFactory.addParkingSpotManager(VehicleType.TWO_WHEELER,new TwoWheelerParkingSpotManager());
            parkingSpotManagerFactory.addParkingSpotManager(VehicleType.FOUR_WHEELER,new FourWheelerParkingSpotManager());
            ParkingSpotManager twoWheelerParkingSpotManager = parkingSpotManagerFactory.getParkingSpotManager(VehicleType.TWO_WHEELER);
            ParkingSpotManager fourWheelerParkingSpotManager = parkingSpotManagerFactory.getParkingSpotManager(VehicleType.FOUR_WHEELER);

            // Create Parking spots
            System.out.println("Adding Parking Spots ....");
            for (int i = 0; i < 10; i++) {
                twoWheelerParkingSpotManager.addParkingSpot(new ParkingSpot(i, true,10));
            }

            for (int i = 0; i < 10; i++) {
                fourWheelerParkingSpotManager.addParkingSpot(new ParkingSpot(i, true,20));
            }

            System.out.println("Parking Spots addition completed ....");

            // Create entry and Exit gates
            EntryGate entryGate = new EntryGate(parkingSpotManagerFactory);
            ExitGate exitGate=new ExitGate(parkingSpotManagerFactory,paymentProcessorFactory);

            // Create vehicle
            Vehicle vehicle1=new Vehicle(1,"Creta",VehicleType.FOUR_WHEELER);

            // find parking spot
            ParkingSpot parkingSpot=entryGate.findAndAssignAvailableParkingSpot(vehicle1);

            if(parkingSpot!=null) {
                // generate ticket
                Ticket ticket1 = entryGate.generateTicket(parkingSpot);

                // at exist give ticket suppose it takes 2 hrs

                ticket1.setEndTime(LocalDateTime.now().plusHours(2));
                double amount = exitGate.computeAmount(ticket1);

                // proceed with payment
                boolean status = exitGate.makePayment(amount, PaymentProcessorType.UPI);
                if (status)
                    exitGate.makeParkingSpotAvailable(ticket1);
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
