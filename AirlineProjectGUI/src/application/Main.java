package application;
	
import java.io.FileInputStream;
import java.io.IOException;

import businessLogic.Airline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application 
{
	Stage stage;
	FXMLLoader loader = new FXMLLoader();
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			// retrieving booked tickets from files
			Airline airline = new Airline();
			airline.getAllBookedTickets();
			//end
			
			airline.availableFlights();
			airline.availableLocalFlights();
			airline.availableInterFlights();
			
			// retrieving registered users from files
			airline.getAllUsers();
			airline.getAllAdmins();
			
			// my code
			String fxmlDocPath ="C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\application\\Home.fxml"; 
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			AnchorPane root =(AnchorPane) loader.load(fxmlStream);
			
			Scene scene = new Scene(root,749,180);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	//___________________________________________________________________________________________________________________________________________________
	
	// Change Scene to Home Menu
	public void goToHomeMenu(Stage stage) throws IOException
	{
		String fxmlDocPath ="C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\application\\Home.fxml"; 
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		AnchorPane root =(AnchorPane) loader.load(fxmlStream);
		
		Scene scene = new Scene(root,749,180);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		
	}
	
	//___________________________________________________________________________________________________________________________________________________
	
	// Change Scene to Customer Mode
		public void goToCustomerMode(Stage stage) throws IOException
		{
			String fxmlDocPath ="C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\application\\CustomerMode.fxml"; 
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			AnchorPane root =(AnchorPane) loader.load(fxmlStream);
			
			Scene scene = new Scene(root,1080,200);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			
		}
	
	
	// Change Scene to Customer Reschedules Ticket
		public void goToCustomerReschedulesTicket(Stage stage) throws IOException
		{
			String fxmlDocPath ="C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\application\\CustomerReschedulesTicket.fxml"; 
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			AnchorPane root =(AnchorPane) loader.load(fxmlStream);
			
			Scene scene = new Scene(root,865,672);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			
		}
		
	// Change Scene to Customer Checks Available Flights
		public void goToCustomerChecksAvailableFlights(Stage stage) throws IOException
		{
			String fxmlDocPath ="C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\application\\CustomerChecksAvailableFlights.fxml";
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			AnchorPane root =(AnchorPane) loader.load(fxmlStream);
			
			Scene scene = new Scene(root,785,576);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			
		}
		
	// Change Scene to Customer Checking Flight Status
		public void goToCustomerChecksFlightStatus(Stage stage) throws IOException
		{
			String fxmlDocPath ="C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\application\\CustomerChecksFlightStatus.fxml";
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			AnchorPane root =(AnchorPane) loader.load(fxmlStream);
			
			Scene scene = new Scene(root,849,576);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			
		}
		
	// Change Scene to Customer Reserves Seat
		public void goToCustomerReservesSeat(Stage stage) throws IOException
		{
			String fxmlDocPath ="C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\application\\CustomerReservesSeat.fxml";
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			AnchorPane root =(AnchorPane) loader.load(fxmlStream);
			
			Scene scene = new Scene(root,1174,915);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			
		}
		
		// Change Scene to Customer Cancels Ticket
		public void goToCustomerCancelsTicket(Stage stage) throws IOException
		{
			String fxmlDocPath ="C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\application\\CustomerCancelsTicket.fxml";
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			AnchorPane root =(AnchorPane) loader.load(fxmlStream);
			
			Scene scene = new Scene(root,885,613);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			
		}
		
		// Change Scene to Customer Login & Sign-up Menu
			public void goToCustomerLoginSignupMenu(Stage stage) throws IOException
			{
				String fxmlDocPath ="C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\application\\CustomerLoginSignupMenu.fxml";
				FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
				AnchorPane root =(AnchorPane) loader.load(fxmlStream);
				
				Scene scene = new Scene(root,568,338);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
				
			}
		
		// Change Scene to Customer Login 
			public void goToCustomerLogin(Stage stage) throws IOException
			{
				String fxmlDocPath ="C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\application\\CustomerLogin.fxml";
				FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
				AnchorPane root =(AnchorPane) loader.load(fxmlStream);
				
				Scene scene = new Scene(root,568,313);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
				
			}
			
			// Change Scene to Customer Sign-up
				public void goToCustomerSignup(Stage stage) throws IOException
				{
					String fxmlDocPath ="C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\application\\CustomerSignup.fxml";
					FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
					AnchorPane root =(AnchorPane) loader.load(fxmlStream);
					
					Scene scene = new Scene(root,568,375);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					stage.setScene(scene);
					stage.show();
					
				}
				
		//___________________________________________________________________________________________________________________________________________________
		
		
		// Change Scene to Administrator Mode
			public void goToAdminMode(Stage stage) throws IOException
			{
				String fxmlDocPath ="C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\application\\AdminMode.fxml"; 
				FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
				AnchorPane root =(AnchorPane) loader.load(fxmlStream);
				
				Scene scene = new Scene(root,905,200);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
				
			}
		
		
		// Change Scene to Administrator Cancels Ticket
			public void goToAdminCancelsTicket(Stage stage) throws IOException
			{
				String fxmlDocPath ="C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\application\\AdminCancelsTicket.fxml";
				FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
				AnchorPane root =(AnchorPane) loader.load(fxmlStream);
				
				Scene scene = new Scene(root,865,593);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
				
			}
			
			
		// Change Scene to Administrator Cancels Flight
			public void goToAdminCancelsFlight(Stage stage) throws IOException
			{
				String fxmlDocPath ="C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\application\\AdminCancelsFlight.fxml"; 
				FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
				AnchorPane root =(AnchorPane) loader.load(fxmlStream);
				
				Scene scene = new Scene(root,865,593);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
				
			}
			
		// Change Scene to Administrator Reschedules Flight
			public void goToAdminReschedulesFlight(Stage stage) throws IOException
			{
				String fxmlDocPath ="C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\application\\AdminReschedulesFlight.fxml"; 
				FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
				AnchorPane root =(AnchorPane) loader.load(fxmlStream);
				
				Scene scene = new Scene(root,865,672);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
				
			}

		// Change Scene to Administrator Adds Passenger
			public void goToAdminAddsPassenger(Stage stage) throws IOException
			{
				String fxmlDocPath ="C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\application\\AdminAddsPassenger.fxml"; 
				FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
				AnchorPane root =(AnchorPane) loader.load(fxmlStream);
				
				Scene scene = new Scene(root,588,405);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
				
			}
			
		// Change Scene to Administrator Login & Sign-up Menu
			public void goToAdminLoginSignupMenu(Stage stage) throws IOException
			{
				String fxmlDocPath ="C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\application\\AdminLoginSignupMenu.fxml";
				FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
				AnchorPane root =(AnchorPane) loader.load(fxmlStream);
				
				Scene scene = new Scene(root,578,348);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
				
			}
			
		// Change Scene to Administrator Login
			public void goToAdminLogin(Stage stage) throws IOException
			{
				String fxmlDocPath ="C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\application\\AdminLogin.fxml"; 
				FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
				AnchorPane root =(AnchorPane) loader.load(fxmlStream);
				
				Scene scene = new Scene(root,588,333);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
				
			}

		// Change Scene to Administrator sing-up
			public void goToAdminSignup(Stage stage) throws IOException
			{
				String fxmlDocPath ="C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\application\\AdminSignup.fxml"; 
				FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
				AnchorPane root =(AnchorPane) loader.load(fxmlStream);
				
				Scene scene = new Scene(root,588,395);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
				
			}

}
