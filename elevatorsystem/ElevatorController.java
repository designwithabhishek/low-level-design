package elevatorsystem;

public class ElevatorController {

    Elevator elevator;
    ElevatorMovementStrategy elevatorMovementStrategy;

    public Elevator getElevator() {
        return elevator;
    }

    public ElevatorController(Elevator elevator, ElevatorMovementStrategy elevatorMovementStrategy) {
        this.elevator = elevator;
        this.elevatorMovementStrategy = elevatorMovementStrategy;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }

    public void submitRequest(int floor, Direction direction){
        elevatorMovementStrategy.addRequest(floor,direction,elevator);
    }

    public void  startElevator(){
        elevatorMovementStrategy.processRequest(elevator);
    }

    public void stopElevator(){
        // stop and remove request if exist
    }


}
