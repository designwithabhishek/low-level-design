package parkinglot;

import java.time.LocalDateTime;

public class ExitGate {
    ParkingSpotManager parkingSpotManager;
    ParkingSpotManagerFactory parkingSpotManagerFactory;


    public ExitGate(ParkingSpotManagerFactory parkingSpotManagerFactory, PaymentProcessorFactory paymentProcessorFactory) {
        this.parkingSpotManagerFactory = parkingSpotManagerFactory;
        this.paymentProcessorFactory = paymentProcessorFactory;
    }

    PaymentProcessorFactory paymentProcessorFactory;


    PaymentProcessor paymentProcessor;
    public double computeAmount(Ticket ticket) throws Exception {
            Vehicle vehicle = ticket.getVehicle();
            parkingSpotManager = parkingSpotManagerFactory.getParkingSpotManager(vehicle.getVehicleType());
            return parkingSpotManager.getPriceStrategy().computePrice(ticket);

    }

    public  void makeParkingSpotAvailable(Ticket ticket){
        ticket.getParkingSpot().setAvailable(true);
    }

    public boolean makePayment(double amount ,PaymentProcessorType paymentProcessorType) throws Exception {
        paymentProcessor=paymentProcessorFactory.getPaymentProcessor(paymentProcessorType);
        return paymentProcessor.processPayment(new Payment(amount, LocalDateTime.now()));
    }

}
