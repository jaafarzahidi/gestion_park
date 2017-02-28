package controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import application.SqliteConnection;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class AcController implements Initializable {
	@FXML private Label lab1 ;
	@FXML private Label lab2 ;
	@FXML private Label lab3 ;
	@FXML private Label lab4 ;
	@FXML private Label lab5 ;
	@FXML private Label lab6 ;

	@FXML private Label lab41 ;
	@FXML private Label lab42 ;
	@FXML private Label lab43 ;

	@FXML private Label lab51 ;
	@FXML private Label lab52 ;
	@FXML private Label lab53 ;

	@FXML private Label lab61 ;
	@FXML private Label lab62 ;
	@FXML private Label lab63 ;

	@FXML private Button Ajouter;
	public double res1;
	public double res2;
	public double res3;
	public int res4 ;
	public int res5 ;
	public int res6 ;
	public int res41;
	public int res42;
	public int res43;
	public int res51;
	public int res52;
	public int res53;
	public int res61;
	public int res62;
	public int res63;





	@Override
	public void initialize(URL location, ResourceBundle resources) {



		try{
			Connection connection = SqliteConnection.connector();
			String query1 = "select avg(age) from vehicule" ;
			String query2 = "select avg(consommation) from vehicule" ;
			String query3 = "select avg(kilometrage) from vehicule" ;

			String query4 = "select count(immatriculation) from vehicule" ;
			String query41 = "select count(immatriculation) from vehicule where type='Voiture' " ;
			String query42 = "select count(immatriculation) from vehicule where type='Camion' " ;
			String query43 = "select count(immatriculation) from vehicule where type='Moto' " ;



			String query5 = "select count(immatriculation) from vehicule where etat='En panne'" ;
			String query51 = "select count(immatriculation) from vehicule where etat='En panne' and type='Voiture' " ;
			String query52 = "select count(immatriculation) from vehicule where etat='En panne' and type='Camion' " ;
			String query53 = "select count(immatriculation) from vehicule where etat='En panne' and type='Moto' " ;


			String query6 = "select count(immatriculation) from vehicule" ;
			String query61 = "select count(immatriculation) from vehicule where type='Voiture' " ;
			String query62 = "select count(immatriculation) from vehicule where type='Camion' " ;
			String query63 = "select count(immatriculation) from vehicule where type='Moto' " ;

			Statement st = connection.createStatement();
			ResultSet res = st.executeQuery(query1);
			 res1 = res.getDouble(1);

			res = st.executeQuery(query2);
			 res2 = res.getDouble(1);

			res = st.executeQuery(query3);
			res3 = res.getDouble(1);

			res = st.executeQuery(query4);
			res4 = res.getInt(1);

			res = st.executeQuery(query41);
			res41 = res.getInt(1);
			res42 = st.executeQuery(query42).getInt(1);
			res43 = st.executeQuery(query43).getInt(1);

			res = st.executeQuery(query51);
			res51 = res.getInt(1);
			res52 = st.executeQuery(query52).getInt(1);
			res53 = st.executeQuery(query53).getInt(1);

			res = st.executeQuery(query61);
			res61 = res.getInt(1);
			res62 = st.executeQuery(query62).getInt(1);
			res63 = st.executeQuery(query63).getInt(1);






		}catch(SQLException e){
			e.printStackTrace();
		}


		 Task <Void> task = new Task<Void>() {
		      @Override
		      public Void call() throws InterruptedException {
		        // "message2" time consuming method (this message will be seen).
		    	  for(int i = 0 ; i < res3 ; i+=1){
		    		   updateMessage(String.valueOf(i));
				        Thread.sleep(2);
		    	  }




		        return null;
		      }
		    };

		    lab3.textProperty().bind(task.messageProperty());

		    // java 8 construct, replace with java 7 code if using java 7.
		    task.setOnSucceeded(e -> {
		      lab3.textProperty().unbind();
		      // this message will be seen.
		      lab3.setText(String.valueOf(res3));
		    });

		    Thread thread = new Thread(task);
		    thread.setDaemon(true);
		    thread.start();
		    lab1.setText(String.valueOf(res1));
		    lab2.setText(String.valueOf(res2));
		    lab4.setText(String.valueOf(res4));
		    lab41.setText(String.valueOf(res41));
		    lab42.setText(String.valueOf(res42));
		    lab43.setText(String.valueOf(res43));

		    lab5.setText(String.valueOf(res5));
		    lab51.setText(String.valueOf(res51));
		    lab52.setText(String.valueOf(res52));
		    lab53.setText(String.valueOf(res53));

		    lab6.setText(String.valueOf(res6));
		    lab61.setText(String.valueOf(res61));
		    lab62.setText(String.valueOf(res62));
		    lab63.setText(String.valueOf(res63));



	}
	public void AjouterAction(){
		try{
			Stage primaryStage = null;
			primaryStage = (Stage) Ajouter.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/view/Accueil.fxml").openStream());
			System.out.println("heeere");

			Scene scene = new Scene(root);

			primaryStage.setScene(scene);
			primaryStage.show();

		}catch(Exception e){
			e.printStackTrace();
		}

	}


}
