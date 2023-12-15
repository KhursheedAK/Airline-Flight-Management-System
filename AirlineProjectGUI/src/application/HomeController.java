package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HomeController 
{
	@FXML
	Main main = new Main();
	
	@FXML
	public ImageView image1 = new ImageView("C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\1.jpg");
	
	@FXML
	public Button customerMode;
	
	@FXML
	public Button adminMode;
	
	@FXML
	public URL location;
	
	@FXML
	public ResourceBundle resources;
	
	@FXML
	public void initialize()
	{
		image1.getImage();
	}
	
	public HomeController()
	{
		
	}
	
	@FXML
	public void goToCustomerLoginSignupMenu(ActionEvent event) throws IOException 
	{
		System.out.println("In Customer Login Signup Menu!");
		customerMode.setText("You just clicked me!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToCustomerLoginSignupMenu(stage); 
	}
	
	@FXML
	public void goToAdminMode(ActionEvent event) throws IOException 
	{
		System.out.println("In Administrator Mode!");
		adminMode.setText("You just clicked me!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToAdminLoginSignupMenu(stage);
	}
	
}
