package parkinglot;

import java.time.Duration;

public class MinutePriceStrategy implements PriceStrategy {
    @Override
    public double computePrice(Ticket ticket) {
        System.out.println("Computing amount for ticket using Minute price strategy");
        double baseAmount=ticket.getParkingSpot().getPrice();
        Duration duration = Duration.between(ticket.getStartTime(), ticket.getEndTime());
        long totalMinutes = duration.toMinutes();
        return  baseAmount*totalMinutes;
    }
}
