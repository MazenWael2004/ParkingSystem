public class carThread extends Thread {
    private EnterParkingSpotSemaphore parkingSpotSemaphore;
    private int id;
    private int arrival_time;
    private int parking_duration;
    private int gate_id;
    private int waiting_time;

    public carThread(EnterParkingSpotSemaphore semaphore, int id, int arrival_time, int parking_duration, int gate_id) {
        this.parkingSpotSemaphore = semaphore;
        this.id = id;
        this.arrival_time = arrival_time;
        this.parking_duration = parking_duration;
        this.gate_id = gate_id;
        this.waiting_time = 0;
    }

    @Override
    public void run() {
        try {
            // to simulate car arrival..
            Thread.sleep((arrival_time * 1000));
            System.out.println("Car " + id + " from Gate " + gate_id + " arrived at time "+arrival_time);


           
            parkingSpotSemaphore.AcquireSpot(id ,arrival_time, parking_duration, gate_id,waiting_time);

            // to simualte parking duration....
            Thread.sleep((parking_duration * 1000));
           

            parkingSpotSemaphore.ExitSpot(id,gate_id,parking_duration);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public double getArrivalTime() {
        return arrival_time;
    }
}


    

