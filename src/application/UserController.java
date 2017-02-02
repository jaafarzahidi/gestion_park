package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class UserController implements Initializable {
	@FXML JFXPopup nouveau ;
	@FXML Button but ;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	public void m(){
		nouveau.show(PopupVPosition.TOP, PopupHPosition.LEFT);

	}


}
