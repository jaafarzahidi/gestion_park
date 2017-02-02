package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import controllers.AjouterVehicule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Vehicule;

public class AccueilController implements Initializable{
	@FXML private Button logout;
	@FXML private TableView<Vehicule> tableVehicule;
	@FXML private TableColumn<Vehicule , String > colimmatriculation;
	@FXML private TableColumn<Vehicule , String > coldateEntree;
	@FXML private TableColumn<Vehicule , String > coldateSortie;
	@FXML private TableColumn<Vehicule , String > colmarque;
	@FXML private TableColumn<Vehicule , String > colmodele;
	@FXML private TableColumn<Vehicule , String > colcarburant;
	@FXML private TableColumn<Vehicule , String > coletat;

	@FXML private Button load;
	@FXML private Button addVehicule;


	private ObservableList<Vehicule>data;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	public void logout(ActionEvent event){
		try{
			Stage st= null;
			st = (Stage) logout.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/view/Login.fxml").openStream());
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			st.setScene(scene);
			st.show();

		}catch (Exception e){
			e.printStackTrace();
		}


	}
	public void loadData(ActionEvent event){
		try{
			Connection connection = SqliteConnection.connector();
			if(connection == null) System.out.println("erreur de connexion");
			data = FXCollections.observableArrayList();
			ResultSet res = connection.createStatement().executeQuery("select * from Vehicule");
			while(res.next()){
				data.add(new Vehicule(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5),res.getString(6), res.getString(7)));
			}
		}catch(SQLException e){
			System.out.println(e);
		}
		colimmatriculation.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("immatriculation"));
		coldateEntree.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("dateEntreeParc"));

		coldateSortie.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("dateSortieParc"));

		colmarque.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("marque"));

		colmodele.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("modele"));

		colcarburant.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("carburant"));

		coletat.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("etat"));

		tableVehicule.setItems(null);
		tableVehicule.setItems(data);


	}
	public void ajouterVehicule() throws Exception{
		Stage st = new Stage();
		Parent rt = FXMLLoader.load(getClass().getResource("/view/popUpAjouterVehicule.fxml"));
		Scene scene = new Scene(rt);
		st.setScene(scene);
		st.initModality(Modality.APPLICATION_MODAL);
		st.initOwner(addVehicule.getScene().getWindow());
		st.show();

	}
}
