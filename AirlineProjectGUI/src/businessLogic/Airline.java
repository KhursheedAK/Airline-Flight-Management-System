package businessLogic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import dataBase.AirlineData;

public class Airline 
{
	boolean flag = false;
	
	Administrator admin = new Administrator();
	Customer customer = new Customer();
	Booking booking = new Booking();
	Flight flight = new Flight();
	FlightDetails flightDetails = new FlightDetails();
	FlightSchedule flightSchedule = new FlightSchedule();
	AirlineData ad = new AirlineData();
	
											// Administrator Functions
	
	// -- Administrator Sign Up -- DONE//
	public boolean signupAdmin(int empId, String name, String cnic, String gender, int age, String password) throws IOException
	{
		flag = admin.signupAdmin(empId, name, cnic, gender, age, password);
		return flag;
	}
	
	//-- Get all administrator--//
	public void getAllAdmins() throws FileNotFoundException
	{
		ad.getAllAdmins();
	}
	
	// -- Administrator Login DONE -- //
	public boolean loginAdmin(int empId, String password)
	{
		flag = admin.loginAdmin(empId, password);
		return flag;
	}
	
	//-- reschedule Flight--//
	public Booking rescheduleFlight(int ticketID, String reason, String date) throws IOException 
	{
		booking = flight.rescheduleFlight(ticketID, reason, date);
		
		if(booking == null)
		{
			return null;
		}
		
		return booking;
	}
	
	//--get flight information by flight ID--//
	public Booking getFlightInformationFlight(int flightID)
	{
		booking = booking.getFlightInformationFlight(flightID);
		
		if(booking == null)
		{
			return null;
		}
		return booking;
	}
	
	//-- cancel flight-- DONE//
	public boolean cancelFlight(int flightCode) throws IOException
	{
		boolean flag = flight.cancelFlight(flightCode);
		return flag;
	}
	
	//--adds Passenger--//
	public boolean addPassenger(String name, String password, String cnic, String email, int age, String gender) throws IOException
	{
		boolean flag = admin.addPassenger(name, password, cnic, email, age, gender);
		
		return flag;
	}
	
	
														// Customer Functions
	
	//--sign up--//
	public boolean signupCustomer(String name, String password, String cnic, String email, int age, String gender) throws IOException
	{
		flag = customer.signupCustomer(name, password, cnic, email, age , gender);
		
		return flag;
	}
	
	//--login--//
	public boolean loginCustomer(String name, String password) throws FileNotFoundException
	{
		boolean flag = customer.loginCustomer(name, password);
		return flag;
	}
	
	//-- load available flight data -- DONE//
	public void availableFlights() throws IOException
	{
		ad.availableFlights();
	}
	
	//-- load available local flight data -- DONE//
	public void availableLocalFlights() throws IOException
	{
		ad.availableLocalFlights();
	}
	
	//-- load available international flight data -- DONE//
	public void availableInterFlights() throws IOException
	{
		ad.availableInternationalFlights();
	}
	
	// -- show flight information -- DONE//
	public FlightDetails flightInformation(String da, String aa)
	{
		FlightDetails fd = flightDetails.flightInformation(da, aa);
		
		if(fd == null)
		{
			return null;
		}
		
		return fd;
	}
	
	// -- show Local flight information -- DONE//
	public FlightDetails localFlightInformation(String da, String aa)
	{
		FlightDetails fdLocal = flightDetails.localFlightInformation(da, aa);
		
		if(fdLocal == null)
		{
			return null;
		}
		
		return fdLocal;
	}
	
	// -- show International flight information -- DONE//
	public FlightDetails internationalFlightInformation(String da, String aa)
	{
		FlightDetails fdInter = flightDetails.internationalFlightInformation(da, aa);
		
		if(fdInter == null)
		{
			return null;
		}
		
		return fdInter;
	}
	
	// -- show fare-- DONE//
	public double confirmToViewFare(int slot, int seatQty, String seatType) throws IOException
	{
		double amount = booking.reserveSeat(slot, seatQty, seatType);
		
		if(amount==0)
		{
			return 0;
		}
		
		return amount;
	}
	
	//-- confirm reservation--//
	public boolean confirmReservation(int slot, String arrivalAirport, String departureAirport, String departureDate, int seatQty, String isFlightLate, String flightType, String seatType, double amount, String name, String cnic) throws IOException
	{
		flag = booking.confirmReservation(slot, arrivalAirport, departureAirport, departureDate, seatQty, isFlightLate, flightType, seatType, amount, name, cnic);
		
		if(flag==true)
		{
			bookingInfo(cnic);
		}
		return flag;
	}
	
	//--show booking info--..
	public Booking bookingInfo(String cnic)
	{
		booking = booking.bookingInfo(cnic);
		
		if(booking == null)
		{
			return null;
		}
		
		return booking;
	}
	
	// -- check Flight Status -- DONE//
	public String getStatusOfFlight(int ticketID)
	{
		String status = flightSchedule.getStatusOfFlight(ticketID);
		
		if(status == null)
		{
			return null;
		}
		
		return status;
	}
	
	// -- Get flight information -- DONE//
	public Booking getFlightInformation(int ticketID)
	{
		booking = booking.getFlightInformation(ticketID);
		
		if(booking == null)
		{
			return null;
		}
		
		return booking;
	}
	
	// -- get Ticket information -- DONE//
	public FlightSchedule getTicketInformation(int ticketID)
	{
		flightSchedule = flightSchedule.getTicketInformation(ticketID);
		
		if(flightSchedule == null)
		{
			return null;
		}
		
		return flightSchedule;
	}
	
	// -- load booked tickets to program -- DONE//
	public void getAllBookedTickets() throws FileNotFoundException
	{
		ad.getAllBookedTickets();
	}
	
	// -- load Registered Users -- DONE//
	public void getAllUsers() throws FileNotFoundException
	{
		ad.getAllUsers();
	}
	
	//-- update ticket--//
	public FlightSchedule updateTicket(int ticketID, String date, String seatType) throws IOException
	{
		flightSchedule = flightSchedule.updateTicket(ticketID, date, seatType);
		
		if(flightSchedule == null)
		{
			return null;
		}
		
		return flightSchedule;
	}
	
	//-- update fare--//
	public Booking updateFare(int ticketID, String date, String seatType) throws IOException
	{
		booking = booking.updateReservationFare(ticketID, date, seatType);
		
		if(booking == null)
		{
			return null;
		}
		
		return booking;
	}
	
	//--cancel Ticket--DONE//
	public boolean cancelTicket(int ticketID) throws IOException
	{
		flag = flight.cancelTicket(ticketID);
		return flag;
	}
	
}
