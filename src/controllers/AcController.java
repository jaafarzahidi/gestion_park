package controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import application.SqliteConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AcController implements Initializable {
	@FXML private Label lab1 ;
	@FXML private Label lab2 ;
	@FXML private Label lab3 ;
	@FXML private Label lab4 ;
	@FXML private Label lab5 ;
	@FXML private Button buttonLogout;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Connection connection = SqliteConnection.connector();
		try{
			String query = "SELECT COUNT(*) FROM Vehicule" ;
			String query1 = "SELECT SUM(kilometrage) FROM Vehicule" ;
			String query2 = "SELECT SUM(consommation) FROM Vehicule" ;
			String query3 = "SELECT SUM(kilometrage) FROM Vehicule" ;
			String query4 = "SELECT SUM(kilometrage) FROM Vehicule" ;


			Statement st = connection.createStatement();
			ResultSet res = st.executeQuery(query);

			long nombreDeVehicule = res.getInt(1);
			long kilometrage = (long) (res.getLong(1)/nombreDeVehicule);

			lab2.setText(nombreDeVehicule+"km");

		}catch(SQLException e){
			e.printStackTrace();
		}

	}


}
