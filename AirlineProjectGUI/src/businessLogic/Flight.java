package businessLogic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import application.AdminReschedulesFlightController;
import dataBase.AirlineData;

public class Flight 
{
	FlightDetails flightDetails = new FlightDetails();
	FlightSchedule flightSchedule = new FlightSchedule();
	Booking booking = new Booking();
	AirlineData ad = new AirlineData(); 
	
	Flight(Booking booking, FlightDetails flightDetails, FlightSchedule flightSchedule)
	{
		this.booking = booking;
		this.flightDetails=flightDetails;
		this.flightSchedule=flightSchedule;
	}	
	
	Flight(){};
	
	
	//-- Cancel Flight -- DONE//
	
	public boolean cancelFlight(int flightCode) throws IOException
	{
		boolean flag = flightSchedule.cancelFlight(flightCode);
		
		return flag;
	}
	
	//-- Cancel Ticket -- DONE//
	
	public boolean cancelTicket(int ticketNumber) throws IOException
	{
		boolean flag = booking.cancelTicket(ticketNumber);
		
		return flag;
	}
	
	//-- Reschedule Flight -- //
	
	public Booking rescheduleFlight(int ticketID, String reason, String date) throws IOException 
	{
		booking = booking.rescheduleFlight(ticketID, reason, date);
		
		return booking;
	}
}
