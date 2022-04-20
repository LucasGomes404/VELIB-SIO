package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FRMStation extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		// TODO Auto-generated method stub
		FXMLLoader fxmlloader = new FXMLLoader(FRMStation.class.getResource("Interface.fxml"));
		Scene scene = new Scene(fxmlloader.load(), 923, 731);
		stage.setTitle("Station Vélib Paris / Île de France");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}
