/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Marc Palacio
 */

package baseline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class EditItemController {
    @FXML private Button inputEditItem;
    @FXML private Button inputCancelEdit;
    @FXML private RadioButton inputCompletedEdit;
    @FXML private TextField inputDescriptionEdit;
    @FXML private DatePicker inputDueDateEdit;
    @FXML private RadioButton inputIncompletedEdit;
    @FXML private ToggleGroup isCompletedGroupEdit;

    @FXML
    void editItemPressed(ActionEvent event) {
        // Passes the fields of each the inputs (Description, date, and completed/incompleted)
        // to the function within the ListOfItems class to edit that item
        // If a nonempty string was returned (the error string)
        //      Switch scene to the error scene which will print the error for the user
    }

    @FXML
    void cancelEditPressed(ActionEvent event) {
        // Exits the edit item scene back to the to do list scene
    }
}
