public class carThread extends Thread {
    private  int id;
    private double  arrival_time;
    private double parking_duration;// to define parking duration for each car 
    private String gate_name; // define gate name 1 or  2 or 3

    public carThread( int id,double arrival_time,double parking_duration,String gate_name) {
        this.id = id;
        this.arrival_time = arrival_time;
        this.parking_duration= parking_duration;
        this.gate_name = gate_name;
    }

    @Override
    public void run(){
        
    }


    
}
