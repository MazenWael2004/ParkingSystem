import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//class to parse input from file as required to use it with car thread
class Parser{
    private String file;

    public Parser(String file){
        this.file=file;
    }
     // we can read data form the file , split it into  car id , gate id , arrival time , park duration
    // and add it to a list of car threads

    public List<carThread> readDateAndStoretoCarThread() throws IOException {
        List<carThread> carThreads = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line; //represent each lime in the input file
            while ((line = reader.readLine()) != null) {
                //input format in assignment is  Gate 1, Car 0, Arrive 0, Parks 3// so I split each part we need to store in each car thread
                String[] inputData= line.split(", ");//remove , to easy parse the data we need
                int gateId = Integer.parseInt(inputData[0].split(" ")[1]);//Car 0 index 1 is the gate id 
                int carId = Integer.parseInt(inputData[1].split(" ")[1]); //Car 0
                int arrivalTime = Integer.parseInt(inputData[2].split(" ")[1]);
                int parkDuration = Integer.parseInt(inputData[3].split(" ")[1]);

                // here we can use the data we parsed from the file to create the cars
                carThread car = new carThread(carId, gateId, arrivalTime, parkDuration);
                carThreads.add(car);
            }
        }

        return carThreads;
    }


}


   

   


   






    


