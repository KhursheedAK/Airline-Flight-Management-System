package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import businessLogic.Airline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AdminLoginController 
{
	Airline airline = new Airline();
	
	@FXML
	Main main = new Main();
	
	@FXML
	public ImageView loginImage = new ImageView("C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\14.png");
	
	@FXML
	public Button login_Button = new Button();
	
	@FXML
	public Button homeMenu = new Button();
	
	@FXML
	public TextField enter_Employee_ID_Text_Field = new TextField();
	
	@FXML
	public TextField enter_Password_Text_Field = new TextField();
	
	@FXML
	public URL location;
	
	@FXML
	public ResourceBundle resources;
	
	@FXML
	public void initialize()
	{
		loginImage.getImage();
	}
	
	public AdminLoginController()
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
	public void goToLogin(ActionEvent event) throws IOException, NumberFormatException, NullPointerException
	{
		try
		{
			int empId = Integer.parseInt(enter_Employee_ID_Text_Field.getText());
			String password = enter_Password_Text_Field.getText();
			
			boolean flag = airline.loginAdmin(empId, password);
			
			if(flag == true)
			{
				System.out.println("Successfully logged in!");
				Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
				main.goToAdminMode(stage);
			}
			else
			{
				AlertType type = AlertType.INFORMATION;
				 Alert alert = new Alert(type, "");
				 
				 alert.getDialogPane().setContentText("Wrong Credentials!");
				 alert.getDialogPane().setHeaderText("Error!");
				 alert.showAndWait();
			}
		}catch (NumberFormatException e) 
		{
			 AlertType type = AlertType.ERROR;
			 Alert alert = new Alert(type, "");
			 
			 alert.getDialogPane().setHeaderText("Error!");
			 alert.getDialogPane().setContentText("Please Enter Valid Fields!");
			 alert.showAndWait();
		}catch (NullPointerException e) 
		{
			 AlertType type = AlertType.ERROR;
			 Alert alert = new Alert(type, "");
			 
			 alert.getDialogPane().setHeaderText("Error!");
			 alert.getDialogPane().setContentText("No Data Found!");
			 alert.showAndWait();
		}            
	}
}
