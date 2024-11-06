
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
                int gateId = Integer.parseInt(inputData[0].split(" ")[1]);//Gate index 1 is the gate id 
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


   

   


   






    



// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileReader;
// import java.nio.file.Path;
// import java.util.Scanner;
// import java.io.FileNotFoundException;
// import java.io.IOException;

// public class Parser {
//      private int carID;
//     private int gateId;
//     private int arrivalTime;
//     private int parkDuration;
//     public void read(Path path){
//         try(Scanner scanner = new Scanner(new File(path.toString()))){
//             while(scanner.hasNextLine()){
//                 String line = scanner.nextLine(); //get the next line
//                 String[] parts = line.split(","); //split the line into 4 parts and remove commas
//                 //ensure there are 4 parts within input line
//                 if(parts.length == 4){
//                     //extract elements 
//                     gateId = Integer.parseInt(parts[0].trim().split(" ")[1]); // take the first element remove
//                                                                                     //trailing spaces
//                                                                                     //split on any empty space
//                                                                                     //takke second element which is a number
//                                                                                     //return as integer nor string
//                     carID = Integer.parseInt((parts[1].trim().split(" ")[1]));
//                     arrivalTime=Integer.parseInt((parts[2].trim().split(" ")[1]));
//                     parkDuration = Integer.parseInt((parts[3].trim().split(" ")[1]));
//                     // add car thread creation here using these values;
//                 }


//             }

//         }
//         catch(IOException e){

//         }
//     }
// }

