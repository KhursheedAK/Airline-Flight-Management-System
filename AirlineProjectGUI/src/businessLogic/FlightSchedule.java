package businessLogic;

import java.io.IOException;
import java.util.ArrayList;

import dataBase.AirlineData;

public class FlightSchedule 
{
	AirlineData ad = new AirlineData();
	Booking booking = new Booking();
	
	private int slot;
	private String arrival_Airport;
	private String departure_Airport;
	private String departure_Date;
	private int seatQty;
	private String is_Flight_Late;
	private int ticketID;
	private int flightID;
	
	public FlightSchedule(int slot, int ticketID, int flightID, String arrival_Airport, String departure_Airport, String departure_Date, int seatQty, String is_Flight_Late)
	{
		this.slot = slot;
		this.seatQty = seatQty;
		this.arrival_Airport=arrival_Airport;
		this.departure_Airport=departure_Airport;
		this.departure_Date=departure_Date;
		this.is_Flight_Late=is_Flight_Late;
		this.ticketID=ticketID;
		this.flightID=flightID;
	}
	
	
	public FlightSchedule(){};
	
	public String getArrival_Airport() {
		return arrival_Airport;
	}

	public void setArrival_Airport(String arrival_Airport) {
		this.arrival_Airport = arrival_Airport;
	}

	public String getDeparture_Airport() {
		return departure_Airport;
	}

	public void setDeparture_Airport(String departure_Airport) {
		this.departure_Airport = departure_Airport;
	}

	public String getDeparture_Date() {
		return departure_Date;
	}

	public void setDeparture_Date(String departure_Date) {
		this.departure_Date = departure_Date;
	}

	public String isIs_Flight_Late() {
		return is_Flight_Late;
	}

	public void setIs_Flight_Late(String is_Flight_Late) {
		this.is_Flight_Late = is_Flight_Late;
	}

	public int getSlot() {
		return slot;
	}


	public void setSlot(int slot) {
		this.slot = slot;
	}


	public int getSeatQty() {
		return seatQty;
	}


	public void setSeatQty(int seatQty) {
		this.seatQty = seatQty;
	}
	
	
	public int getTicketID() {
		return ticketID;
	}


	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}


	public int getFlightID() {
		return flightID;
	}


	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}
	
	public String toString()
	{
		return "Slot: "+this.slot+" Ticket ID: "+this.ticketID+" | Flight ID: "+this.flightID+" | Arrival Airport: "+this.arrival_Airport+" | Departure Airport "+this.departure_Airport+" Departure Date: "+this.departure_Date+" | Seat Quantity: "+this.seatQty+" | Status: " +this.is_Flight_Late;
	}
	
	
	
																	//-- Functions -- //
	
	// -- get flight status -- DONE//
	public String getStatusOfFlight(int ticketID)
	{
		for(int i=0; i<ad.b.size(); i++)
		{
			if(ad.b.get(i).getTicketID()==ticketID)
			{
				return ad.b.get(i).getStatus();
			}
		}
		return null;
	}
		
	
	// -- get ticket information -- DONE//
	public FlightSchedule getTicketInformation(int ticketID)
	{
		for(int i=0; i<ad.fs.size(); i++)
		{
			if(ad.fs.get(i).getTicketID()==ticketID)
			{
				return ad.fs.get(i);
			}
		}
		return null;
	}
	
	//-- reschedule Ticket--//
	public Booking rescheduleFlight(int ticketID, String reason, String date) throws IOException 
	{
		booking = booking.rescheduleFlight(ticketID, reason, date);
		
		return booking;
	}
	
	//-- Cancel flight -- //
	public boolean cancelFlight(int flightCode) throws IOException
	{

		for(int i=0; i<ad.b.size(); i++)
		{
			if(ad.b.get(i).getFlightID() == flightCode)
			{
				ad.bookingS = ad.b.get(i);
				ad.b.remove(i);
				ad.flag = true;
			}
		}
		
		for(int i=0; i<ad.fs.size(); i++)
		{
			if(ad.fs.get(i).getFlightID() == flightCode)
			{
				ad.flightS = ad.fs.get(i);
				ad.fs.remove(i);
			}
		}
		
		
		ad.updateCancelledFlightsAndTickets();
		return ad.flag;
	}
	
	// -- Update Reservation -- //
	
	public FlightSchedule updateTicket(int ticketID, String date, String seatType) throws IOException
	{
		for(int i=0; i<ad.fs.size(); i++)
		{
			if(ad.fs.get(i).getTicketID() == ticketID)
			{
				ad.fs.get(i).setDeparture_Date(date);
				
				ad.flightS = ad.fs.get(i);
			}
		}
		
		for(int i=0; i<ad.b.size(); i++)
		{
			if(ad.b.get(i).getTicketID()==ticketID)
			{
				ad.b.get(i).setSeatClass(seatType);
				
				ad.bookingS = ad.b.get(i);
			}
		}
		
		int slot = ad.flightS.getSlot();
		int seatQty = ad.bookingS.getSeatQty();
		String newSeatType = ad.bookingS.getSeatClass();
		
		double amount = ad.bookingS.updateReserveSeat(slot, seatQty, newSeatType);
		
		ad.bookingS.setPrice(amount);
		
		ad.saveUpdatedReservation(ticketID, date, newSeatType);
		
		return ad.flightS;
	}
	
}
