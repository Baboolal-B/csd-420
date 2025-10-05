/*
BaboolalFanAppTest.java
10/05/2025
This program tests BaboolalFanApp.java.
*/
import java.sql.*;

public class BaboolalFanAppTest {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/databasedb";
    private static final String DB_USER = "student1";
    private static final String DB_PASS = "pass";

    public static void main(String[] args) {
        testDisplayRecord();
        testUpdateRecord();
    }

    public static void testDisplayRecord() {
        System.out.println("Running testDisplayRecord...");
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM fans WHERE ID = ?");
            stmt.setInt(1, 1);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String first = rs.getString("firstname");
                String last = rs.getString("lastname");
                String team = rs.getString("favoriteteam");

                System.out.println("Record found: " + first + " " + last + ", Team: " + team);

                if (!first.equals("Alice") || !last.equals("Smith") || !team.equals("Yankees")) {
                    System.out.println("ERROR: Record values do not match expected.");
                } else {
                    System.out.println("Display test passed!");
                }
            } else {
                System.out.println("ERROR: No record found with ID=1.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void testUpdateRecord() {
        System.out.println("\nRunning testUpdateRecord...");
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {

            // Update record
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE fans SET favoriteteam=? WHERE ID=?");
            stmt.setString(1, "Red Sox");
            stmt.setInt(2, 1);
            int rows = stmt.executeUpdate();
            System.out.println("Rows updated: " + rows);

            // Verify update
            stmt = conn.prepareStatement("SELECT favoriteteam FROM fans WHERE ID=?");
            stmt.setInt(1, 1);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String team = rs.getString("favoriteteam");
                System.out.println("Updated team: " + team);
                if (!team.equals("Red Sox")) {
                    System.out.println("ERROR: Update failed!");
                } else {
                    System.out.println("Update test passed!");
                }
            }

            // Reset original value
            stmt = conn.prepareStatement("UPDATE fans SET favoriteteam=? WHERE ID=?");
            stmt.setString(1, "Yankees");
            stmt.setInt(2, 1);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
