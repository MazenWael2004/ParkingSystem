public class Gate {
    private int gate_id;

    public void handleArrivalOfCar(carThread c) {
        c.start();
        
    }
    
}
