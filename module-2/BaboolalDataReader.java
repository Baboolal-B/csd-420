/*
BaboolalCards.java
08/24/2025
This program reads the contents of BrijetteDatafile.dat and displays it on the console.
*/

import java.io.*;

public class BaboolalDataReader {
    public static void main(String[] args) {
        String filename = "BaboolalDatafile.dat";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Contents of " + filename + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
