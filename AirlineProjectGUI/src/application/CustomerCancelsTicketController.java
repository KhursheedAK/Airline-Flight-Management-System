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

public class CustomerCancelsTicketController 
{
	Airline airline = new Airline();
	
	@FXML
	Main main = new Main();
	
	@FXML
	public ImageView ticket_Image = new ImageView("12.png");
	
	@FXML
	public Button back = new Button();
	
	@FXML
	public Button search_Ticket = new Button();
	
	@FXML
	public Button confirm_Cancellation = new Button();
	
	@FXML
	public Button do_Not_Cancel = new Button();
	
	@FXML
	public Button rescheduleTicket = new Button();
	
	@FXML
	public Button checkAvailableFlights = new Button();
	
	@FXML
	public Button reserveSeat = new Button();
	
	@FXML
	public Button checkFlightStatus = new Button();
	
	@FXML
	public Button customerMenu = new Button();
	
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
	
	public CustomerCancelsTicketController()
	{
		
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
				 alert.getDialogPane().setContentText("No flight information found!");
				 alert.showAndWait();
			}
			
			else
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
	public void confirmCancellation(ActionEvent event) throws IOException, NullPointerException
	{
		try
		{
			int id = Integer.parseInt(enter_Ticket_Number_Text_Field.getText());
			boolean flag = airline.cancelTicket(id);
			
			if(flag == true)
			{
				System.out.println("Ticket Cancelled Successfully:");
				
				Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
				main.goToCustomerMode(stage);
			}
			
			else
			{
				 AlertType type = AlertType.INFORMATION;
				 Alert alert = new Alert(type, "");
				 
				 alert.getDialogPane().setHeaderText("Error!");
				 alert.getDialogPane().setContentText("Failed to Cancel Ticket!");
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
		main.goToCustomerMode(stage);
	}
	
	@FXML
	public void goToCustomerMode(ActionEvent event) throws IOException 
	{
		System.out.println("In Customer Mode!");
		customerMenu.setText("You just clicked me!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToCustomerMode(stage);
	}
	
	@FXML
	public void goToCustomerReschedulesTicket(ActionEvent event) throws IOException
	{
		System.out.println("In Rescheduling Ticket Mode!");
		rescheduleTicket.setText("You just clicked me!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToCustomerReschedulesTicket(stage);
	}
	
	@FXML
	public void goToCustomerChecksAvailableFlights(ActionEvent event) throws IOException
	{
		System.out.println("In Checking Available Flights Mode!");
		checkAvailableFlights.setText("You just clicked me!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToCustomerChecksAvailableFlights(stage);
		
	}
	
	@FXML
	public void goToCustomerReservesSeat(ActionEvent event) throws IOException
	{
		System.out.println("In Rescheduling Ticket Mode!");
		reserveSeat.setText("You just clicked me!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToCustomerReservesSeat(stage);
	}
	
	@FXML
	public void goToCustomerChecksFlightStatus(ActionEvent event) throws IOException
	{
		System.out.println("In Checking Flight Status Mode!");
		checkFlightStatus.setText("You just clicked me!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToCustomerChecksFlightStatus(stage);
	}
	
}
