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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ToDoListController implements Initializable {
    @FXML private Button inputDeleteItem;
    @FXML private TableView<Item> itemTable;
    @FXML private TableColumn<Item, String> statusColumn;
    @FXML private TableColumn<Item, String> descriptionColumn;
    @FXML private TableColumn<Item, String> dueDateColumn;
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
    private Scene errorScene;
    private Scene editScene;
    private FXMLLoader editController;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        //  This initializes the columns of the table and sets the table to the ObservableList
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        itemTable.setItems(listOfItems);
    }

    //  Functions below set scene to use in order to transfer between scenes and get access to other controllers
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
    void setEditScene(Scene scene){
        editScene = scene;
    }

    @FXML
    void goEditScene(ActionEvent event){
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(editScene);
    }

    @FXML
    void getEditControllerInfo(FXMLLoader editController){
        this.editController = editController;
    }



    //  All the events to be handled within the controller
    @FXML
    void addItemPressed(ActionEvent event) {
        //  Calls an instance of two other classes to help
        ListOfItems helper = new ListOfItems();

        //  Gets the information of the input fields and passes them to another function
        String description = inputDescription.getText();
        String date;
        try{
            date = inputDueDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch(NullPointerException e){ // Catches if the user doesn't put in a date (or also an invalid date as well)
            date = "";
        }
        RadioButton checker = (RadioButton)isCompletedGroup.getSelectedToggle();
        String isCompleted = checker.getText();

        boolean errorMessagePrompt = helper.addItemToList(listOfItems, description, date, isCompleted);
        inputDescription.clear();

        //  If errorMessagePrompt is true, then it will switch scenes to the error message
        if(errorMessagePrompt){
            //  Changes the scene
            goErrorScene(event);
        }
    }

    @FXML
    void deleteAllItemsPressed(ActionEvent event) {
        //  Calls function within ListOfItems (deleteAllItems) to delete all the items
        ListOfItems helper = new ListOfItems();
        helper.deleteAllItems(listOfItems);
        itemTable.refresh();
    }

    @FXML
    void deleteItemPress(ActionEvent event){
        //  Calls function within ListOfItems (deleteItemInList) to delete the selected item
        ListOfItems helper = new ListOfItems();

        int index;
        try{
            //  Gets the index selected item in the table (regardless of showing the completed/incompleted/all items)
            index = listOfItems.indexOf(itemTable.getSelectionModel().getSelectedItem());
            //  Calls function to delete the item if the user properly selected an item
            helper.deleteItemInList(listOfItems, index);
            //  Updates the table
            itemTable.setItems(listOfItems);
        } catch(IndexOutOfBoundsException a){
            //  If the user doesn't select an element in the table, it will cause an IndexOutOfBoundsException
            //  This will cause the scene to switch to the error scene
            goErrorScene(event);
        }
    }

    @FXML
    void editItemPressed(ActionEvent event){
        int index = listOfItems.indexOf(itemTable.getSelectionModel().getSelectedItem());
        EditItemController editControl = editController.getController();

        // Checks the index to decide where it goes
        if(index >= 0){
            editControl.setTextInput(listOfItems.get(index).getDescription());
            editControl.setItemList(listOfItems);
            editControl.setIndex(index);
            editControl.setStatus(listOfItems.get(index).getStatus());
            goEditScene(event);
        } else {
            goErrorScene(event);
        }
        itemTable.refresh();
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
        itemTable.setItems(listOfItems);
        itemTable.refresh();
    }

    @FXML
    void showCompletedPressed(ActionEvent event) {
        // Sorts the list to show all the completed items with function in ListOfItems (showCompletedItems)
        ListOfItems helper = new ListOfItems();
        ObservableList<Item> completedItems = helper.showCompletedItems(listOfItems);
        itemTable.setItems(completedItems);
        itemTable.refresh();
    }

    @FXML
    void showIncompletedPressed(ActionEvent event) {
        // Sorts the list to show all incompleted items with function in ListOfItems (showIncompletedItems)
        ListOfItems helper = new ListOfItems();
        ObservableList<Item> incompletedItems = helper.showIncompletedItems(listOfItems);
        itemTable.setItems(incompletedItems);
        itemTable.refresh();
    }

    void setItemList(ObservableList<Item> item){
        listOfItems = item;
    }
}
