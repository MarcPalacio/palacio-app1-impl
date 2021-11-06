/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Marc Palacio
 */

package baseline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.File;

public class ListOfItems {
    public String addItemToList(ObservableList<Item> list, String description, String date, boolean isCompleted){
        // This will add an item to a list but first, it will do some checking
        // First check would see if there is 100 elements in the list
        //      If there is 100 elements in the list, then it will not add another element
        //      Will also prompt the user for the error message
        // Second check would see if the description length is between 1 and 256 characters
        //      If it is blank or more than 256 characters, then it will not add the element to the list
        //      Will also prompt the user for the error message
        // If both of these checks are passed, then the item will be added to the list
        // Returns a string if an error has occurred (Will correspond with the error, which may just be a description error)
        return "";
    }

    public ObservableList<Item> showAllItems(ObservableList<Item> list){
        // Adds all items from a list to show and return that list
        return null;
    }

    public ObservableList<Item> showCompletedItems(ObservableList<Item> list){
        // Adds only the completed items on the list and return that list
        return null;
    }

    public ObservableList<Item> showIncompletedItems(ObservableList<Item> list){
        // Adds only the incompleted items on the list and return that list
        return null;
    }

    public String editItemInList(ObservableList<Item> list, String description, String date, boolean isCompleted){
        // Similar to addItemToList, but instead it will use the setters to replace the data of an Item
        // Check if the description length is between 1 and 256 characters
        //      If it is blank or more than 256 characters, then it will not edit the element in the list
        //      Will also prompt the user for the error message
        // If this check is passed, then it will set the new data to the Item
        // Returns a string if an error has occurred (Will correspond with the error, which may just be a description error)
        return "";
    }

    public void deleteItemInList(ObservableList<Item> list, String description, String date, boolean isCompleted){
        // This is just going to delete the selected item in the list
    }

    public void deleteAllItems(ObservableList<Item> list){
        // Deletes all the items in the list
    }

    public void saveListFile(ObservableList<Item> list, File outputFile){
        // Uses function from MyFileWriter to write to file
    }

    public void loadSaveFile(ObservableList<Item> list, File inputFile){
        // Reads in the file, then add each item in that file to the list
        // Will be done by calling the function in MyFileReader
    }

    private String writeSaveFile(ObservableList<Item> list){
        // Takes each item in the list then converts it into a string to print to a file.txt for
        // the user to load in next time
        // Format: Description<>Due Date<>isCompleted (Probably in the form of 0 or 1)
        return "";
    }
}
