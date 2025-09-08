/*
BaboolalRemoveDuplicatesTest.java
09/07/2025
This program generates an ArrayList of 50 random integers 
between 1 and 20, which may include duplicates. It then uses 
a generic method to create and display a new ArrayList containing 
only the unique values from the original list.
*/
import java.util.ArrayList;
import java.util.Random;

public class BaboolalRemoveDuplicatesTest {

    public static void main(String[] args) {
        // Create an ArrayList with 50 random integers between 1 and 20
        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 50; i++) {
            originalList.add(rand.nextInt(20) + 1); // values 1 to 20
        }

        // Display the original list
        System.out.println("Original List (50 random numbers with duplicates):");
        System.out.println(originalList);

        // Call removeDuplicates
        ArrayList<Integer> noDuplicatesList = removeDuplicates(originalList);

        // Display the list with duplicates removed
        System.out.println("\nList after removing duplicates:");
        System.out.println(noDuplicatesList);
    }

    // Generic method to remove duplicates
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> result = new ArrayList<>();

        for (E element : list) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }

        return result;
    }
}
