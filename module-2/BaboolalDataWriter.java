/*
BaboolalCards.java
08/24/2025
This program generates random data and stores it in a file named BrijetteDatafile.dat.
*/
import java.io.*;
import java.util.Random;

public class BaboolalDataWriter {
    public static void main(String[] args) {
        Random rand = new Random();

        // Arrays of random integers and doubles
        int[] intArray = new int[5];
        double[] doubleArray = new double[5];

        for (int i = 0; i < 5; i++) {
            intArray[i] = rand.nextInt(100); // random integer 0-99
            doubleArray[i] = rand.nextDouble() * 100; // random double 0.0-99.9
        }

        // File name
        String filename = "BaboolalDatafile.dat";

        // Writing to file (append mode)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("Integers: ");
            for (int num : intArray) {
                writer.write(num + " ");
            }
            writer.newLine();

            writer.write("Doubles: ");
            for (double num : doubleArray) {
                writer.write(String.format("%.2f ", num));
            }
            writer.newLine();

            writer.write("-----"); // separator for readability
            writer.newLine();

            System.out.println("Data written to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
