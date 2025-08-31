/*
BaboolalArrayList.java
08/30/2025
This program defines a static method createList() that 
creates and returns a new ArrayList of strings. In the main method, 
it calls this method, adds several elements to the list, and then 
prints the contents to the console.
*/
import java.util.ArrayList;

public class BaboolalArrayList {

    // Static method that returns a new ArrayList
    public static ArrayList<String> createList() {
        ArrayList<String> list = new ArrayList<>();
        return list;
    }

    public static void main(String[] args) {
        // Call the static method
        ArrayList<String> myList = createList();

        // Add some elements to test
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Cherry");

        // Print the ArrayList
        System.out.println("Contents of the ArrayList: " + myList);
    }
}
