package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CustomerModeController 
{
	@FXML
	Main main = new Main();
	
	@FXML
	public ImageView customer_Image = new ImageView("2.jpg");
	
	@FXML
	public Button rescheduleTicket;
	
	@FXML
	public Button checkAvailableFlights;
	
	@FXML
	public Button checkFlightStatus;
	
	@FXML
	public Button reserveSeat;
	
	@FXML
	public Button cancelTicket;
	
	@FXML
	public Button homeMenu;
	
	@FXML
	public URL location;
	
	@FXML
	public ResourceBundle resources;
	
	@FXML
	public void initialize()
	{
		customer_Image.getImage();
	}
	
	public CustomerModeController()
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
		System.out.println("In Reserving Ticket Mode!");
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
