import java.util.List;

public class producer extends Thread{
    ParkingSemaphore[] gateSemaphores = {
        new ParkingSemaphore(1),
        new ParkingSemaphore(1),
        new ParkingSemaphore(1)
    };
    private ParkingLotBuffer buffer;
    int size;
    List<carThread> carThreads;
    public producer( ParkingLotBuffer buf, List<carThread> carThreads){
        this.buffer = buf;
        size = carThreads.size();
        this.carThreads = carThreads;
    }
    public void run(){
        for(carThread car : carThreads){
            switch (car.getGateNumber())
        {
            case 1:
            gateSemaphores[0].AcquireSpot();
            //some output to txt file
            gateSemaphores[0].ExitSpot();
            break;
            case 2:
            gateSemaphores[1].AcquireSpot();
            //some output to txt file
            gateSemaphores[1].ExitSpot();
            break;
            case 3:
            gateSemaphores[2].AcquireSpot();
            //some output to txt file
            gateSemaphores[2].ExitSpot();
            break;

        }
        car.isParked = true; // set to parked before entering 
                            //parking lot to ensure that consumer does not take it
                            //immediately after 
        buffer.produce(car);
        while(buffer.getCounter() == buffer.getSize()){
            //do nothing as buffer is full
        }
            
        }
    }
}

