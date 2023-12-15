package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import businessLogic.Airline;
import businessLogic.Booking;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AdminCancelsTicketController 
{
	Airline airline = new Airline();
	
	@FXML
	Main main = new Main();
	
	@FXML
	public ImageView ticket_Image = new ImageView("7.png");
	
	@FXML
	public Button back = new Button();
	
	@FXML
	public Button search_Ticket = new Button();
	
	@FXML
	public Button confirm_Cancellation = new Button();
	
	@FXML
	public Button do_Not_Cancel = new Button();
	
	@FXML
	public Button reschedule_Flight = new Button();
	
	@FXML
	public Button cancel_Flight = new Button();
	
	@FXML
	public Button add_Passenger = new Button();
	
	@FXML
	public Button admin_Menu = new Button();
	
	@FXML
	public TextField enter_Ticket_Number_Text_Field = new TextField();
	
	@FXML
	public TextArea ticket_Information_Text_Area = new TextArea(); 
	
	@FXML
	public URL location;
	
	@FXML
	public ResourceBundle resources;
	
	@FXML
	public void initialize()
	{
		ticket_Image.getImage();
	}
	
	public AdminCancelsTicketController()
	{
		
	}
	
	@FXML
	public void goToAdminMode(ActionEvent event) throws IOException 
	{
		System.out.println("In Admin Mode!");
		
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
	public void goToAdminCancelsFlight(ActionEvent event) throws IOException
	{
		System.out.println("In Cancelling Flight Menu!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToAdminCancelsFlight(stage);
	}
	
	@FXML
	public void goToAdminAddsPassenger(ActionEvent event) throws IOException
	{
		System.out.println("In Add Passenger Mode!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToAdminAddsPassenger(stage);
	}
	
	@FXML
	public void searchTicket(ActionEvent event) throws IOException, NumberFormatException, NullPointerException
	{
		try
		{
			System.out.println("Displaying information of the ticket:");
			int id = Integer.parseInt(enter_Ticket_Number_Text_Field.getText());
			
			Booking booking = airline.getFlightInformation(id);
			if(booking == null)
			{
				 AlertType type = AlertType.INFORMATION;
				 Alert alert = new Alert(type, "");
				 
				 alert.getDialogPane().setHeaderText("Error!");
				 alert.getDialogPane().setContentText("No Flight Information Found!");
				 alert.showAndWait();
			}
			
			else if(booking != null)
			{
				ticket_Information_Text_Area.setStyle("-fx-font-size: 19");
				ticket_Information_Text_Area.setText(booking.toString());
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
	public void confirmCancellation(ActionEvent event) throws IOException, NumberFormatException, NullPointerException
	{
		try
		{
			int id = Integer.parseInt(enter_Ticket_Number_Text_Field.getText());
			boolean flag = airline.cancelTicket(id);
			
			if(flag == true)
			{
				System.out.println("Ticket Cancelled Successfully:");
				
				Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
				main.goToAdminMode(stage);
			}
			
			else
			{
				AlertType type = AlertType.INFORMATION;
				 Alert alert = new Alert(type, "");
				 
				 alert.getDialogPane().setContentText("Failed to cancel Ticket!");
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
	
	@FXML
	public void doNotCancel(ActionEvent event) throws IOException
	{
		System.out.println("Ticket was not Cancelled!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToAdminMode(stage);
	}
	
}
