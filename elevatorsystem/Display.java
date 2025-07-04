package elevatorsystem;

public class Display {
    private int currentFloor;

    private Direction direction;

    public Display(int floorNumber, Direction direction) {
        this.currentFloor = floorNumber;
        this.direction = direction;
    }

    public int getFloorNumber() {
        return currentFloor;
    }

    public void setFloorNumber(int floorNumber) {
        this.currentFloor = floorNumber;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void show(int elevatorId){
        System.out.println("Elevator with id: "+elevatorId+" moving at floor:"+currentFloor+"and in direction"+this.direction);
    }
}
