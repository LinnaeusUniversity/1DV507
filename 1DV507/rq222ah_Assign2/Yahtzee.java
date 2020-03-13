package rq222ah_Assign2;

import java.io.FileInputStream;
import java.util.Random;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Yahtzee extends Application {
	Image images[];
	ImageView imageViews[];
	Button rollAgainButton;
	int rollCounter = 0;
	CheckBox checkBox[] = new CheckBox[5];
	Text prompt = new Text();
	Text pair = new Text();
	Text threeAKind = new Text();
	Text fourAKind = new Text();
	Text yahtzee = new Text();
	Text straight = new Text();

	public void setupDiceImages() throws Exception {
		images = new Image[6];
		images[0] = new Image(new FileInputStream("C:\\Users\\MY PC\\Pictures\\Dice1.PNG"));
		images[1] = new Image(new FileInputStream("C:\\Users\\MY PC\\Pictures\\Dice2.PNG"));
		images[2] = new Image(new FileInputStream("C:\\Users\\MY PC\\Pictures\\Dice3.PNG"));
		images[3] = new Image(new FileInputStream("C:\\Users\\MY PC\\Pictures\\Dice4.PNG"));
		images[4] = new Image(new FileInputStream("C:\\Users\\MY PC\\Pictures\\Dice5.PNG"));
		images[5] = new Image(new FileInputStream("C:\\Users\\MY PC\\Pictures\\Dice6.PNG"));
		for (int i = 0; i < checkBox.length; i++) {
			checkBox[i] = new CheckBox();
		}
	}

	public void roll() {
		Random random = new Random();
		for (int i = 0; i < imageViews.length; i++) {
			if (!checkBox[i].isSelected()) {
				int index = random.nextInt(6);
				imageViews[i].setImage(images[index]);
			}
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Text titleText = new Text("Yahtzeee!");
		titleText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 45));
		titleText.setLayoutY(50);

		setupDiceImages();
		imageViews = new ImageView[5];
		rollAgainButton = new Button("Roll the Dice!");
		rollAgainButton.setLayoutX(20);
		rollAgainButton.setLayoutY(320);

		for (int i = 0; i < imageViews.length; i++) {
			imageViews[i] = new ImageView();
			imageViews[i].setFitHeight(150);
			imageViews[i].setFitWidth(150);
		}

		HBox hBox = new HBox(imageViews);
		hBox.setLayoutY(100);
		for (int i = 0; i < checkBox.length; i++) {
			checkBox[i].setUserData(images[i]);
		}

		for (int j = 0; j < checkBox.length; j++) {
			checkBox[j].setLayoutX(58 * (3 * j));
			checkBox[j].setLayoutY(270);
		}

		EventHandler<MouseEvent> clickRollAgainButton = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (rollCounter < 3) {
					roll();
					rollCounter++;
					prompt.setText("You have " + (3 - rollCounter) + " roll(s) left!");
					prompt.setLayoutX(150);
					prompt.setLayoutY(340);
				}
				if (rollCounter == 3) {
					if (imageViews[0].getImage() == imageViews[1].getImage()
							|| imageViews[1].getImage() == imageViews[2].getImage()
							|| imageViews[2].getImage() == imageViews[3].getImage()
							|| imageViews[3].getImage() == imageViews[4].getImage()) {
						pair.setText("Pair");
						pair.setLayoutX(150);
						pair.setLayoutY(360);

					}
					if ((imageViews[0].getImage() == imageViews[1].getImage()
							&& (imageViews[0].getImage() == imageViews[2].getImage()
									|| imageViews[1].getImage() == imageViews[2].getImage()))
							|| (imageViews[1].getImage() == imageViews[2].getImage()
									&& (imageViews[1].getImage() == imageViews[3].getImage()
											|| imageViews[2].getImage() == imageViews[3].getImage()))
							|| (imageViews[2].getImage() == imageViews[3].getImage()
									&& (imageViews[2].getImage() == imageViews[4].getImage()
											|| imageViews[3].getImage() == imageViews[4].getImage()))) {
						threeAKind.setText("Full House");
						threeAKind.setLayoutX(150);
						threeAKind.setLayoutY(360);
					}
					if ((imageViews[0].getImage() == imageViews[1].getImage()
							&& (imageViews[0].getImage() == imageViews[2].getImage()
									&& imageViews[0].getImage() == imageViews[3].getImage())
							|| (imageViews[1].getImage() == imageViews[2].getImage()
									&& imageViews[1].getImage() == imageViews[3].getImage()
									&& imageViews[1].getImage() == imageViews[4].getImage()))) {
						fourAKind.setText("Four of a kind!");
						fourAKind.setLayoutX(150);
						fourAKind.setLayoutY(360);
					}
					if ((imageViews[0].getImage() == imageViews[1].getImage()
							&& (imageViews[0].getImage() == imageViews[2].getImage()
									&& imageViews[0].getImage() == imageViews[3].getImage()
									&& imageViews[0].getImage() == imageViews[4].getImage()))) {
						yahtzee.setText("Three of a kind!");
						yahtzee.setLayoutX(150);
						yahtzee.setLayoutY(360);
					}
				} else {
					straight.setText("Straight");
					straight.setLayoutX(150);
					straight.setLayoutY(360);
				}

			}
		};

		rollAgainButton.addEventHandler(MouseEvent.MOUSE_CLICKED, clickRollAgainButton);
		Pane root = new Pane(hBox);
		root.getChildren().add(titleText);
		root.getChildren().add(rollAgainButton);
		root.getChildren().add(prompt);
		for (int i = 0; i < checkBox.length; i++) {
			root.getChildren().add(checkBox[i]);
		}
		root.getChildren().addAll(pair, threeAKind, fourAKind, yahtzee);
		Scene scene = new Scene(root, 800, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Yahtzee");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
