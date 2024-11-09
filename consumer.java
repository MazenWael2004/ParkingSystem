import java.util.List;

public class consumer extends Thread {
    private ParkingLotBuffer buffer;
    private int consumedCars;
    private List<carThread> carThreads;
    public consumer(ParkingLotBuffer buf, List<carThread> carThreads ){
        this.buffer = buf;
        this.carThreads = carThreads;
        consumedCars = 0;


    }
    public void run(){

        while(consumedCars < carThreads.size()){
            while(buffer.getCounter() == 0){
                //do nothing as waiting
            }
           for(carThread car : buffer.getSpots()) {
            buffer.consume(car);
            consumedCars++;
            //output to file here

            // after out put set car isRunning to false
            car.isRunning = false;
           }
           
        }
    }
}
