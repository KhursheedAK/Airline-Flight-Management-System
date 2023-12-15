package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import businessLogic.Airline;
import businessLogic.Booking;
import businessLogic.FlightDetails;
import dataBase.AirlineData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CustomerReservesSeat 
{
	Airline airline = new Airline();
	@FXML
	Main main = new Main();
	
	@FXML
	public ImageView booking_Image = new ImageView("6.png");
	
	@FXML
	public Button search_Button = new Button();
	
	@FXML
	public Button view_Fare_Button = new Button();
	
	@FXML
	public Button confirm_Fare_Button = new Button();
	
	@FXML
	public Button cancel_Button = new Button();
	
	@FXML
	public Button rescheduleTicket = new Button();
	
	@FXML
	public Button checkAvailableFlights = new Button();
	
	@FXML
	public Button checkFlightStatus = new Button();
	
	@FXML
	public Button back_to_Menu = new Button();
	
	@FXML
	public Button cancelTicket = new Button();
	
	@FXML
	public Button customerMenu = new Button();
	
	@FXML
	public TextField enter_Name = new TextField();
	
	@FXML
	public TextField flight_Type_Text_Field = new TextField();
	
	@FXML
	public TextField seat_Type_Text_Field = new TextField();
	
	@FXML
	public TextField enter_Cnic_Text_Field = new TextField();
	
	@FXML
	public TextField enter_Phone_Text_Field = new TextField();
	
	@FXML
	public TextField enter_Gender_Text_Field = new TextField();
	
	@FXML
	public TextField enter_Departure_Airport_Text_Field = new TextField();
	
	@FXML
	public TextField enter_Arrival_Airport_Text_Field = new TextField();
	
	@FXML
	public TextField enter_ID_to_Select_Flight_Text_field = new TextField();
	
	@FXML
	public TextField enter_Quantity_of_Seats_Text_Field = new TextField();
	
	@FXML
	public TextArea flight_Information_Text_Area = new TextArea();
	
	@FXML
	public TextArea fare_Information_Text_Area = new TextArea();
	
	@FXML
	public TextField date_Pick_Text_Field = new TextField();
	
	@FXML
	public TextArea booking_Information = new TextArea();
	
	@FXML
	public URL location;
	
	@FXML
	public ResourceBundle resources;
	
	@FXML
	public void initialize()
	{
		booking_Image.getImage();
	}
	
	public CustomerReservesSeat()
	{
		
	}
	
	@FXML
	public void searchFlight(ActionEvent event) throws IOException, NumberFormatException, NullPointerException
	{
		try
		{
			String da = enter_Departure_Airport_Text_Field.getText();
			String aa = enter_Arrival_Airport_Text_Field.getText();
			
			
			System.out.println("showing flight information!");
			
			FlightDetails fd = airline.flightInformation(da, aa);
			
			if(fd == null)
			{
				 AlertType type = AlertType.INFORMATION;
				 Alert alert = new Alert(type, "");
				 
				 alert.getDialogPane().setHeaderText("Error!");
				 alert.getDialogPane().setContentText("No such flight available!");
				 alert.showAndWait();
			}
			
			else if(fd != null)
			{
				flight_Information_Text_Area.setStyle("-fx-font-size: 19");
				flight_Information_Text_Area.setText(fd.toString());
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
	public void confirmToViewFare(ActionEvent event) throws IOException, NumberFormatException, NullPointerException
	{
		try
		{
			int slot =Integer.parseInt(enter_ID_to_Select_Flight_Text_field.getText());
			int seatQty = Integer.parseInt(enter_Quantity_of_Seats_Text_Field.getText());
			String seatType = seat_Type_Text_Field.getText();
			
			double amount = airline.confirmToViewFare(slot, seatQty, seatType);
			System.out.println("showing total fare information!");
			
			if(amount == 0)
			{
				 AlertType type = AlertType.INFORMATION;
				 Alert alert = new Alert(type, "");
				 
				 alert.getDialogPane().setHeaderText("Error!");
				 alert.getDialogPane().setContentText("Flight not available!");
				 alert.showAndWait();
			}
			
			else if(amount > 0)
			{
				fare_Information_Text_Area.setStyle("-fx-font-size: 19");
				fare_Information_Text_Area.setText("Total Fare: RS "+amount);
			}
		}catch (NumberFormatException e) 
		{
			 AlertType type = AlertType.ERROR;
			 Alert alert = new Alert(type, "");
			 
			 alert.getDialogPane().setHeaderText("Error!");
			 alert.getDialogPane().setContentText("Please enter valid fields!");
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
	public void confirmReservation(ActionEvent event) throws IOException, NumberFormatException, NullPointerException
	{
		try
		{
			int slot =Integer.parseInt(enter_ID_to_Select_Flight_Text_field.getText());
			String da = enter_Departure_Airport_Text_Field.getText();
			String aa = enter_Arrival_Airport_Text_Field.getText();
			String date = date_Pick_Text_Field.getText();
			int seatQty = Integer.parseInt(enter_Quantity_of_Seats_Text_Field.getText());
			String is_late = "Flight-is-Not-Postponed!";	//status
	
			String flightType = flight_Type_Text_Field.getText();
			String seatType = seat_Type_Text_Field.getText();
			double amount = airline.confirmToViewFare(slot, seatQty, seatType);
			
			if(amount != 0)
			{
				String name = enter_Name.getText();
				String cnic = enter_Cnic_Text_Field.getText();
				boolean flag = airline.confirmReservation(seatQty, aa, da, date, seatQty, is_late, flightType, seatType, amount, name, cnic);
				
				if(flag == true)
				{
					Booking booking = airline.bookingInfo(cnic);
					System.out.println("Ticket Reservation Successful!");
					
					booking_Information.setStyle("-fx-font-size: 17");
					booking_Information.setText(booking.toString());
				}
			}
			
			else 
			{
				 AlertType type = AlertType.INFORMATION;
				 Alert alert = new Alert(type, "");
				 
				 alert.getDialogPane().setHeaderText("Error!");
				 alert.getDialogPane().setContentText("Reservation Failed!");
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
	public void cancelReservation(ActionEvent event) throws IOException
	{
		System.out.println("Ticket Reservation Cancelled!");
		
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
	public void goToCustomerReschedulesTicket(ActionEvent event) throws IOException
	{
		System.out.println("In Rescheduling Ticket Mode!");
		rescheduleTicket.setText("You just clicked me!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToCustomerReschedulesTicket(stage);
	}
	
	@FXML
	public void goToCustomerMode(ActionEvent event) throws IOException 
	{
		System.out.println("In Customer Menu!");
		
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
