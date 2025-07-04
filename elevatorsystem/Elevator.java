package elevatorsystem;

public class Elevator {

    int id;
    Direction direction;

    int currentFloor;

    ElevatorState elevatorState;

    InternalButton internalButton;

    Display display;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor=1;
        elevatorState=ElevatorState.ACTIVE;
        this.direction=Direction.UP;
        display=new Display(this.currentFloor,this.direction);

    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
        display.setDirection(direction);
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
        this.display.setFloorNumber(currentFloor);
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public void setElevatorState(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
    }

    public InternalButton getInternalButton() {
        return internalButton;
    }

    public void setInternalButton(InternalButton internalButton) {
        this.internalButton = internalButton;
    }

    public int getId() {
        return id;
    }
}
