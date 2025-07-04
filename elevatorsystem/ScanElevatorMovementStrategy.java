package elevatorsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class ScanElevatorMovementStrategy implements ElevatorMovementStrategy {

    PriorityQueue<Integer> up = new PriorityQueue<>();
    PriorityQueue<Integer> down = new PriorityQueue<>();

    List<Integer> pendingUp = new ArrayList<>();
    List<Integer> pendingDown = new ArrayList<>();

    @Override
    public void processRequest(Elevator elevator) {
        while (!up.isEmpty() || !down.isEmpty()) {
            if (elevator.getDirection() == Direction.UP) {
                if (up.isEmpty()) {
                    // change direction of elevator
                    elevator.setDirection(Direction.DOWN);
                    up.addAll(pendingUp);
                } else {
                    int floor = up.poll();
                    Display display = elevator.getDisplay();
                    elevator.setCurrentFloor(floor);
                    display.show(elevator.getId());
                }
            } else {
                if (down.isEmpty()) {
                    // change direction of elevator
                    elevator.setDirection(Direction.UP);
                    down.addAll(pendingDown);
                } else {
                    int floor = down.poll();
                    Display display = elevator.getDisplay();
                    elevator.setCurrentFloor(floor);
                    display.show(elevator.getId());
                }
            }
        }
    }

    @Override
    public void addRequest(int floor, Direction direction, Elevator elevator) {
        if (elevator.getDirection() != direction) {
            if (direction == Direction.UP) {
                up.add(floor);
            } else {
                down.add(floor);
            }
        } else {
            if (direction == Direction.UP) {
                if (elevator.currentFloor > floor)
                    pendingUp.add(floor);
                else {
                    up.add(floor);
                }
            }else {
                if (elevator.currentFloor > floor)
                    pendingDown.add(floor);
                else {
                    down.add(floor);
                }
            }
        }
    }

}
