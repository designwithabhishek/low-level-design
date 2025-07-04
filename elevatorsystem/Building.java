package elevatorsystem;

import java.util.ArrayList;
import java.util.List;

public class Building {
    List<Floor> floors=new ArrayList<>();

    public void addFloor(Floor floor){
        floors.add(floor);
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
