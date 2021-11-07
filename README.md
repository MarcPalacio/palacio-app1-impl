
# To Do List - How to use

A To-Do List Java application created for Dr. Hollander's Fall 2021 course in
Object Oriented Programming at the University of Central Florida.

## What the Program Can Do
- Store up to 100 items in one list
  - Items consisting of a description, a date in format (YYYY-MM-DD), and a status
- Add items to the list
- Edit Items in the list
- View items in the list
- Save and load lists

## Functions
### Adding Items
In order to add an item, the user must click the Add Item button on the right side of the
screen after filling out the description, selecting the date, and selecting whether or
not the item is completed or not. If the user fails to put a description or puts too
long of a description, they will get an error screen and the item will fail to be added
to the list.

### Viewing Items
At the bottom left of the screen, the user can select whether or not they would like to
see all items, completed items, or incomplete items. After selecting which view they would
like to see, the list will update and only show those items to the user.

### Editing Items
If the user wants to edit an item from the list, they must select the element from the table
by clicking on that element once then clicking the Edit Item button. If done correctly,
the user will be greeted with another screen where they are able to edit their description,
date, and status. If done incorrectly, the user will get an error screen letting them know
that they possibly did not select an element properly.

### Deleting One Item
If the user wants to delete an item from the list, they must select the element from the table
by clicking on that element once, then clicking on the Delete Item button. If done correctly,
the user will see that element selected element disappear from the list. If done incorrectly,
the user will get an error screen letting them know that they possibly did not select an element
properly.

### Deleting All Items
If the user wants to clear their list completely, then they can click on the Delete All 
Items button at the bottom of the screen next to Delete Item. This will delete all of the
items from the list. Only use if you intentionally want to wipe your entire list.

### Saving Lists
If the user wants save their list in order to be used later, they may click the Save List button
at the bottom right of the screen. From there they can type in the name of the file and choose
the location of where to save it. If the user exits before hitting save, the list will not be saved.

### Loading Lists
If the user wants to load a list that they had previously saved from another time they used
the program, the user may click the Load List button at the bottom right and select the file
that they saved. Note, by loading another list, it will wipe your current list. Make sure to
save your current list before loading in another list.