package controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import application.SqliteConnection;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Vehicule;

public class AjouterMoto implements Initializable {
	@FXML private Button add;
	@FXML private TextField fieldImmatriculation ;
	@FXML private DatePicker fieldEntree ;
	@FXML private DatePicker fieldSortie ;
	@FXML private TextField fieldMarque ;
	@FXML private TextField fieldModele ;
	@FXML private ComboBox<String> comboetat;
	@FXML private ComboBox<String> assurance;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		comboetat.getItems().add("En panne");
		comboetat.getItems().add("Disponible");
		
		assurance.getItems().add("Oui");
		assurance.getItems().add("Non");


	}
	public void addMoto(ActionEvent e) throws SQLException{
		Stage s = (Stage) add.getScene().getWindow();
		Connection connection = SqliteConnection.connector();

		 String s1 = new String(fieldImmatriculation.getText());
		 System.out.println(comboetat.getSelectionModel().getSelectedItem());
		 String s2 = new String(fieldEntree.getValue().toString());
		 String s3 = new String(fieldSortie.getValue().toString());
		 String s4 = new String(fieldMarque.getText());System.out.println("1");
		 String s5 = new String(fieldModele.getText());System.out.println("2");
		 String s7 = new String(comboetat.getSelectionModel().getSelectedItem());
		String query = "INSERT INTO Vehicule VALUES('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','','"+s7+"')";
		System.out.println(connection.createStatement().executeUpdate(query));
		s.close();



	}



}
