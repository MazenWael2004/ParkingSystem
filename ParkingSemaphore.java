import java.util.LinkedList;
import java.util.Queue;

public class ParkingSemaphore { // Because the shared resource between car threads is the parking spot.
    private int AvailableSpots;
    Queue<Thread> carQueue = new LinkedList<>();

    public ParkingSemaphore(int spots){
        this.AvailableSpots = spots;
    }

    public  synchronized void AcquireSpot(){ // Synchronized because we cannot have more than one car take one spot at the same timemee.
        AvailableSpots--; // spots_available decreased by 1.
        if(AvailableSpots < 0){
            try {
                //so as to not have constant request for resources
                wait();  // Wait for free spaces if no space..
            }
            catch (InterruptedException e) {
               e.printStackTrace();
            }
        }
        
    }

    public synchronized void ExitSpot(){
        AvailableSpots++;
        if(AvailableSpots <= 0){
            notify(); // For the waiting threads(cars)...
        }
    }

    public synchronized int getAvailableSpots(){
        return AvailableSpots;
    }
}
