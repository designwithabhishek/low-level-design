package elevatorsystem;

public class InternalButton {
    InternalDispatcher internalDispatcher;


    public InternalButton(InternalDispatcher internalDispatcher) {
        this.internalDispatcher = internalDispatcher;
    }

    public void pressButton(int floor, Elevator elevator){
        internalDispatcher.submitInternalrequest(floor,elevator);
    }
}
