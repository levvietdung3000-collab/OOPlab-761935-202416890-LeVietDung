package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraserRadioButton;

    @FXML
    private ToggleGroup toolsGroup;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // Prevent drawing outside the Pane boundaries
        if (event.getX() >= 0 && event.getX() <= drawingAreaPane.getWidth() &&
            event.getY() >= 0 && event.getY() <= drawingAreaPane.getHeight()) {
            
            Color brushColor = Color.BLACK;
            double radius = 4.0;
            
            if (eraserRadioButton.isSelected()) {
                brushColor = Color.WHITE;
                radius = 8.0; // Larger radius for eraser
            }
            
            Circle newCircle = new Circle(event.getX(), event.getY(), radius, brushColor);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }
}
