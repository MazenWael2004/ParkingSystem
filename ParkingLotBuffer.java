public class ParkingLotBuffer {
    private int TotalCars; //used to limit while loops
                           //should be gotten from parser
    private int carsProduced;
    private int carsConsumed;
    private int size = 4;
    private Object spots[] = new Object[size];
    private int inputPointer = 0;
    private int outputPointer = 0;
    //assume semaphore implementation is class parkingSemaphore
    parkingSemaphore FreeSpaces = new parkingSemaphore(size);
    parkingSemaphore parkedCars = new parkingSemaphore(0);

    public ParkingLotBuffer(int totalNumberOfCars){
        this.TotalCars = totalNumberOfCars;
    }
    public void gateEnterence(Object value){
        while(carsProduced < TotalCars){ // we still have cars to produce
        FreeSpaces.Acquire(); // make into wait function of Semaphore
        
        //enter critical section
        synchronized(this){
        spots[inputPointer] = value;
        inputPointer = (inputPointer + 1) % size;

        //log what needs to be logged by parkingManager
        }
        //exit critical section
        carsProduced++;
        parkedCars.Signal(); //signal parkedCars semaphore to take unparked cars in lot
                            // ie signal method
    }
    }
    public void GateExit(){
        while( carsConsumed < TotalCars) {
        Object value;
        parkedCars.Acquire(); // semaphore wait method

        //enter critical section
        synchronized(this){
        value = spots[outputPointer]; 
        outputPointer = (outputPointer + 1) % size;
        // ParkingManager log
        }
        // exit critical section
        carsConsumed++;
        FreeSpaces.signal(); // semaphore signal method
    }
        // make sure car thread terminates here
    }

    
    
}
