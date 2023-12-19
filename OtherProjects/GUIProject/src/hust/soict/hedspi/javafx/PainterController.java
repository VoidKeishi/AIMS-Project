package hust.soict.hedspi.javafx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

	private Color brush;
    @FXML
    private ToggleGroup ToolOption;
    
    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle newCircle = new Circle(event.getX(),event.getY(),4,brush);
    	drawingAreaPane.getChildren().add(newCircle);
    }
    
    @FXML
    void penModeActivated(ActionEvent event) {
    	brush = Color.BLACK;
    }
    
    @FXML
    void eraserModeActivated(ActionEvent event) {
    	brush = Color.WHITE;
    }

}
