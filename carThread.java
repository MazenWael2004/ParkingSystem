public class carThread extends Thread {
    private  int id;
    private double  arrivalTime;
    private double parkingDuration;// to define parking duration for each car 
    private int gateNumber;
    ParkingSemaphore gate;
    ParkingLotBuffer parkinglot;
    boolean isParked;
    boolean hasArrived;
    boolean isRunning;
    public int getGateNumber(){
        return gateNumber;
    }

    public carThread( int id,double arrival_time,double parking_duration,int gateNumber, ParkingLotBuffer parkingLot, ParkingSemaphore gateSemaphores[]) {
        this.id = id;
        this.arrivalTime = arrival_time;
        this.parkingDuration= parking_duration;
        this.parkinglot = parkingLot;
        this.gateNumber = gateNumber;
        this.gate = gateSemaphores[ gateNumber -1 ];
        isParked = false;
        hasArrived = false;
        isRunning = true;
    }

    @Override
    public void run(){
        while(isRunning){
            if(!hasArrived){
                try{
                    this.sleep((int)arrivalTime * 1000);
                    hasArrived = true;
                }
                catch(InterruptedException e){
                    e.getStackTrace();
                }
                
            }
            if(isParked){
                try{
                    this.sleep((int)parkingDuration * 1000);  
                    isParked = false;
                }
                catch(InterruptedException e){
                    e.getStackTrace();
                }
            }

        }
        
       
        

    }


    
}
