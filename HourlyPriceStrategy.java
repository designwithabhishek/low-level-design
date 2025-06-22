package parkinglot;

import java.time.Duration;

public class HourlyPriceStrategy implements PriceStrategy {
    @Override
    public double computePrice(Ticket ticket) {
        System.out.println("Computing amount for ticket using hourly strategy");
        double baseAmount=ticket.getParkingSpot().getPrice();
        Duration duration = Duration.between(ticket.getStartTime(), ticket.getEndTime());
        long numberOfHours=duration.toHours();
        return  baseAmount*numberOfHours;
    }
}
