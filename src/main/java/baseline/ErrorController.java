/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Marc Palacio
 */

package baseline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ErrorController {

    @FXML private Label labelError;

    @FXML private Button nextButton;

    @FXML
    void nextButtonPressed(ActionEvent event) {
        // Goes back to the ToDoList scene after the user sees the error they made
    }
}
