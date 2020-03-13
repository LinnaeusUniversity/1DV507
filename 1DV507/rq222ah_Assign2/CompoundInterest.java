package rq222ah_Assign2;

import javafx.application.Application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CompoundInterest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Grid Pane layout
		GridPane N = new GridPane();
		N.setAlignment(Pos.CENTER);

		// Adding the header
		Text txt = new Text("Compound Interest");
		txt.setFont(Font.font(30));
		N.add(txt, 0, 0, 2, 1);

		// Add the labels and textfields
		N.add(new Label("StartAmount:"), 0, 1);
		final TextField startAmount = new TextField();
		N.add(startAmount, 1, 1);

		N.add(new Label("Interest:"), 0, 2);
		final TextField interest = new TextField();
		N.add(interest, 1, 2);

		N.add(new Label("Number of Years: "), 0, 3);
		final TextField year = new TextField();
		N.add(year, 1, 3);

		// Add a button
		Button calc = new Button("Calculate");
		N.add(calc, 0, 4);

		N.add(new Label("In total that will be "), 0, 5);

		Label result = new Label();

		// set event for the button
		calc.setOnAction(event -> {
			// Throws a exception if the values is not valid
			try {
				double amount = Double.parseDouble(startAmount.getText());
				double rate = Double.parseDouble(interest.getText());
				int years = Integer.parseInt(year.getText());
				Double sum = calculate(amount, rate, years);
				String str = String.valueOf(sum);
				result.setText(str);
			} catch (NumberFormatException e) {
				result.setText("Not a valid value");
			}
		});
		// Add the result
		N.add(result, 1, 5);

		// Creating the scene
		Scene scene = new Scene(N);

		// Setting up the Stage
		primaryStage.setTitle("Compound Interest");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	/**
	 * Calculate the Compound Interest
	 * 
	 * @param s - starting amount
	 * @param i - the interest
	 * @param y - years
	 * @return - the total sum
	 */
	public static double calculate(double s, double i, int y) {
		double sum = 0;
		double startSum = s;
		double interest = i;
		int years = y;

		sum = startSum * Math.pow(1 + (interest / 100), years);

		return (int) sum;
	}

	public static void main(String[] args) {
		launch(args);

	}
}