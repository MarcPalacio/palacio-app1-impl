/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Marc Palacio
 */

package baseline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.File;

public class ListOfItems {
    public boolean addItemToList(ObservableList<Item> list, String description, String date, String status){
        //  This will add an item to a list but first, it will do some checking
        boolean output = false;

        //  Conducts two checks
        //  First check is the size of the list, while the second check is the description length
        if(list.size() >= 100 || (description.length() < 1 || description.length() > 256)){
            //  Switch output to true, then it will prompt the user with an error window when it returns
            output = true;
        }
        //  If both of these checks are passed, then the item will be added to the list
        else {
            list.add(new Item(description, date, status));
        }

        //  Returns whatever the output is
        return output;
    }

    public ObservableList<Item> showCompletedItems(ObservableList<Item> list){
        //  Adds only the completed items on the list and return that list
        ObservableList<Item> completedItems = FXCollections.observableArrayList();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getStatus().equals("Complete")){
                completedItems.add(list.get(i));
            }
        }

        return completedItems;
    }

    public ObservableList<Item> showIncompletedItems(ObservableList<Item> list){
        //  Adds only the incompleted items on the list and return that list
        ObservableList<Item> incompletedItems = FXCollections.observableArrayList();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getStatus().equals("Incomplete")){
                incompletedItems.add(list.get(i));
            }
        }

        return incompletedItems;
    }

    public boolean editItemInList(Item editItem, String description, String date, String status){
        //  Similar to addItemToList, but instead it will use the setters to replace the data of an Item
        boolean output = false;

        //  If it is blank or more than 256 characters, then it will not edit the element in the list
        if(description.length() < 1 || description.length() > 256){
            output = true;
        }
        //  If this check is passed, then it will set the new data to the Item
        else{
            editItem.setDescription(description);
            editItem.setDate(date);
            editItem.setCompleted(status);
        }

        //  Returns whatever the output is
        return output;
    }

    public void deleteItemInList(ObservableList<Item> list, int index){
        //  This is just going to delete the selected item in the list
        list.remove(list.get(index));
    }

    public void deleteAllItems(ObservableList<Item> list){
        //  Deletes all the items in the list
        list.clear();
    }

    public void saveListFile(ObservableList<Item> list, File outputFile){
        //  Uses function from MyFileWriter to write to file
        MyFileWriter fw = new MyFileWriter();
        String save = writeSaveFile(list);
        fw.writeToFile(save, outputFile);
    }

    public void loadSaveFile(ObservableList<Item> list, File inputFile){
        //  Reads in the file, then add each item in that file to the list
        //  Will be done by calling the function in MyFileReader
        MyFileReader fr = new MyFileReader();
        fr.scanInputFile(list, inputFile);
    }

    private String writeSaveFile(ObservableList<Item> list){
        //  Takes each item in the list then converts it into a string to print to a file.txt for
        //  the user to load in next time
        StringBuilder output = new StringBuilder("");
        //  Format: Description<>Due Date<>isCompleted (Probably in the form of 0 or 1)
        for(int i = 0; i < list.size(); i++){
            output.append(list.get(i).toString());
            //  To ensure there isn't an extra line at the end
            if(i < list.size()-1){
                output.append("\n");
            }
        }

        return output.toString();
    }
}
