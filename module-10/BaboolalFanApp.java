/*
BaboolalFanApp.java
10/05/2025
This program is a JavaFX application that provides a graphical interface 
to view and update fan information stored in a MySQL database, allowing users 
to display a record by entering a fan ID and update its details. It connects to 
the database using JDBC, retrieves or modifies data in the fans table, and displays 
success or error messages through popup alerts.
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;

public class BaboolalFanApp extends Application {

    // Database credentials
    private final String DB_URL = "jdbc:mysql://localhost:3306/databasedb";
    private final String DB_USER = "student1";
    private final String DB_PASS = "pass";

    private TextField idField, firstField, lastField, teamField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Fan Information Manager");

        // GridPane layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        // Labels and TextFields
        grid.add(new Label("Fan ID:"), 0, 0);
        idField = new TextField();
        grid.add(idField, 1, 0);

        grid.add(new Label("First Name:"), 0, 1);
        firstField = new TextField();
        grid.add(firstField, 1, 1);

        grid.add(new Label("Last Name:"), 0, 2);
        lastField = new TextField();
        grid.add(lastField, 1, 2);

        grid.add(new Label("Favorite Team:"), 0, 3);
        teamField = new TextField();
        grid.add(teamField, 1, 3);

        // Buttons
        Button displayBtn = new Button("Display");
        Button updateBtn = new Button("Update");
        grid.add(displayBtn, 0, 4);
        grid.add(updateBtn, 1, 4);

        // Button actions
        displayBtn.setOnAction(e -> displayRecord());
        updateBtn.setOnAction(e -> updateRecord());

        // Scene setup
        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    private void displayRecord() {
        String idText = idField.getText().trim();
        if (!idText.matches("\\d+")) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "ID must be a numeric value.");
            return;
        }

        try (Connection conn = getConnection()) {
            String sql = "SELECT firstname, lastname, favoriteteam FROM fans WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(idText));

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                firstField.setText(rs.getString("firstname"));
                lastField.setText(rs.getString("lastname"));
                teamField.setText(rs.getString("favoriteteam"));
            } else {
                showAlert(Alert.AlertType.INFORMATION, "Not Found", "No record found for ID " + idText);
            }

        } catch (SQLException ex) {
            showAlert(Alert.AlertType.ERROR, "Database Error", ex.getMessage());
        }
    }

    private void updateRecord() {
        String idText = idField.getText().trim();
        String first = firstField.getText().trim();
        String last = lastField.getText().trim();
        String team = teamField.getText().trim();

        if (!idText.matches("\\d+")) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "ID must be a numeric value.");
            return;
        }

        try (Connection conn = getConnection()) {
            String sql = "UPDATE fans SET firstname=?, lastname=?, favoriteteam=? WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, first);
            stmt.setString(2, last);
            stmt.setString(3, team);
            stmt.setInt(4, Integer.parseInt(idText));

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Record updated successfully.");
            } else {
                showAlert(Alert.AlertType.INFORMATION, "Not Found", "No record found for ID " + idText);
            }

        } catch (SQLException ex) {
            showAlert(Alert.AlertType.ERROR, "Database Error", ex.getMessage());
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
