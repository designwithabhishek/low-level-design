package elevatorsystem;

import java.util.ArrayList;
import java.util.List;

public class ExternalDispatcher {

    List<ElevatorController> elevatorControllers=new ArrayList<>();

    public ExternalDispatcher(List<ElevatorController> elevatorControllers) {
        this.elevatorControllers = elevatorControllers;
    }

    public void submitExternalRequest(int floor, Direction direction){

        // odd-even strategy
        for(ElevatorController elevatorController: elevatorControllers){
            Elevator elevator=elevatorController.getElevator();
            int id=elevator.getId();
            if(floor%2==0&&id%2==0||(floor%2!=0&&id%2!=0)){
                // both even or both odd
                elevatorController.submitRequest(floor,direction);
            }
        }
    }
}
