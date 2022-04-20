package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

public class MyTableModel implements Initializable {
	Carte c;
	ObservableList<Station> list;
	
	@FXML
	Label date, veloDispo, nbAcces, etatStation, attachDispo, carteDispo, adresse;
	@FXML
	TableColumn<Station, String> numeroStation, adresseStat, carteDispoStat, ouvert;
	@FXML
	TableView<Station> tableView;
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		c = JPasserelle.getCarte();
		numeroStation.setCellValueFactory(new PropertyValueFactory<>("numero"));
		adresseStat.setCellValueFactory(new PropertyValueFactory<>("adresse"));
		carteDispoStat.setCellValueFactory(new PropertyValueFactory<>("carteDispo"));
		ouvert.setCellValueFactory(new PropertyValueFactory<>("ouvert"));
		
		ObservableList<Station> list = getLesStations();
		tableView.setItems(list);
	}
	
	private ObservableList<Station>getLesStations() {
		list = FXCollections.observableArrayList(c.getTheStations());
		return list;
	}
	
	@FXML
	private void changerArr(ActionEvent e) {
		ArrayList<Station>list_diff = new ArrayList<>();
		list.clear();
		RadioButton radioChoose = (RadioButton) e.getSource();
		
		for(Station s : c.getTheStations()) {
			if(s.getArrondissement().equals(radioChoose.getText())) {
				list_diff.add(s);
			}
		}
		
		list = FXCollections.observableArrayList(list_diff);
		tableView.setItems(list);
	}
	
	@FXML
	private void modifDispo() {
		adresse.setText(tableView.getSelectionModel().getSelectedItem().getNom());
		date.setText("Le : " + String.valueOf(tableView.getSelectionModel().getSelectedItem().getDate()));
		veloDispo.setText("Vélos Disponibles : " + String.valueOf(tableView.getSelectionModel().getSelectedItem().getVDispo()));
		nbAcces.setText("Nombre Total Attaches : " + String.valueOf(tableView.getSelectionModel().getSelectedItem().getCapacite()));
		etatStation.setText("Station Ouvertes : " + tableView.getSelectionModel().getSelectedItem().getOuvert());
		attachDispo.setText("Nombres Attaches Disponibles : " + String.valueOf(tableView.getSelectionModel().getSelectedItem().getEmplacement()));
		carteDispo.setText("Station Paiment CB : " + tableView.getSelectionModel().getSelectedItem().getCardDisp());
		
		if(tableView.getSelectionModel().getSelectedItem().getOuvert().equals("OUI")) {
			etatStation.setTextFill(Color.color(0, 1, 0));
		} else {
			etatStation.setTextFill(Color.color(1, 0, 0));
		}
	}
}
