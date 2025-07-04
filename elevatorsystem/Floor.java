package elevatorsystem;

import java.util.List;

public class Floor {

    private int floorNumber;

    private ExternalDispatcher externalDispatcher;

    public Floor(int floorNumber,ExternalDispatcher externalDispatcher) {
        this.floorNumber = floorNumber;
        this.externalDispatcher = externalDispatcher;
    }

    public void pressButton(Direction direction) {
        externalDispatcher.submitExternalRequest(this.floorNumber,direction);
    }
}
