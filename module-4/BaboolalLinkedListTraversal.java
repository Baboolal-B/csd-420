/*
BaboolalLinkedListTraversal.java
08/30/2025
This program creates a LinkedList of integers and measures 
the time it takes to traverse the list using both an iterator 
and the get(index) method. It then compares the traversal times 
for different list sizes and verifies that both methods produce the same result.

NOTES:
Please be aware when running this program the get(index) traversal time takes a while.
*/
import java.util.LinkedList;
import java.util.Iterator;

public class BaboolalLinkedListTraversal {

    public static void main(String[] args) {
        // Test with 50,000 integers
        testTraversal(50_000);

        // Test with 500,000 integers
        testTraversal(500_000);
    }

    private static void testTraversal(int size) {
        System.out.println("Testing LinkedList traversal with " + size + " elements...");

        // Create and populate LinkedList
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        // Test traversal using Iterator
        long startIterator = System.currentTimeMillis();
        Iterator<Integer> it = list.iterator();
        long sumIterator = 0;
        while (it.hasNext()) {
            sumIterator += it.next();
        }
        long endIterator = System.currentTimeMillis();
        System.out.println("Iterator traversal time: " + (endIterator - startIterator) + " ms");

        // Test traversal using get(index)
        long startGet = System.currentTimeMillis();
        long sumGet = 0;
        for (int i = 0; i < list.size(); i++) {
            sumGet += list.get(i);
        }
        long endGet = System.currentTimeMillis();
        System.out.println("get(index) traversal time: " + (endGet - startGet) + " ms");

        // Verify correctness
        if (sumIterator != sumGet) {
            System.out.println("Error: sums do not match!");
        } else {
            System.out.println("Traversal sums match: " + sumIterator);
        }

        System.out.println("--------------------------------------------------");

        
    }
}
