/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Marc Palacio
 */

package baseline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ErrorController {
    //  FXML elements
    @FXML private Label labelError;
    @FXML private Button nextButton;

    //  Attributes
    private Scene listScene;

    // Functions for setting scenes
    @FXML
    void setListScene(Scene scene){
        //  Sets the ToDoList scene
        listScene = scene;
    }

    @FXML
    void goListScene(ActionEvent event){
        //  Switches scenes to the ToDoList Scene
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(listScene);
    }

    @FXML
    void nextButtonPressed(ActionEvent event){
        //  Goes back to the ToDoList scene after the user sees the error they made
        goListScene(event);
    }
}
