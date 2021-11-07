/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Marc Palacio
 */

package baseline;

public class Item {
    //  Attributes of Item Class
    private String description;
    private String date;
    private String status;

    public Item(String description, String date, String status){
        //  Calls setters to assign data
        setDescription(description);
        setDate(date);
        setCompleted(status);
    }

    public void setDescription(String description) {
        //  Sets the description of the item
        this.description = description;
    }

    public void setDate(String date) {
        //  Sets the due date of the item (Date can be empty)
        this.date = date;
    }

    public void setCompleted(String status) {
        //  Sets if the item is completed or not
        this.status = status;
    }

    public String getDescription() {
        //  Returns the description of the item
        return description;
    }

    public String getDate() {
        //  Returns the due date of the item
        return date;
    }

    public String getStatus() {
        //  Returns if the item is completed or not
        return status;
    }

    @Override
    public String toString(){
        //  toString that writes the item in format
        return description + "<>" + date + "<>" + status;
    }
}
