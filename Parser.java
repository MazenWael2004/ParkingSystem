import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Parser {
     private int carID;
    private int gateId;
    private int arrivalTime;
    private int parkDuration;
    public void read(Path path){
        try(Scanner scanner = new Scanner(new File(path.toString()))){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine(); //get the next line
                String[] parts = line.split(","); //split the line into 4 parts and remove commas
                //ensure there are 4 parts within input line
                if(parts.length == 4){
                    //extract elements 
                    gateId = Integer.parseInt(parts[0].trim().split(" ")[1]); // take the first element remove
                                                                                    //trailing spaces
                                                                                    //split on any empty space
                                                                                    //takke second element which is a number
                                                                                    //return as integer nor string
                    carID = Integer.parseInt((parts[1].trim().split(" ")[1]));
                    arrivalTime=Integer.parseInt((parts[2].trim().split(" ")[1]));
                    parkDuration = Integer.parseInt((parts[3].trim().split(" ")[1]));
                    // add car thread creation here using these values;
                }


            }

        }
        catch(IOException e){

        }
    }
}
