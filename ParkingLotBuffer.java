import java.util.List;

public class ParkingLotBuffer {
    private int TotalCars; //used to limit while loops
                           //should be gotten from parser
    private int carsProduced;
    private int carsConsumed;
    private int size;
    private Object spots[] = new Object[size];
    private int inputPointer = 0;
    private int outputPointer = 0;
    //assume semaphore implementation is class parkingSemaphore
    ParkingSemaphore FreeSpaces = new ParkingSemaphore(size);
    ParkingSemaphore parkedCars = new ParkingSemaphore(0);

    public ParkingLotBuffer(int totalNumberOfCars, int size ){
        this.TotalCars = totalNumberOfCars;
        this.size = size;
    }
    public void produce(Object value){
            FreeSpaces.AcquireSpot();
        
            //enter critical section
            synchronized(this){
            spots[inputPointer] = value;
            inputPointer = (inputPointer + 1) % size;
            //log what needs to be logged by parkingManager
            }
            //exit critical section
            carsProduced++;
            parkedCars.ExitSpot(); //signal parkedCars semaphore to take unparked cars in lot
                                // ie signal method
    }
    public void consume(Object value){
        parkedCars.AcquireSpot(); // semaphore wait method
        //enter critical section
        synchronized(this){
        value = spots[outputPointer]; 
        outputPointer = (outputPointer + 1) % size;
        // ParkingManager log
        }
        // exit critical section
        carsConsumed++;
        FreeSpaces.ExitSpot(); // semaphore ExitSpot method
        // make sure car thread terminates here
    }

    
    
}