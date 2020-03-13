package rq222ah_Assign2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Snowman extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		// Creating the different shapes, and set the size,color etc
		Rectangle sky = new Rectangle(0, 0, 700, 360);
		sky.setFill(Color.DEEPSKYBLUE);

		Circle sun = new Circle(590, 86, 52);
		sun.setFill(Color.YELLOW);

		Circle head = new Circle(350, 155, 28);
		head.setFill(Color.WHITE);

		Circle middle = new Circle(350, 220, 45);
		middle.setFill(Color.WHITE);

		Circle bottom = new Circle(350, 310, 65);
		bottom.setFill(Color.WHITE);

		Circle button1 = new Circle(350, 235, 5);
		Circle button2 = new Circle(350, 215, 5);
		Circle button3 = new Circle(350, 195, 5);

		Line mouth = new Line(336, 166, 364, 166);
		mouth.setStroke(Color.BLACK);

		Circle eye1 = new Circle(336, 150, 5);
		Circle eye2 = new Circle(364, 150, 5);

		// Create the root and add all nodes
		Group root = new Group();
		root.getChildren().addAll(sky, sun, bottom, middle, head, button1, button2, button3, mouth, eye1, eye2);

		// Create the scene
		Scene scene = new Scene(root, 700, 500);

		// Setting up the stage
		primaryStage.setTitle("Snowman");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}