package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JLabel;

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

public class CustomerChecksFlightStatusController 
{
	Airline airline = new Airline();
	
	@FXML
	Main main = new Main();
	
	@FXML
	public ImageView plane_Image = new ImageView("5.jpg");
	
	@FXML
	public Button customerMenu = new Button();
	
	@FXML
	public Button rescheduleTicket = new Button();
	
	@FXML
	public Button checkAvailableFlights = new Button();
	
	@FXML
	public Button search = new Button();
	
	@FXML
	public Button back = new Button();
	
	@FXML
	public Button reserveSeat = new Button();
	
	@FXML
	public Button cancelTicket = new Button();
	
	@FXML
	public Button more_Info = new Button();
	
	@FXML
	public TextField enter_Ticket_ID_Text_Field = new TextField();
	
	@FXML
	public TextArea flight_Status_Text_Area = new TextArea();
	
	@FXML
	public TextArea flight_Information_Text_Area = new TextArea();
	
	@FXML
	public URL location;
	
	@FXML
	public ResourceBundle resources;
	
	@FXML
	public void initialize()
	{
		plane_Image.getImage();
	}
	
	public CustomerChecksFlightStatusController()
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
	public void getStatusOfFlight(ActionEvent event) throws IOException, NumberFormatException, NullPointerException
	{
		try
		{
			System.out.println("Displaying flight Status:");
			int id = Integer.parseInt(enter_Ticket_ID_Text_Field.getText());
			
			String status = airline.getStatusOfFlight(id);
		
		
		
			if(status == null)
			{
				 AlertType type = AlertType.INFORMATION;
				 Alert alert = new Alert(type, "");
				 
				 alert.getDialogPane().setHeaderText("Error!");
				 alert.getDialogPane().setContentText("No flight information found!");
				 alert.showAndWait();
			}
			
			else if(status != null)
			{
				flight_Status_Text_Area.setStyle("-fx-font-size: 30");
				flight_Status_Text_Area.setText(status);
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
	public void getFlightInformation(ActionEvent event) throws IOException, NumberFormatException, NullPointerException
	{
		try
		{
			int id = Integer.parseInt(enter_Ticket_ID_Text_Field.getText());
			
			Booking booking = airline.getFlightInformation(id);
			
			if(booking == null)
			{
				 AlertType type = AlertType.INFORMATION;
				 Alert alert = new Alert(type, "");
				 
				 alert.getDialogPane().setHeaderText("Error!");
				 alert.getDialogPane().setContentText("No flight information found!");
				 alert.showAndWait();
			}
			
			else if(booking != null)
			{
				flight_Information_Text_Area.setStyle("-fx-font-size: 19");
				flight_Information_Text_Area.setText(booking.toString());
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
	public void goToCustomerCancelsTicket(ActionEvent event) throws IOException
	{
		System.out.println("In Cancelling Ticket Mode!");
		cancelTicket.setText("You just clicked me!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToCustomerCancelsTicket(stage);
	}

}
