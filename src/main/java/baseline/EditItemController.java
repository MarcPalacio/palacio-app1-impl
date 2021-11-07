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
    @FXML private Button inputEditItem;
    @FXML private Button inputCancelEdit;
    @FXML private RadioButton inputCompletedEdit;
    @FXML private TextField inputDescriptionEdit;
    @FXML private DatePicker inputDueDateEdit;
    @FXML private RadioButton inputIncompletedEdit;
    @FXML private ToggleGroup isCompletedGroupEdit;

    ObservableList<Item> listOfItems = FXCollections.observableArrayList();
    private int index;
    private Scene listScene;
    private Scene errorScene;
    private FXMLLoader toDoController;

    @FXML
    void setListScene(Scene scene){
        listScene = scene;
    }

    @FXML
    void goListScene(ActionEvent event){
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(listScene);
    }

    @FXML
    void getToDoControllerInfo(FXMLLoader todoController){
        this.toDoController = todoController;
    }

    @FXML
    void setErrorScene(Scene scene){
        errorScene = scene;
    }

    @FXML
    void goErrorScene(ActionEvent event){
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(errorScene);
    }

    @FXML
    void editItemPressed(ActionEvent event) {
        // Passes the fields of each the inputs (Description, date, and completed/incompleted)
        // to the function within the ListOfItems class to edit that item
        // If a nonempty string was returned (the error string)
        //      Switch scene to the error scene which will print the error for the user

        ListOfItems helper = new ListOfItems();
        ToDoListController toDoListController = toDoController.getController();

        String description = inputDescriptionEdit.getText();
        String date;
        try{
            date = inputDueDateEdit.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch(NullPointerException e){ // Catches if the user doesn't put in a date (or also an invalid date as well)
            date = "";
        }
        RadioButton checker = (RadioButton)isCompletedGroupEdit.getSelectedToggle();
        String isCompleted = checker.getText();

        boolean errorMessagePrompt = helper.editItemInList(listOfItems.get(index), description, date, isCompleted);

        if(errorMessagePrompt){
            //  Changes the scene
            goErrorScene(event);
        }

        toDoListController.setItemList(listOfItems);
        goListScene(event);
    }

    @FXML
    void cancelEditPressed(ActionEvent event){
        // Exits the edit item scene back to the to do list scene without doing anything
        goListScene(event);
    }

    void setTextInput(String previousInput){
        inputDescriptionEdit.setText(previousInput);
    }

    void setItemList(ObservableList<Item> item){
        listOfItems = item;
    }

    void setIndex(int index){
        this.index = index;
    }

    void setStatus(String status){
        if(status.equals("Complete")) {
            inputCompletedEdit.setSelected(true);
        } else{
            inputIncompletedEdit.setSelected(true);
        }
    }
}
