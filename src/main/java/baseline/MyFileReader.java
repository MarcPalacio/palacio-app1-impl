/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Marc Palacio
 */

package baseline;

import javafx.collections.ObservableList;

import java.io.*;

public class MyFileReader {
    public void scanInputFile(ObservableList<Item> list, File inputFile){
        //  Creates an instance of ListOfItems to use function addItemToList
        ListOfItems helper = new ListOfItems();

        //  Creates a file reader
        try(BufferedReader br = new BufferedReader(new FileReader(inputFile))){
            String add;
            //  While the line isn't empty
            while((add = br.readLine()) != null){
                //  Separates the description with the split indicator (<>)
                String description = add.substring(0, add.indexOf("<>"));
                //  Sets the next string to cut off the description and indicator
                add = add.substring(add.indexOf("<>")+2);
                //  Separates the date with the split indicator
                String date = add.substring(0, add.indexOf("<>"));
                //  The remainder of the string is status
                String status = add.substring(add.indexOf("<>")+2);

                // Adds item to the list once getting all it's properties
                boolean h = helper.addItemToList(list, description, date, status);
            }
        } catch (FileNotFoundException e) { // Exception handling
            System.out.println("File not found");
        } catch (IOException a) { // Exception handling
            System.out.println("An I/O Error occurred");
            a.printStackTrace();
        }
    }
}
