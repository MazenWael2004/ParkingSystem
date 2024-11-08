import java.util.List;

public class consumer extends Thread {
    private ParkingLotBuffer buffer;
    private List<carThread> carThreads;
    public consumer(ParkingLotBuffer buf, List<carThread> carThreads ){
        this.buffer = buf;
        this.carThreads = carThreads;


    }
    public void run(){
        for(carThread car : carThreads){
            //output to file here
            buffer.consume(car);

        }
    }
}
