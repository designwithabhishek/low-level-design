package parkinglot;

public class ParkingSpot {

    private int number;
    private boolean isAvailable;

    Vehicle vehicle;
    private double price;

    public ParkingSpot(int number, boolean isAvailable,double price) {
        this.number = number;
        this.isAvailable = isAvailable;
        this.price=price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
