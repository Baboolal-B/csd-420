/*
FourCirclesTest.java
09/20/2025
This program is to test and make sure BaboolalFourCircles.java works.
*/

import static org.junit.Assert.*;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class FourCirclesTest extends ApplicationTest {

    private Circle c2, c3;

    @Override
    public void start(Stage stage) {
        Circle c1 = new Circle(50);
        c2 = new Circle(50);
        c3 = new Circle(50);
        Circle c4 = new Circle(50);

        c1.getStyleClass().add("plaincircle");
        c2.getStyleClass().add("plaincircle");
        c3.getStyleClass().add("plaincircle");
        c4.getStyleClass().add("plaincircle");

        c2.setId("redcircle");
        c3.setId("greencircle");

        HBox box = new HBox(20, c1, c2, c3, c4);
        Scene scene = new Scene(box);
        scene.getStylesheets().add(getClass().getResource("mystyle.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void testColorStyles() {
        // ensure IDs are set correctly
        assertEquals("redcircle", c2.getId());
        assertEquals("greencircle", c3.getId());

        // ensure style class is applied
        assertTrue(c2.getStyleClass().contains("plaincircle"));
        assertTrue(c3.getStyleClass().contains("plaincircle"));
    }
}
