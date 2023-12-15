package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import businessLogic.Airline;
import businessLogic.Customer;
import dataBase.AirlineData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CustomerSignupController 
{
	Airline airline = new Airline();
	
	@FXML
	Main main = new Main();
	
	@FXML
	public ImageView singupImage = new ImageView("C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\10.png");
	
	@FXML
	public Button register_Button = new Button();
	
	@FXML
	public Button homeMenu = new Button();
	
	@FXML
	public TextField enter_Name_Text_Field = new TextField();
	
	@FXML
	public TextField enter_Password_Text_Field = new TextField();
	
	@FXML
	public TextField enter_Cnic_Text_Field = new TextField();
	
	@FXML
	public TextField enter_Email_Text_Field = new TextField();
	
	@FXML
	public TextField enter_Age_Text_Field = new TextField();
	
	@FXML
	public TextField enter_Gender_Text_Field = new TextField();
	
	@FXML
	public URL location;
	
	@FXML
	public ResourceBundle resources;
	
	@FXML
	public void initialize()
	{
		singupImage.getImage();
	}
	
	public CustomerSignupController()
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
	public void goToRegister(ActionEvent event) throws IOException, NumberFormatException, NullPointerException
	{	
		try
		{
			String name = (enter_Name_Text_Field.getText());
			String password = (enter_Password_Text_Field.getText());
			String cnic = (enter_Cnic_Text_Field.getText());
		    String email = (enter_Email_Text_Field.getText());
			int foo = Integer.parseInt(enter_Age_Text_Field.getText());
			int age = foo;
			String gender = (enter_Gender_Text_Field.getText());
			
			boolean flag = airline.signupCustomer(name, password, cnic, email, age, gender);
			
			if(flag == true)
			{
				System.out.println("Customer Registered!");
				Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
				main.goToCustomerLoginSignupMenu(stage);
			}
			else
			{
				 AlertType type = AlertType.INFORMATION;
				 Alert alert = new Alert(type, "");
				 
				 alert.getDialogPane().setHeaderText("Error!");
				 alert.getDialogPane().setContentText("Failed to Register Customer!");
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
