import java.util.List;

public class producer extends Thread{
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
            buffer.produce(car);
        }
    }
}

