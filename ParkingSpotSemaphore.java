public class ParkingSpotSemaphore { // Because the shared resource between car threads is the parking spot.
    private int SpotAvailable;

    public ParkingSpotSemaphore(int spots){
        this.SpotAvailable = spots;
    }

    public  synchronized void AcquireSpot(){ // Synchronized because we cannot have more than one car take one spot at the same timemee.
        while(SpotAvailable <= 0){
            try {
              wait();  // Wait for free spaces if no space...
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        SpotAvailable--; // spots_available decreased by 1.

    }

    public synchronized void ExitSpot(){
        SpotAvailable++;
        notify(); // For the waiting threads(cars)...
    }

    public synchronized int getAvailableSpots(){
        return SpotAvailable;
    }
}
