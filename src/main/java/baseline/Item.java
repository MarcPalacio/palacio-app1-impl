/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Marc Palacio
 */

package baseline;

public class Item {
    // Attributes of Item Class
    private String description;
    private String date;
    private boolean isCompleted;

    public Item(String description, String date, boolean isCompleted){
        // Calls setters to assign data
    }

    public void setDescription(String description) {
        // Sets the description of the item
    }

    public void setDate(String date) {
        // Sets the due date of the item (Date can be empty)
    }

    public void setCompleted(boolean isCompleted) {
        // Sets if the item is completed or not
    }

    public String getDescription() {
        // Returns the description of the item
        return "";
    }

    public String getDate() {
        // Returns the due date of the item
        return "";
    }

    public boolean getCompleted() {
        // Returns if the item is completed or not
        return false;
    }
}
