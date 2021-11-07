/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Marc Palacio
 */

package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import java.time.format.DateTimeFormatter;

public class EditItemController{
    //  FXML Elements
    @FXML private Button inputEditItem;
    @FXML private Button inputCancelEdit;
    @FXML private RadioButton inputCompletedEdit;
    @FXML private TextField inputDescriptionEdit;
    @FXML private DatePicker inputDueDateEdit;
    @FXML private RadioButton inputIncompletedEdit;
    @FXML private ToggleGroup isCompletedGroupEdit;

    //  Attributes
    ObservableList<Item> listOfItems = FXCollections.observableArrayList();
    private int index;
    private Scene listScene;
    private Scene errorScene;
    private FXMLLoader toDoController;

    // Functions for setting scenes and getting controller information
    @FXML
    void setListScene(Scene scene){
        //  Sets ToDoList scene
        listScene = scene;
    }

    @FXML
    void goListScene(ActionEvent event){
        //  Goes to ToDoListScene
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(listScene);
    }

    @FXML
    void getToDoControllerInfo(FXMLLoader todoController){
        //  Gets access to the controller of the preloaded scene
        this.toDoController = todoController;
    }

    @FXML
    void setErrorScene(Scene scene){
        //  Sets the error scene
        errorScene = scene;
    }

    @FXML
    void goErrorScene(ActionEvent event){
        //  Goes to error scene
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(errorScene);
    }


    //  Functions for event handling with buttons
    @FXML
    void editItemPressed(ActionEvent event) {
        //  Creates instance of ListOfItems and ToDoListController to have access to their functions
        ListOfItems helper = new ListOfItems();
        ToDoListController toDoListController = toDoController.getController();

        //  Grabs the data from the inputs (Description, date, and status)
        String description = inputDescriptionEdit.getText();
        String date;
        try{
            date = inputDueDateEdit.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch(NullPointerException e){ // Catches if the user doesn't put in a date (or also an invalid date as well)
            date = "";
        }
        RadioButton checker = (RadioButton)isCompletedGroupEdit.getSelectedToggle();
        String isCompleted = checker.getText();

        //  Replaces that item with new information
        boolean errorMessagePrompt = helper.editItemInList(listOfItems.get(index), description, date, isCompleted);

        //  If errorMessagePrompt is true, then the scene will change
        if(errorMessagePrompt){
            //  Changes the scene
            goErrorScene(event);
        } else { //  It will set the list in the ToDoListController to this one and go back to the ToDoList scene
            toDoListController.setItemList(listOfItems);
            goListScene(event);
        }
    }

    @FXML
    void cancelEditPressed(ActionEvent event){
        // Exits the edit item scene back to the to do list scene without doing anything
        goListScene(event);
    }

    //  Functions to set elements within this controller
    void setTextInput(String previousInput){
        //  Sets the text input to whatever the previous description was
        inputDescriptionEdit.setText(previousInput);
    }

    void setItemList(ObservableList<Item> item){
        //  Sets this list to a list from outside the function
        listOfItems = item;
    }

    void setIndex(int index){
        //  Set the index of the element that is going to be edited
        this.index = index;
    }

    void setStatus(String status){
        //  Depending on the status, it will set the radio button
        //  when it switches to this scene
        if(status.equals("Complete")) {
            inputCompletedEdit.setSelected(true);
        } else{
            inputIncompletedEdit.setSelected(true);
        }
    }
}
