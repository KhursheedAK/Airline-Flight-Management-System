package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AdminModeController 
{
	@FXML
	Main main = new Main();
	
	@FXML
	public ImageView admin_Image = new ImageView("8.png");
	
	@FXML
	public Button reschedule_Flight;
	
	@FXML
	public Button cancel_Ticket;
	
	@FXML
	public Button cancel_Flight;
	
	@FXML
	public Button add_Passenger;
	
	@FXML
	public Button homeMenu;
	
	@FXML
	public URL location;
	
	@FXML
	public ResourceBundle resources;
	
	@FXML
	public void initialize()
	{
		admin_Image.getImage();
	}
	
	public AdminModeController()
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
	public void goToAdminCancelsTicket(ActionEvent event) throws IOException
	{
		System.out.println("In Cancelling Ticket Mode!");
		cancel_Ticket.setText("You just clicked me!");
		
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToAdminCancelsTicket(stage);
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
}
