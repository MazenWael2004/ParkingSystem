import java.util.List;

public class ParkingLotBuffer {

    private int size;
    private int counter;
    private carThread spots[];
    private int inputPointer = 0;
    private int outputPointer = 0;
    //assume semaphore implementation is class parkingSemaphore
    ParkingSemaphore FreeSpaces = new ParkingSemaphore(size);
    ParkingSemaphore parkedCars = new ParkingSemaphore(0);

    public ParkingLotBuffer( int size ){
        this.size = size;
        spots = new carThread[size];
        counter = 0;
    }
    public void produce(carThread value){
        
            FreeSpaces.AcquireSpot();
        
            //enter critical section
            synchronized(this){
                for(int i = 0; i < size; i++){
                    if(!spots[i].isRunning ||spots[i] == null){
                        spots[i] = value;
                        counter++;
                        break;
                    }
                    

                }
            }
            //exit critical section

            //output here


            parkedCars.ExitSpot(); //signal parkedCars semaphore to take unparked cars in lot
                                // ie signal method
    }
    public void consume(carThread value){
        parkedCars.AcquireSpot(); // semaphore wait method
        //enter critical section
        synchronized(this){
        value = spots[outputPointer];
        for(int i = 0; i < size; i++){
            if(!value.isParked && !value.isRunning) {
                outputPointer = (outputPointer + 1) % size;
                counter --;
                break;
        }
        
        }
        }
        // exit critical section
        // ParkingManager log
        FreeSpaces.ExitSpot(); // semaphore ExitSpot method
        // make sure car thread terminates here
    }
    public int getCounter(){
        return counter;
    }
    public int getSize(){
        return size;
    }
    public carThread[] getSpots(){
        return spots;
    } 
}