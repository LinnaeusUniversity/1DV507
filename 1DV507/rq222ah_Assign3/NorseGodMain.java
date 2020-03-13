package rq222ah_Assign3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NorseGodMain extends Application {
	public static void main(String[] args) {
		launch();
	}

	public static String readFile(File f) throws IOException {
		BufferedReader FileReader = new BufferedReader(new FileReader(f));
		String Line;
		StringBuilder content = new StringBuilder();
		while ((Line = FileReader.readLine()) != null) {
			content.append(Line + "\n");
		}
		FileReader.close();
		return content.toString();
	}

	public void start(Stage basicStage) {
		ArrayList<NorseGod> GodList = new ArrayList<NorseGod>();
		try {// Setting the information from different file or path for the gods.
			NorseGod O = new NorseGod("Odin", " eller Odin", readFile(new File("C:/Users/MY PC/Desktop/odin.txt")));
			GodList.add(O);

			NorseGod T = new NorseGod("Thor", " Siv (Sif)", readFile(new File("C:/Users/MY PC/Desktop/thor.txt")));
			GodList.add(T);

			NorseGod L = new NorseGod("Loki", "Ginat", readFile(new File("C:/Users/MY PC/Desktop/loki.txt")));
			GodList.add(L);

			NorseGod B = new NorseGod("Balder", " isländska Baldur)",
					readFile(new File("C:/Users/MY PC/Desktop/balder.txt")));
			GodList.add(B);

			NorseGod F = new NorseGod("Freyr", "isländska. Freyr",
					readFile(new File("C:/Users/MY PC/Desktop/freyr.txt")));
			GodList.add(F);

			NorseGod Fr = new NorseGod("Freyja", "isländska/fornnordiska Freyja",
					readFile(new File("C:/Users/MY PC/Desktop/freyja.txt")));
			GodList.add(Fr);

			NorseGod He = new NorseGod("Heimdallr", "Aesir",
					readFile(new File("C:/Users/MY PC/Desktop/heimdallr.txt")));
			GodList.add(He);

			NorseGod Br = new NorseGod("Bragi", "vältalighetens gud i nordisk mytologi.",
					readFile(new File("C:/Users/MY PC/Desktop/bragi.txt")));
			GodList.add(Br);

			NorseGod Tyr = new NorseGod("Tyr", "en av asagudarna",
					readFile(new File("C:/Users/MY PC/Desktop/tyr.txt")));
			GodList.add(Tyr);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Set basic layout.
		Label lab = new Label("Norse gods and other Beings");
		lab.setTextAlignment(TextAlignment.CENTER);
		lab.setFont(Font.font("Helvetica", 15));
		lab.setStyle("-fx-font-weight: bold");

		GridPane G = new GridPane();
		G.setHgap(15);
		G.setVgap(0);
		G.setPadding(new Insets(5, 5, 5, 5));

		VBox BX = new VBox();
		BX.setSpacing(0);
		BX.setPadding(new Insets(0, 0, 8, 0));

		ScrollPane scrollBX = new ScrollPane();
		scrollBX.setPrefSize(400, 350);
		scrollBX.setFitToWidth(true);
		scrollBX.setFitToHeight(true);
		scrollBX.setVbarPolicy(ScrollBarPolicy.ALWAYS);

		// Setting the name list.
		ArrayList<String> Forname = new ArrayList<String>();
		for (int i = 0; i < GodList.size(); i++) {
			Forname.add(GodList.get(i).getName());
		}
		ListView<String> namelist = new ListView<String>();
		for (int i = 0; i < Forname.size(); i++) {
			namelist.getItems().add(Forname.get(i));
		}
		namelist.setMaxWidth(140);
		namelist.setMaxHeight(350);
		namelist.getSelectionModel().select(0);
		namelist.getFocusModel().focus(0);

		// Setting window for gods informations.
		Text N = new Text(GodList.get(namelist.getSelectionModel().getSelectedIndex()).getName());
		N.setFont(Font.font("Helvetica", 16));
		N.setStyle("-fx-font-weight: bold");
		Text R = new Text(GodList.get(namelist.getSelectionModel().getSelectedIndex()).getRace());
		R.setFont(Font.font("Helvetica", 12));
		R.setStyle("-fx-font-style: italic");
		Text tex = new Text(GodList.get(namelist.getSelectionModel().getSelectedIndex()).getDesc());
		tex.setFont(Font.font("Helvetica"));
		TextFlow TextF = new TextFlow();
		TextF.setPrefSize(GridPane.REMAINING, GridPane.REMAINING);
		TextF.getChildren().add(tex);

		// Update the action from user.
		namelist.getSelectionModel().selectedIndexProperty().addListener(contentUpdate -> {
			N.setText(GodList.get(namelist.getSelectionModel().getSelectedIndex()).getName());
			R.setText(GodList.get(namelist.getSelectionModel().getSelectedIndex()).getRace());
			tex.setText(GodList.get(namelist.getSelectionModel().getSelectedIndex()).getDesc());
		});

		scrollBX.setContent(TextF);
		BX.getChildren().addAll(N, R);
		G.add(lab, 0, 0, 2, 1);
		G.add(namelist, 0, 1, 1, 3);
		G.add(BX, 1, 1);
		G.add(scrollBX, 1, 2);

		// Setting and shows the window.
		Scene Sc = new Scene(G);
		basicStage.setTitle("Norse Gods");
		basicStage.setResizable(false);
		basicStage.setScene(Sc);
		basicStage.show();
	}
}