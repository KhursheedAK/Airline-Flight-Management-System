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

public class AdminAddsPassengerController 
{
	Airline airline = new Airline();
	
	@FXML
	Main main = new Main();
	
	@FXML
	public ImageView addImage = new ImageView("C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\17.png");
	
	@FXML
	public Button add_Button = new Button();
	
	@FXML
	public Button cancel_Button = new Button();
	
	@FXML
	public Button admin_Menu = new Button();
	
	@FXML
	public Button reschedule_Flight = new Button();
	
	@FXML
	public Button cancel_Flight = new Button();
	
	@FXML
	public Button cancel_Ticket = new Button();
	
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
		addImage.getImage();
	}
	
	public AdminAddsPassengerController()
	{
		
	}
	
	@FXML
	public void goToAdminMode(ActionEvent event) throws IOException
	{
		System.out.println("In Home Menu!");
		admin_Menu.setText("You just clicked me!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToAdminMode(stage);
	}
	
	@FXML
	public void goToAdd(ActionEvent event) throws IOException, NumberFormatException, NullPointerException
	{
		try
		{
			String name = enter_Name_Text_Field.getText();
			String password = enter_Password_Text_Field.getText();
			String cnic = enter_Cnic_Text_Field.getText();
			String email = enter_Email_Text_Field.getText();
			int age = Integer.parseInt(enter_Age_Text_Field.getText());
			String gender = enter_Gender_Text_Field.getText();
					
			boolean flag = airline.addPassenger(name, password, cnic, email, age, gender);
			
			if(flag == true)
			{
				System.out.println("Successfully Added the Customer!");
				add_Button.setText("You just clicked me!");
				
				Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
				main.goToAdminMode(stage);
			}
			else
			{
				AlertType type = AlertType.INFORMATION;
				 Alert alert = new Alert(type, "");
				 
				 alert.getDialogPane().setHeaderText("Error!");
				 alert.getDialogPane().setContentText("Failed to Add!");
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
	
	@FXML
	public void goToCancel(ActionEvent event) throws IOException
	{
		System.out.println("Cancelled...");
		cancel_Button.setText("You just clicked me!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToAdminMode(stage);
	}
	
	@FXML
	public void goToAdminReschedulesFlight(ActionEvent event) throws IOException
	{
		System.out.println("In Rescheduling Flight Mode!");
		reschedule_Flight.setText("You just clicked me!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToAdminReschedulesFlight(stage);
	}
	
	@FXML
	public void goToAdminCancelsTicket(ActionEvent event) throws IOException
	{
		System.out.println("In Cancelling Ticket Menu!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToAdminCancelsTicket(stage);
	}
	
	@FXML
	public void goToAdminCancelsFlight(ActionEvent event) throws IOException
	{
		System.out.println("In Cancelling Flight Menu!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToAdminCancelsFlight(stage);
	}
}
