package parkinglot;

public class Vehicle {
    private int vehicleNo;

    private String name;

    private VehicleType vehicleType;

    public Vehicle(int vehicleNo, String name, VehicleType vehicleType) {
        this.vehicleNo = vehicleNo;
        this.name = name;
        this.vehicleType = vehicleType;
    }

    public int getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(int vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
