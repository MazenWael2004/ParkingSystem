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
    list<carThread> carThreads =p. readDateAndStoretoCarThread();
    int size = 4;
    ParkingLotBuffer parkingLotBuffer = new ParkingLotBuffer(carThreads.length(), size);
    producer enter = new producer(parkingLotBuffer, carThreads);
    consumer exit = new consumer(parkingLotBuffer, carThreads);
    enter.start();
    exit.start();


    }
}
