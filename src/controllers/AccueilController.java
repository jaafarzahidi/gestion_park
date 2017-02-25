package controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import application.SqliteConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Camion;
import model.Moto;
import model.Vehicule;
import model.Voiture;

public class AccueilController implements Initializable{
	@FXML private Button buttonLogout;
	@FXML private TableView<Vehicule> tableVehicule;
	@FXML private TableColumn<Vehicule , String > colimmatriculation;
	@FXML private TableColumn<Vehicule , String > coldateEntree;
	@FXML private TableColumn<Vehicule , String > coldateSortie;
	@FXML private TableColumn<Vehicule , String > colmarque;
	@FXML private TableColumn<Vehicule , String > colmodele;
	@FXML private TableColumn<Vehicule , String > colcarburant;
	@FXML private TableColumn<Vehicule , String > coletat;


	@FXML private Button buttonLoad;
	@FXML private Button buttonAddVehicule;
	@FXML private Button ac;
	@FXML private Button e;



	private ObservableList<Vehicule>data;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	public void logout(ActionEvent event){
		try{
			Stage st= null;
			st = (Stage) buttonLogout.getScene().getWindow();
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
				if(res.getString(15)=="Moto")
				{
					data.add(new Moto(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5),res.getString(6), res.getString(7), res.getDouble(8), res.getLong(9), res.getDouble(10), res.getInt(11)));
				}
				else if(res.getString(15)=="Voiture")
				{
					data.add(new Voiture(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5),res.getString(6), res.getString(7), res.getDouble(8), res.getLong(9), res.getDouble(10), res.getInt(11), res.getString(12), res.getInt(13)));
				}
				else
				{
					data.add(new Camion(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5),res.getString(6), res.getString(7), res.getDouble(8), res.getLong(9), res.getDouble(10), res.getInt(11), res.getString(12), res.getInt(13),res.getInt(14)));
				}
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

		Parent rt = FXMLLoader.load(getClass().getResource("/view/ChoixType.fxml"));
		Scene scene = new Scene(rt);
		st.setScene(scene);

		st.initModality(Modality.APPLICATION_MODAL);
		st.initOwner(buttonAddVehicule.getScene().getWindow());
		st.show();

	}
	public void meth() throws Exception{
		Stage st = new Stage();

		Parent rt = FXMLLoader.load(getClass().getResource("/view/PanelAcceuil.fxml"));
		Scene scene = new Scene(rt);
		st.setScene(scene);


		st.show();

	}
	public void exporter(){
		try{
			String query = "select * from Vehicule";
			Connection connection = SqliteConnection.connector();
			ResultSet rs = connection.createStatement().executeQuery(query);

			XSSFWorkbook wk = new XSSFWorkbook();
			XSSFSheet sheet = wk.createSheet("User Details");
			XSSFRow header = sheet.createRow(0);
			header.createCell(0).setCellValue("marque");
			header.createCell(1).setCellValue("immatriculation");
			header.createCell(2).setCellValue("carburant");

			int index = 1 ;
			while(rs.next()){
				XSSFRow row = sheet.createRow(index);
				row.createCell(0).setCellValue(rs.getString("marque"));
				row.createCell(1).setCellValue(rs.getString("immatriculation"));
				row.createCell(2).setCellValue(rs.getString("carburant"));
				index++;
			}
			FileOutputStream fileout = new FileOutputStream("UserDetails.xlsx");
			wk.write(fileout);
			fileout.close();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText(null);
			alert.setContentText("c'est fait !!");

		}catch(Exception e){
			e.printStackTrace();
		}



	}
}
