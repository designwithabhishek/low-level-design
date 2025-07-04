package elevatorsystem;

public interface ElevatorMovementStrategy {
    void processRequest(Elevator elevator);
    void addRequest(int floor,Direction direction,Elevator elevator);

}
