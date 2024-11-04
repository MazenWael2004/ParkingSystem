public class EnterParkingSpotSemaphore { // Because the shared resource between car threads is the parking spot.
    private int SpotAvailable;
    

    public EnterParkingSpotSemaphore(int spots){
        this.SpotAvailable = spots;
    }

    public  synchronized void AcquireSpot(int carID,int arrival_time,int parking_duration,int gate_id,int waiting_time){  // Synchronized because we cannot have more than one car take one spot at the same timemee.
        
        while(SpotAvailable <= 0){
            waiting_time++;
            try {
                System.out.println("Car "+carID+ " from Gate "+gate_id+  " is waiting for a spot.");
              wait();  // Wait for free spaces if no space...
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        
        
        SpotAvailable--;  // spots_available decreased by 1.
        System.out.println("Car "+carID+ " from Gate "+gate_id+"  parked after waiting for  "+waiting_time+" units of time.(Parking Status: "+ getRemainingSpots()+" spots occupied)");
        

    }

    public synchronized void ExitSpot(int id,int gate_id,int parking_duration){
        SpotAvailable++;
        System.out.println("Car " + id + " from Gate " + gate_id + " left at time "+parking_duration+" (Parking Status: "+getRemainingSpots()+" spots occupied)");
        notify(); // For the waiting threads(cars)...
    }

    public synchronized int getAvailableSpots(){
        return SpotAvailable;
    }

    public synchronized int getRemainingSpots(){
        return (4-SpotAvailable);
    }
}
