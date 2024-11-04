public class Gate {
    private int gate_id;

    public Gate(int gate_id){
        this.gate_id=gate_id;
    }

    public void handleArrivalOfCar(carThread c) {
        c.start();
        
    }
    
}
