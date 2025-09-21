/*
BaboolalFourCircles.java
09/20/2025
This program creates a JavaFX window that displays four 
circles side by side. It applies styles from an external 
CSS file so that two circles appear white with black outlines, 
one is red, and one is green.
*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class BaboolalFourCircles extends Application {

    @Override
    public void start(Stage primaryStage) {

        // left vertical box with border and one circle inside
        Circle leftCircle = new Circle(40);
        leftCircle.getStyleClass().add("plaincircle");

        VBox leftBox = new VBox(leftCircle);
        leftBox.getStyleClass().add("border");   // black rectangle border
        leftBox.setSpacing(20);
        leftBox.setMinSize(100,200);             // give it some height/width

        // three circles on the right
        Circle c2 = new Circle(40);
        Circle c3 = new Circle(40);
        Circle c4 = new Circle(40);

        c2.getStyleClass().add("plaincircle");
        c3.getStyleClass().add("plaincircle");
        c4.getStyleClass().add("plaincircle");

        c3.setId("redcircle");
        c4.setId("greencircle");

        HBox rightBox = new HBox(20, c2, c3, c4);
        rightBox.setSpacing(20);

        // place leftBox and rightBox side-by-side
        HBox root = new HBox(20, leftBox, rightBox);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("mystyle.css").toExternalForm());

        primaryStage.setTitle("Exercise31_01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
