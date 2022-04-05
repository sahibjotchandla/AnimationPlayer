/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class txt_file_extracter {
    public static void main(String[] args) {
        try {
            File myObj = new File("AnimationInfo.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                data = data.replaceAll("[^\\d]", " ");
  
                // Remove extra spaces from the beginning
                // and the ending of the string
                data = data.trim();
  
                // Replace all the consecutive white
                // spaces with a single space
                data = data.replaceAll(" +", "-");
                int[] ints = new int[3];

                if(data.contains("-") == true){ //if the data contains "-", or specifically, if the data is an RBG colour code
                    String[] numbers = data.split("-");                   
                    for (int i = 0; i < 3; i++) {
                        ints[i] = Integer.parseInt(numbers[i]); //turn the data elements into integers
                    }
                    int red = ints[0], green = ints[1], blue = ints[2]; //integers expressed as (#,#,#) represents the RBG colour code and are extracted from the txt file 
                    System.out.println(red+" "+green+" "+blue); //this print statement is just to test/print the RGB numbers for the colour
                }
                else if(data.matches("[0-9]+") == true){ 
                    int number = Integer.parseInt(data);  //extract the individual integers from the txt file
                    System.out.println(data); //this priint state is just to test/print the individual integers that are extracted
                }               
            }
            myReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("error...");
            e.printStackTrace();
        }
    }
    
}
