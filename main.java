import java.util.List;

public class main {
    public static void main(String[] args){
        ParkingSemaphore parkinglot = new ParkingSemaphore(4);
       // Define and initialize the array of ParkingSemaphore objects with 3 elements, each initialized with value 1
    ParkingSemaphore[] gateSemaphores = {
        new ParkingSemaphore(1),
        new ParkingSemaphore(1),
        new ParkingSemaphore(1)
    };
    
    Parser p = new Parser("file.txt");
    List<carThread> carThreads =p. readDateAndStoretoCarThread();
    int size = 4;
    ParkingLotBuffer ParkingLotBuffer = new ParkingLotBuffer(carThreads.size(), size);
    producer enter = new producer(ParkingLotBuffer, carThreads);
    consumer exit = new consumer(ParkingLotBuffer, carThreads);
    enter.start();
    exit.start();
    try{
        enter.join();
        exit.join();
    }
    catch(InterruptedException e){
        e.printStackTrace();
    }


    }
}
