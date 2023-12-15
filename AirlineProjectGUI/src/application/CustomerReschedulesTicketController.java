package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import businessLogic.Airline;
import businessLogic.Booking;
import businessLogic.FlightSchedule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CustomerReschedulesTicketController 
{
	Airline airline = new Airline();
	
	@FXML
	Main main = new Main();
	
	@FXML
	public TextField enter_Ticket_Number_Text_Field = new TextField();
	
	@FXML
	public TextArea ticket_Information_Text_Area = new TextArea();
	
	@FXML
	public TextArea updated_Fare_Information_Text_Area = new TextArea();
	
	@FXML
	public ImageView ticket_Image = new ImageView("3.jpg");
	
	@FXML
	public TextField date_Picker_Text_Field = new TextField();
	
	@FXML
	public TextField update_Seat_Class_Text_Field = new TextField();
	
	@FXML
	public Button back = new Button();
	
	@FXML
	public Button checkAvailableFlights = new Button();
	
	@FXML
	public Button updateTicket = new Button();
	
	@FXML
	public Button checkFlightStatus = new Button();
	
	@FXML
	public Button confirmReschedule = new Button();
	
	@FXML
	public Button cancelReschedule = new Button();
	
	@FXML
	public Button reserveSeat = new Button();
	
	@FXML
	public Button cancelTicket = new Button();
	
	@FXML
	public Button customerMenu = new Button();
	
	@FXML
	public URL location;
	
	@FXML
	public ResourceBundle resources;
	
	@FXML
	public void initialize()
	{
		ticket_Image.getImage();
	}
	
	@FXML
	public void searchTicket(ActionEvent event) throws IOException, NumberFormatException, NullPointerException
	{
		try
		{
			System.out.println("showing ticket information!");
			
			int id = Integer.parseInt(enter_Ticket_Number_Text_Field.getText());
			
			FlightSchedule flightSchedule = airline.getTicketInformation(id);
			
			if(flightSchedule == null)
			{
				 AlertType type = AlertType.INFORMATION;
				 Alert alert = new Alert(type, "");
				 
				 alert.getDialogPane().setHeaderText("Error!");
				 alert.getDialogPane().setContentText("No Flight Information!");
				 alert.showAndWait();
			}
			
			else
			{
				ticket_Information_Text_Area.setStyle("-fx-font-size: 20");
				ticket_Information_Text_Area.setText(flightSchedule.toString());
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
	public void updateTicket(ActionEvent event) throws IOException, NumberFormatException, NullPointerException
    {
		try
		{
			String date = date_Picker_Text_Field.getText();
			String seatType = update_Seat_Class_Text_Field.getText();
			
			int ticketID = Integer.parseInt(enter_Ticket_Number_Text_Field.getText());
			FlightSchedule flightSchedule = airline.updateTicket(ticketID, date, seatType);
			
			Booking booking = airline.updateFare(ticketID, date, seatType);
			
			if(booking == null)
			{
				 AlertType type = AlertType.INFORMATION;
				 Alert alert = new Alert(type, "");
				 
				 alert.getDialogPane().setHeaderText("Error!");
				 alert.getDialogPane().setContentText("No Flight Information Found!");
				 alert.showAndWait();
			}
			
			else
			{
				updated_Fare_Information_Text_Area.setText(booking.toString());
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
	
	public CustomerReschedulesTicketController()
	{
		
	}
	
	@FXML
	public void goToCustomerMode(ActionEvent event) throws IOException 
	{
		System.out.println("In Customer Mode!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToCustomerMode(stage);
		
		 
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
	public void goToCustomerChecksFlightStatus(ActionEvent event) throws IOException
	{
		System.out.println("In Checking Flight Status Mode!");
		checkFlightStatus.setText("You just clicked me!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToCustomerChecksFlightStatus(stage);
		
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
	public void confirmReschedule(ActionEvent event) throws IOException
	{
		System.out.println("Ticket Rescheduled Successfully!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToCustomerMode(stage);
		
	}
	
	@FXML
	public void cancelReschedule(ActionEvent event) throws IOException
	{
		System.out.println("Ticket Rescheduling Cancelled!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToCustomerMode(stage);
		
	}
	
	@FXML
	public void goToCustomerCancelsTicket(ActionEvent event) throws IOException
	{
		System.out.println("In Cancelling Ticket Mode!");
		cancelTicket.setText("You just clicked me!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToCustomerCancelsTicket(stage);
	}

}
