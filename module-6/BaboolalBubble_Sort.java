/*
BaboolalBubble_Sort.java
09/7/2025
This program demonstrates bubble sort using two generic methods: 
one that sorts arrays of objects implementing the Comparable interface 
and another that sorts using a custom Comparator. Along with test cases 
with integer to verify that both methods work correctly.
*/
import java.util.Comparator;

public class BaboolalBubble_Sort {

    // Bubble sort using Comparable.
    // Works when the objects in the array know how to compare themselves.
    
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean swapped;
        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.length - 1 - i; j++) {
                // if the current item is bigger than the next, swap them
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            // if nothing moved this round, the array is already sorted
            if (!swapped) break;
        }
    }

     //Bubble sort using a Comparator.
     // Lets us decide the sorting rules when we call it.
     
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean swapped;
        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.length - 1 - i; j++) {
                // use the comparator to decide if these two need to switch
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            // stop early if we didn’t swap anything this pass
            if (!swapped) break;
        }
    }

    // Quick test for both sorting methods.
     
    public static void main(String[] args) {
        // Test 1: The test to make sure Comparable interface works
        Integer[] numbers = {5, 3, 8, 4, 2};
        System.out.println("Original numbers (for Comparable test):");
        printArray(numbers);

        bubbleSort(numbers); // using Comparable
        System.out.println("Sorted numbers (Comparable):");
        printArray(numbers);

        // Test 2: The test to make sure Comparator interface works (descending order)
        Integer[] numbersDesc = {5, 3, 8, 4, 2};
        System.out.println("\nOriginal numbers (for Comparator test):");
        printArray(numbersDesc);

        bubbleSort(numbersDesc, Comparator.reverseOrder());
        System.out.println("Sorted numbers (Comparator, descending):");
        printArray(numbersDesc);
    }

    // method to print out arrays
    private static <E> void printArray(E[] array) {
        for (E element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}