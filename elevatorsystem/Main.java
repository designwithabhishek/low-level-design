package elevatorsystem;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        try{

            // create elevator
            Elevator elevator1=new Elevator(1);
            Elevator elevator2=new Elevator(2);

            // create controller for each elevator
            ElevatorController elevatorController1=new ElevatorController(elevator1,new ScanElevatorMovementStrategy());
            ElevatorController elevatorController2=new ElevatorController(elevator2,new ScanElevatorMovementStrategy());

            List<ElevatorController> elevatorControllers=new ArrayList<>();
            elevatorControllers.add(elevatorController1);
            elevatorControllers.add(elevatorController2);

            // Create external and internal dispatcher
            ExternalDispatcher externalDispatcher=new ExternalDispatcher(elevatorControllers);
            InternalDispatcher internalDispatcher=new InternalDispatcher(elevatorControllers);

            // Internal Button for each elevator
            InternalButton internalButton=new InternalButton(internalDispatcher);
            InternalButton internalButton2=new InternalButton(internalDispatcher);

            elevator1.setInternalButton(internalButton);
            elevator2.setInternalButton(internalButton2);

            // Create building
            Building building=new Building();

            // Add floors in building
            for(int i=1;i<10;i++){
                Floor floor=new Floor(i,externalDispatcher);
                building.addFloor(floor);
            }

            List<Floor> floors=building.getFloors();
            Floor thirdFloor=floors.get(3); // 4
            Floor fifthfloor=floors.get(4); // 5
            Floor seventhFloor=floors.get(6); // 7
            Floor secondFloor=floors.get(1); // 2
            Floor ninthFloor=floors.get(8); // 9

            // Simulate requests on different floors
            thirdFloor.pressButton(Direction.UP);
            fifthfloor.pressButton(Direction.DOWN);
            seventhFloor.pressButton(Direction.UP);
            secondFloor.pressButton(Direction.UP);
            ninthFloor.pressButton(Direction.DOWN);
            internalButton.pressButton(8,elevator1);

            // start elevators
            elevatorController1.startElevator();
            elevatorController2.startElevator();


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
