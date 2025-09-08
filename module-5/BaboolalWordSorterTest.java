/*
BaboolalWordSorterTest.java
09/06/2025
This program reads words from a text file, removes duplicates, 
and then displays the unique words in both ascending and descending 
alphabetical order. It also includes a simple test method to verify 
that the sorting and duplicate removal work correctly.
*/
import java.io.*;
import java.util.*;

public class BaboolalWordSorterTest {

    public static void main(String[] args) {
        String fileName = "collection_of_words.txt";

        // Read words from the file
        Set<String> words = readWordsFromFile(fileName);

        if (words.isEmpty()) {
            System.out.println("No words found in the file.");
            return;
        }

        // Ascending order
        System.out.println("Words in ascending order:");
        TreeSet<String> ascending = new TreeSet<>(words);
        for (String word : ascending) {
            System.out.println(word);
        }

        // Descending order
        System.out.println("\nWords in descending order:");
        TreeSet<String> descending = new TreeSet<>(Collections.reverseOrder());
        descending.addAll(words);
        for (String word : descending) {
            System.out.println(word);
        }

        // Run simple test
        runTests();
    }

    private static Set<String> readWordsFromFile(String fileName) {
        Set<String> words = new HashSet<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-z]", "");
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        return words;
    }

    // Simple test cases
    private static void runTests() {
        System.out.println("\nRunning test cases...");

        Set<String> testInput = new HashSet<>(Arrays.asList("apple", "banana", "pear", "banana", "apple"));
        TreeSet<String> ascending = new TreeSet<>(testInput);
        TreeSet<String> descending = new TreeSet<>(Collections.reverseOrder());
        descending.addAll(testInput);

        // Expected results
        List<String> expectedAsc = Arrays.asList("apple", "banana", "pear");
        List<String> expectedDesc = Arrays.asList("pear", "banana", "apple");

        boolean ascTest = new ArrayList<>(ascending).equals(expectedAsc);
        boolean descTest = new ArrayList<>(descending).equals(expectedDesc);

        if (ascTest && descTest) {
            System.out.println("Tests passed!");
        } else {
            System.out.println("Tests failed.");
            System.out.println("Got ascending: " + ascending);
            System.out.println("Got descending: " + descending);
        }
    }
}
