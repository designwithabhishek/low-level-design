package elevatorsystem;

import java.util.ArrayList;
import java.util.List;

public class InternalDispatcher {

    List<ElevatorController> elevatorControllers=new ArrayList<>();

    public InternalDispatcher(List<ElevatorController> elevatorControllers) {
        this.elevatorControllers = elevatorControllers;
    }

    public void submitInternalrequest(int floor, Elevator elevator){
        for(ElevatorController elevatorController:elevatorControllers) {
            if(elevatorController.getElevator()==elevator)
            {
                Direction direction;
                if(floor>elevator.getCurrentFloor()){
                    direction=Direction.UP;
                }else{
                    direction=Direction.DOWN;
                }
                elevatorController.submitRequest(floor, direction);
                break;
            }
        }
    }
}
