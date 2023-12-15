package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import businessLogic.Airline;
import businessLogic.FlightDetails;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CustomerChecksAvailableFlightController 
{
	Airline airline = new Airline();
	
	@FXML
	Main main = new Main();
	
	@FXML
	public TextField enter_Departure_Airport_Text_Field = new TextField();
	
	@FXML
	public TextField enter_Arrival_Airport_Text_Field = new TextField();
	
	@FXML
	public TextArea flights_Information_Text_Area = new TextArea();
	
	@FXML
	public ImageView aeroplane_Image = new ImageView("4.jpg");
	
	@FXML
	public TextField enter_Date_Menu = new TextField() ;
	
	@FXML
	public TextField flight_Type = new TextField() ;
	
	@FXML
	public Button back = new Button();
	
	@FXML
	public Button rescheduleTicket = new Button();
	
	@FXML
	public Button cancelTicket = new Button();
	
	@FXML
	public Button checkFlightStatus = new Button();
	
	@FXML
	public Button customerMenu = new Button();
	
	@FXML
	public Button searchFlights = new Button();
	
	@FXML
	public Button reserveSeat = new Button();
	
	@FXML
	public URL location;
	
	@FXML
	public ResourceBundle resources;
	
	@FXML
	public void initialize()
	{
		aeroplane_Image.getImage();
	}
	
	
	public CustomerChecksAvailableFlightController()
	{
		
	}
	
	@FXML
	public void searchFlights(ActionEvent event) throws IOException, NumberFormatException, NullPointerException
	{
		try
		{
			System.out.println("Displaying all the available flights:");
			
			if(flight_Type.getText().equalsIgnoreCase("Local"))
			{
				String da = enter_Departure_Airport_Text_Field.getText();
				String aa = enter_Arrival_Airport_Text_Field.getText();
				FlightDetails fdLocal = airline.localFlightInformation(da, aa);
				
				if(fdLocal == null)
				{
					 AlertType type = AlertType.INFORMATION;
					 Alert alert = new Alert(type, "");
					 
					 alert.getDialogPane().setHeaderText("Error!");
					 alert.getDialogPane().setContentText("No such local flight available!");
					 alert.showAndWait();
				}
				
				else if(fdLocal != null)
				{
					flights_Information_Text_Area.setStyle("-fx-font-size: 19");
					flights_Information_Text_Area.setText(fdLocal.toString());	
				}
			}
			
			else if(flight_Type.getText().equalsIgnoreCase("International"))
			{
				String da = enter_Departure_Airport_Text_Field.getText();
				String aa = enter_Arrival_Airport_Text_Field.getText();
				FlightDetails fdInter = airline.internationalFlightInformation(da, aa);
				
				if(fdInter == null)
				{
					 AlertType type = AlertType.INFORMATION;
					 Alert alert = new Alert(type, "");
					 
					 alert.getDialogPane().setHeaderText("Error!");
					 alert.getDialogPane().setContentText("No such international flight found!");
					 alert.showAndWait();
				}
				
				else if(fdInter != null)
				{
					flights_Information_Text_Area.setStyle("-fx-font-size: 19");
					flights_Information_Text_Area.setText(fdInter.toString());
				}
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
	public void goToCustomerMode(ActionEvent event) throws IOException 
	{
		System.out.println("In Customer Mode!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToCustomerMode(stage);
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
