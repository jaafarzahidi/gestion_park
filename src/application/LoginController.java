package application;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController implements Initializable{
	public LoginModel loginModel = new LoginModel();

	@FXML
	private Label isConnected;
	@FXML
	private TextField txtUserName ;
	@FXML
	private PasswordField motDePasse;
	@FXML
	private Button auth ;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		if(loginModel.isDatabaseConnected()){
			//isConnected.setText("connected");
			System.out.println("connected");
		}else {
			//isConnected.setText("not connected");
			System.out.println("not connected");
		}

	}
	public void login(ActionEvent event){
		try{
			if(loginModel.isLogin(txtUserName.getText(), motDePasse.getText())){
				isConnected.setText("your are logged in !");
				Stage primaryStage = null;
				primaryStage = (Stage) auth.getScene().getWindow();
				FXMLLoader loader = new FXMLLoader();
				Pane root = loader.load(getClass().getResource("/view/Accueil.fxml").openStream());
				System.out.println("heeere");

				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			}else{
				isConnected.setText("username or password is not correct !");

			}

		}catch(Exception e){
			e.printStackTrace();
			isConnected.setText("username or password is not correct");
		}
	}



}
