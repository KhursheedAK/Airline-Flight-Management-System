package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CustomerLoginSignupMenuController 
{
	@FXML
	Main main = new Main();
	
	@FXML
	public ImageView customerImage = new ImageView("C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\9.png");
	
	@FXML
	public Button login_Button;
	
	@FXML
	public Button signup_Button;
	
	@FXML
	public Button homeMenu;
	
	@FXML
	public URL location;
	
	@FXML
	public ResourceBundle resources;
	
	@FXML
	public void initialize()
	{
		customerImage.getImage();
	}
	
	public CustomerLoginSignupMenuController()
	{
		
	}
	
	@FXML
	public void goToHomeMenu(ActionEvent event) throws IOException
	{
		System.out.println("In Home Menu!");
		homeMenu.setText("You just clicked me!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToHomeMenu(stage);
	}
	
	@FXML
	public void goToCustomerLogin(ActionEvent event) throws IOException
	{
		System.out.println("In Customer Login Menu!");
		homeMenu.setText("You just clicked me!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToCustomerLogin(stage);
	}
	
	@FXML
	public void goToCustomerSignup(ActionEvent event) throws IOException
	{
		System.out.println("In Customer Signup Menu!");
		homeMenu.setText("You just clicked me!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToCustomerSignup(stage);
	}
	
}
