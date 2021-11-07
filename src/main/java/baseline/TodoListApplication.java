/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Marc Palacio
 */

package baseline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TodoListApplication extends Application {
    public static void main(String args[]){
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception{
        // Loading all of the FXML scenes
        FXMLLoader todoLoad = new FXMLLoader(getClass().getResource("/baseline/ToDoList.fxml"));
        FXMLLoader editLoad = new FXMLLoader(getClass().getResource("/baseline/EditItem.fxml"));
        FXMLLoader errorLoad = new FXMLLoader(getClass().getResource("/baseline/Error.fxml"));

        // Setting up roots
        Parent todoRoot = todoLoad.load();
        Parent editRoot = editLoad.load();
        Parent errorRoot = errorLoad.load();

        // Setting up all the scenes
        Scene toDoListScene = new Scene(todoRoot);
        Scene editItemScene = new Scene(editRoot);
        Scene errorScene = new Scene(errorRoot);


        // Setting up controller to have access to scenes
        ToDoListController todoControl = todoLoad.getController();
        todoControl.getEditControllerInfo(editLoad);
        todoControl.setErrorScene(errorScene);
        todoControl.setEditScene(editItemScene);

        ErrorController errorControl = errorLoad.getController();
        errorControl.setListScene(toDoListScene);

        EditItemController editControl = editLoad.getController();
        editControl.setListScene(toDoListScene);
        editControl.getToDoControllerInfo(todoLoad);
        editControl.setErrorScene(errorScene);


        // Sets the main scene
        primaryStage.setTitle("To-Do List");
        primaryStage.setScene(toDoListScene);
        primaryStage.show();
    }
}
