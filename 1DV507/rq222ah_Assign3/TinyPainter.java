package rq222ah_Assign3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TinyPainter extends Application {

	public void start(Stage primaryStage) {

		BorderPane pane = new BorderPane();

		// HBox for the menu
		HBox combo = new HBox();
		// First comboBox with the shapes(string) with default value "Line"
		ComboBox<String> shapes = new ComboBox<>();
		shapes.getItems().addAll("Line", "Dot", "Rectangle", "Circle");
		shapes.setValue("Line");
		// Second one with different sizes with default value 1.0
		ComboBox<Double> size = new ComboBox<>();
		size.getItems().addAll(1.0, 5.0, 10.0, 15.0, 20.0, 25.0, 30.0, 40.0);
		size.setValue(1.0);
		// The third will be the colorpicker with default color black
		ColorPicker cp = new ColorPicker(Color.BLACK);

		// Add them to the combo
		combo.getChildren().addAll(shapes, size, cp);

		// Create a canvas, to paint on
		Canvas canvas = new Canvas(700, 400);
		GraphicsContext gc;
		gc = canvas.getGraphicsContext2D();
		gc.setLineWidth(1);

		// Shapes-objects
		Rectangle rectangle = new Rectangle();
		Circle circle = new Circle();

		canvas.setOnMousePressed(e -> {
			if (shapes.getValue().equals("Line")) { // Check the active value from menu
				gc.setLineWidth(size.getValue());
				gc.setStroke(cp.getValue()); // Set the color
				gc.beginPath(); // Begin the drawing path
				gc.lineTo(e.getX(), e.getY()); // Get the coordinates
			}

			else if (shapes.getValue().equals("Dot")) {
				gc.setStroke(cp.getValue());
				gc.beginPath();
				gc.lineTo(e.getX(), e.getY());
				gc.setLineWidth(size.getValue()); // get the value from the menu
				gc.stroke(); // Make a dot on the canvas

			} else if (shapes.getValue().equals("Rectangle")) {
				gc.setStroke(cp.getValue()); // set color for stroke and fill
				gc.setFill(cp.getValue());
				rectangle.setX(e.getX()); // Get the current x and y value where rectangle are drawn
				rectangle.setY(e.getY());
			} else if (shapes.getValue().equals("Circle")) {
				gc.setStroke(cp.getValue());
				gc.setFill(cp.getValue());
				circle.setCenterX(e.getX()); // Get the center of the circle
				circle.setCenterY(e.getY());
			}
		});

		canvas.setOnMouseDragged(e -> {
			if (shapes.getValue().equals("Line")) {
				gc.lineTo(e.getX(), e.getY()); // Get the value while dragged
				gc.stroke(); // make the line or free drawing

			}
			if (shapes.getValue().equals("Rectangle")) {

				// Set the rectangle value with different from current x,y and the beginning
				// point
				rectangle.setWidth(e.getX() - rectangle.getX());
				rectangle.setHeight(e.getY() - rectangle.getY());

				// Drawing the rectangle with help of the GraphicsContext.methods fillRect and
				// strokeRect
				gc.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
				gc.strokeRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
			}

			// If i have the circle in setOnMouseDragged I will get a square in the upper
			// left quarter, I didnt find time to fix it

			if (shapes.getValue().equals("Circle")) {
				circle.setRadius((e.getX() - circle.getCenterX()) + e.getY() - circle.getCenterY() / 2);

				gc.fillOval(circle.getCenterX(), circle.getCenterY(), circle.getRadius(), circle.getRadius());
				gc.strokeOval(circle.getCenterX(), circle.getCenterY(), circle.getRadius(), circle.getRadius());
			}

		});

		canvas.setOnMouseReleased(e -> {
			if (shapes.getValue().equals("Line")) {
				gc.lineTo(e.getX(), e.getY());
				gc.stroke();
				gc.closePath(); // Close the path, so when u press the mouse a new line start not connected to
								// the other with happens if not closing the path
			}

		});

		pane.setTop(combo);
		pane.setCenter(canvas);

		Scene scene = new Scene(pane);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Tiny Painter");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}