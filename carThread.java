public class carThread extends Thread {
    private EnterParkingSpotSemaphore enteringParkingSpot;
    private  int id;
    private int  arrival_time;
    private int parking_duration;// to define parking duration for each car 
    private String gate_name; // define gate name 1 or  2 or 3

    public carThread( EnterParkingSpotSemaphore p, int id,int arrival_time,int parking_duration,String gate_name) {
        this.enteringParkingSpot = p;
        this.arrival_time = arrival_time;
        this.id = id;
        this.parking_duration= parking_duration;
        this.gate_name = gate_name;
    }

    @Override
    public void run(){
        
    }


    
}
