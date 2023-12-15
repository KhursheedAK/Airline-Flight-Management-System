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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AdminReschedulesFlightController 
{
	Airline airline = new Airline();
	
	@FXML
	Main main = new Main();
	
	@FXML
	public ImageView flight_Image = new ImageView("16.png");
	
	@FXML
	public Button back = new Button();
	
	@FXML
	public Button search_Flight = new Button();
	
	@FXML
	public Button confirm_Reschedule = new Button();
	
	@FXML
	public Button cancel_Reschedule = new Button();
	
	@FXML
	public Button reschedule_Flight = new Button();
	
	@FXML
	public Button cancel_Ticket = new Button();
	
	@FXML
	public Button cancel_Flight = new Button(); 
	
	@FXML
	public Button add_Passenger = new Button();
	
	@FXML
	public Button adminMenu = new Button();
	
	@FXML
	public TextField enter_Flight_Code_Text_Field = new TextField();
	
	@FXML
	public TextArea flight_Information_Text_Area = new TextArea();
	
	@FXML
	public TextArea enter_Reschedule_Reason_Text_Area = new TextArea();
	
	@FXML
	public TextField date_Picker_Text_Field = new TextField();
	
	@FXML
	public URL location;
	
	@FXML
	public ResourceBundle resources;
	
	@FXML
	public void initialize()
	{
		flight_Image.getImage();
	}
	
	public AdminReschedulesFlightController()
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
	
	@FXML
	public void goToAdminAddsPassenger(ActionEvent event) throws IOException
	{
		System.out.println("In Add Passenger Menu!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToAdminAddsPassenger(stage);
	}
	
	@FXML
	public void searchFlight(ActionEvent event) throws IOException, NumberFormatException, NullPointerException
	{
		try
		{
			int id = Integer.parseInt(enter_Flight_Code_Text_Field.getText());
			
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
				flight_Information_Text_Area.setStyle("-fx-font-size: 20");
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
	public void confirmReschedule(ActionEvent event) throws IOException, NumberFormatException, NullPointerException
	{
		try
		{
			int id = Integer.parseInt(enter_Flight_Code_Text_Field.getText());
			String reason = enter_Reschedule_Reason_Text_Area.getText();
			String date = date_Picker_Text_Field.getText();
			
			Booking booking = airline.rescheduleFlight(id, reason ,date);
			
			if(booking == null)
			{
				 AlertType type = AlertType.INFORMATION;
				 Alert alert = new Alert(type, "");
				 
				 alert.getDialogPane().setHeaderText("Error!");
				 alert.getDialogPane().setContentText("Rescheduling Failed!");
				 alert.showAndWait();
			}
			
			else
			{
				System.out.println("Flight rescheduled Successfully:");
				
				flight_Information_Text_Area.setStyle("-fx-font-size: 20");
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
	public void cancelReschedule(ActionEvent event) throws IOException
	{
		System.out.println("Flight was not Rescheduled!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToAdminMode(stage);
	}
}
