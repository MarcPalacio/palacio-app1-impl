/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Marc Palacio
 */

package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ToDoListController {
    @FXML private Button inputDeleteItem;
    @FXML private TableColumn<?, ?> completedQMarkColumn;
    @FXML private TableColumn<?, ?> descriptionColumn;
    @FXML private TableColumn<?, ?> dueDateColumn;
    @FXML private Button inputAddItem;
    @FXML private RadioButton inputCompleted;
    @FXML private Button inputDeleteAllItems;
    @FXML private TextField inputDescription;
    @FXML private DatePicker inputDueDate;
    @FXML private Button inputEditItem;
    @FXML private RadioButton inputIncompleted;
    @FXML private Button inputLoadList;
    @FXML private Button inputSaveList;
    @FXML private RadioButton inputShowAll;
    @FXML private RadioButton inputShowCompleted;
    @FXML private RadioButton inputShowIncompleted;
    @FXML private ToggleGroup isCompletedGroup;
    @FXML private ToggleGroup showItemsGroup;

    ObservableList<Item> listOfItems = FXCollections.observableArrayList();

    @FXML
    void addItemPressed(ActionEvent event) {
        // Passes the fields of each the inputs (Description, date, and completed/incompleted)
        // to the function within the ListOfItems class to add the item to the list
        // If a nonempty string was returned (the error string)
        //      Switch scene to the error scene which will print the error for the user
    }

    @FXML
    void deleteAllItemsPressed(ActionEvent event) {
        // Calls function within ListOfItems (deleteAllItems) to delete all the items
    }

    @FXML
    void deleteItemPress(ActionEvent event) {
        // Calls function within ListOfItems (deleteItemInList) to delete the selected item
        // Probably can't do based off index, so it will be based off of the data inside of the selected element
    }

    @FXML
    void editItemPressed(ActionEvent event) {
        // Switches scene to the EditItem scene
    }

    @FXML
    void loadListPressed(ActionEvent event) {
        // Pulls up where all of the lists should be saved and the user can select a list to load
        // Calls the function in MyFileReader to read in the file and add them to the list
        // Also will replace the current list to ensure that the two lists don't get mixed together
    }

    @FXML
    void saveListPressed(ActionEvent event) {
        // Calls the function in ListOfItems (saveListFile) and saves data to a .txt file
    }

    @FXML
    void showAllPressed(ActionEvent event) {
        // Sorts the list to show all items with function in ListOfItems (showAllItems)
    }

    @FXML
    void showCompletedPressed(ActionEvent event) {
        // Sorts the list to show all the completed items with function in ListOfItems (showCompletedItems)
    }

    @FXML
    void showIncompletedPressed(ActionEvent event) {
        // Sorts the list to show all incompleted items with function in ListOfItems (showIncompletedItems)
    }
}
