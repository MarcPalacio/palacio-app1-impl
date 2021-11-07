package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class Application1Test {
    @Test
    void testAddItemInvalid(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and adds an element to that list, but that element has an invalid description
        ObservableList<Item> actual = FXCollections.observableArrayList();
        //  Will be true if the description is invalid
        boolean isInvalidDescription = helper.addItemToList(actual, "", "2021-11-08", "Incomplete");

        assertTrue(isInvalidDescription);
    }

    @Test
    void testDueDateValid(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and adds an element to that list, but the due date is blank, which is allowed
        ObservableList<Item> actual = FXCollections.observableArrayList();
        //  Will be true if the due date is invalid
        boolean isInvalidDueDate = helper.addItemToList(actual, "Test Application 1", "", "Incomplete");

        assertFalse(isInvalidDueDate);
    }

    @Test
    void testAddItem(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and adds an element to that list
        ObservableList<Item> actual = FXCollections.observableArrayList();
        helper.addItemToList(actual, "Test Application 1", "2021-11-08", "Incomplete");
        //  Will assert false if an item was successfully added
        boolean isListEmpty = actual.isEmpty();

        assertFalse(isListEmpty);
    }

    @Test
    void testRemoveSingleItem(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and adds an element to that list
        ObservableList<Item> actual = FXCollections.observableArrayList();
        helper.addItemToList(actual, "Test Application 1", "2021-11-08", "Incomplete");
        //  Then deletes that item
        helper.deleteItemInList(actual, 0);
        //  Will be true if the properly deleted item
        boolean isListEmpty = actual.isEmpty();

        assertTrue(isListEmpty);
    }

    @Test
    void testRemoveAllItems(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and adds a few elements to the list
        ObservableList<Item> actual = FXCollections.observableArrayList();
        helper.addItemToList(actual, "Test Application 1", "2021-11-08", "Incomplete");
        helper.addItemToList(actual, "Record demo", "2021-11-08", "Incomplete");
        helper.addItemToList(actual, "Study for quiz", "2021-11-08", "Incomplete");
        helper.addItemToList(actual, "Research topics for Technical Writing", "2021-11-08", "Incomplete");
        //  Then deletes all items in the list
        helper.deleteAllItems(actual);
        //  Will be true if the properly deleted item
        boolean isListEmpty = actual.isEmpty();

        assertTrue(isListEmpty);
    }

    @Test
    void testEditDescription(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and adds an element to the list
        ObservableList<Item> actual = FXCollections.observableArrayList();
        helper.addItemToList(actual, "Tst Aplication 1", "2021-11-08", "Incomplete");
        //  Then changes the date of the item in the list
        helper.editItemInList(actual.get(0), "Test Application 1", "2021-11-08", "Incomplete");
        //  Will stay true if the description was changed
        boolean checkChangeDescription = actual.get(0).getDescription().equals("Test Application 1");

        assertTrue(checkChangeDescription);
    }

    @Test
    void testEditDate(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and adds an element to the list
        ObservableList<Item> actual = FXCollections.observableArrayList();
        helper.addItemToList(actual, "Test Application 1", "2021-11-07", "Incomplete");
        //  Then changes the date of the item in the list
        helper.editItemInList(actual.get(0), "Test Application 1", "2021-11-08", "Incomplete");
        //  Will stay true if the date was changed
        boolean checkChangeDescription = actual.get(0).getDate().equals("2021-11-08");

        assertTrue(checkChangeDescription);
    }

    @Test
    void testEditStatus(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and adds an element to the list
        ObservableList<Item> actual = FXCollections.observableArrayList();
        helper.addItemToList(actual, "Test Application 1", "2021-11-08", "Incomplete");
        //  Then changes the status of the item in the list
        helper.editItemInList(actual.get(0), "Test Application 1", "2021-11-08", "Complete");
        //  Will stay true if the status was changed
        boolean checkChangeDescription = actual.get(0).getStatus().equals("Complete");

        assertTrue(checkChangeDescription);
    }

    @Test
    void testShowAllItems(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and adds a few elements to the list
        ObservableList<Item> actual = FXCollections.observableArrayList();
        helper.addItemToList(actual, "Test Application 1", "2021-11-08", "Incomplete");
        helper.addItemToList(actual, "Record demo", "2021-11-08", "Incomplete");
        helper.addItemToList(actual, "Study for quiz", "2021-11-08", "Incomplete");
        helper.addItemToList(actual, "Research topics for Technical Writing", "2021-11-08", "Incomplete");
        //  Creates a new list from the original list and adds all the items
        //  Basically just duping it over
        ObservableList<Item> actualIncomplete = helper.showAllItems(actual);
        //  Will continue to be true if the list only has completed items
        boolean isListAll = true;
        for(int i = 0; i < actualIncomplete.size(); i++){
            if (!((actualIncomplete.get(i).getStatus().equals("Incomplete")) || (actualIncomplete.get(i).getStatus().equals("Complete")))) {
                isListAll = false;
                break;
            }
        }

        assertTrue(isListAll);
    }

    @Test
    void testShowIncompletedItems(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and adds a few elements to the list
        ObservableList<Item> actual = FXCollections.observableArrayList();
        helper.addItemToList(actual, "Test Application 1", "2021-11-08", "Incomplete");
        helper.addItemToList(actual, "Record demo", "2021-11-08", "Incomplete");
        helper.addItemToList(actual, "Study for quiz", "2021-11-08", "Complete");
        helper.addItemToList(actual, "Research topics for Technical Writing", "2021-11-08", "Complete");
        //  Creates a new list from the original list and adds on the completed items
        ObservableList<Item> actualIncomplete = helper.showIncompletedItems(actual);
        //  Will continue to be true if the list only has completed items
        boolean isListComplete = true;
        for(int i = 0; i < actualIncomplete.size(); i++){
            if (!(actualIncomplete.get(i).getStatus().equals("Incomplete"))) {
                isListComplete = false;
                break;
            }
        }

        assertTrue(isListComplete);
    }

    @Test
    void testShowCompletedItems(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and adds a few elements to the list
        ObservableList<Item> actual = FXCollections.observableArrayList();
        helper.addItemToList(actual, "Test Application 1", "2021-11-08", "Incomplete");
        helper.addItemToList(actual, "Record demo", "2021-11-08", "Incomplete");
        helper.addItemToList(actual, "Study for quiz", "2021-11-08", "Complete");
        helper.addItemToList(actual, "Research topics for Technical Writing", "2021-11-08", "Complete");
        //  Creates a new list from the original list and adds on the completed items
        ObservableList<Item> actualComplete = helper.showCompletedItems(actual);
        //  Will continue to be true if the list only has completed items
        boolean isListComplete = true;
        for(int i = 0; i < actualComplete.size(); i++){
            if (!(actualComplete.get(i).getStatus().equals("Complete"))) {
                isListComplete = false;
                break;
            }
        }

        assertTrue(isListComplete);
    }

    @Test
    void testFileSaving(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and adds a few elements to the list
        ObservableList<Item> actualList = FXCollections.observableArrayList();
        helper.addItemToList(actualList, "Test Application 1", "2021-11-08", "Incomplete");
        helper.addItemToList(actualList, "Record demo", "2021-11-08", "Incomplete");
        helper.addItemToList(actualList, "Study for quiz", "2021-11-08", "Complete");
        helper.addItemToList(actualList, "Research topics for Technical Writing", "2021-11-08", "Complete");
        //  Create the output String for the file
        String actual = helper.writeSaveFile(actualList);

        String expected =
                "Test Application 1<>2021-11-08<>Incomplete\n" +
                "Record demo<>2021-11-08<>Incomplete\n" +
                "Study for quiz<>2021-11-08<>Complete\n" +
                "Research topics for Technical Writing<>2021-11-08<>Complete";

        assertEquals(expected, actual);
    }

    @Test
    void testFileLoading(){
        ListOfItems helper = new ListOfItems();


        //  Create a new list from file input
        ObservableList<Item> actualList = FXCollections.observableArrayList();
        File inputFile = new File("docs\\TestLoadingFile.txt");
        helper.loadSaveFile(actualList, inputFile);

        //  Creates the list with all the data that should be inside
        ObservableList<Item> expectedList = FXCollections.observableArrayList();
        helper.addItemToList(expectedList, "Test Application 1", "2021-11-08", "Incomplete");
        helper.addItemToList(expectedList, "Record demo", "2021-11-08", "Incomplete");
        helper.addItemToList(expectedList, "Study for quiz", "2021-11-08", "Complete");
        helper.addItemToList(expectedList, "Research topics for Technical Writing", "2021-11-08", "Complete");

        // Will be true until proven false
        boolean isListSame = true;
        for(int i = 0; i < expectedList.size(); i++){
            if (!(actualList.get(i).getDescription().equals(expectedList.get(i).getDescription()) ||
                    actualList.get(i).getDate().equals(expectedList.get(i).getDate()) ||
                    actualList.get(i).getStatus().equals(expectedList.get(i).getStatus()))) {
                isListSame = false;
                break;
            }
        }

        assertTrue(isListSame);
    }
}