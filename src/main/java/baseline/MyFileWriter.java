/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Marc Palacio
 */

package baseline;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {
    public void writeToFile(String list, File outputFile){
        // Creates a file writer
        try(FileWriter fr = new FileWriter(outputFile)){
            // Writes to file outputFile with the String
            fr.write(list);
        } catch(FileNotFoundException e){ // Exception handling
            System.out.println("File not found");
        } catch(IOException a){ // Exception handling
            System.out.println("An I/O Error occurred");
            a.printStackTrace();
        }
    }
}
