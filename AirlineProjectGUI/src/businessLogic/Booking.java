package businessLogic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import dataBase.AirlineData;

public class Booking 
{
	
	// int tokenForTicket = 0; int tokenForFlight = 0;  
	 int min = 25;
	 int max = 3500;
	
	Customer customer = new Customer();
	AirlineData ad = new AirlineData();
	/*
	 * ArrayList<Booking> booking = new ArrayList<Booking>();
	 */	
	private int ticketID;
	private int flightID;
	private String flightType;
	private double price;
	private String seatClass;
	private int seatQty;
	private String reason;
	private String status;
	private String name;
	private String cnic;
	
	public Booking (int ticketID, int flightID, String flightType , String seatType, int seatQty, double price, String reason, String status, String name, String cnic)
	{
		this.ticketID=ticketID;
		this.flightID=flightID;
		this.flightType=flightType;
		this.seatClass=seatType;
		this.seatQty=seatQty;
		this.price=price;
		this.reason=reason;
		this.status=status;
		this.name = name;
		this.cnic = cnic;
	}

	public Booking(){};
	
	public int getTicketID() 
	{
		return ticketID;
	}

	public void setTicketID(int ticketID) 
	{
		this.ticketID = ticketID;
	}
	
	public int getFlightID() 
	{
		return flightID;
	}

	public void setFlightID(int flightID) 
	{
		this.flightID = flightID;
	}
	
	public String getFlightType()
	{
		return flightType;
	}
	
	public void setFlightType(String flightType)
	{
		
	}
	
	public String getSeatClass()
	{
		return seatClass;
	}
	
	public void setSeatClass(String seatClass)
	{
		this.seatClass=seatClass;
	}

	public int getSeatQty()
	{
		return seatQty;
	}
	
	public void setSeatQty(int seatQty)
	{
		this.seatQty=seatQty;
	}

	public double getPrice() 
	{
		return price;
	}

	public void setPrice(double price) 
	{
		this.price = price;
	}
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnic() {
		return cnic;
	}

	public void setCnic(String cnic) {
		this.cnic = cnic;
	}

	public String toString()
	{
	    return "Flight ID: "+this.flightID+" | Ticket ID: "+this.ticketID+" | Seat Type: "+this.seatClass+" | Seat Quantity: "+this.seatQty+" | Price: "+this.price+
	    		" | Status: "+this.status+" | Reason: "+this.reason+" | Customer Info: "+this.name+" | Customer Cnic: "+this.cnic;
	}
	
	//--Book Ticket--//
	public double reserveSeat(int slot, int seatQty, String seatType) throws IOException
	{
		if(slot == 1 && seatType.equalsIgnoreCase("Economy"))
		{
			double amount = 12000 * seatQty;
			return amount;
		}
		
		else if(slot == 1 && seatType.equalsIgnoreCase("Business"))
		{
			double amount = 36000 * seatQty;
			return amount;
		}
		
		else if(slot == 2 && seatType.equalsIgnoreCase("Economy"))
		{
			double amount = 20000 * seatQty;
			return amount;
		}
		
		else if(slot == 2 && seatType.equalsIgnoreCase("Business"))
		{
			double amount = 50000 * seatQty;
			return amount;
		}
		
		else if(slot == 3 && seatType.equalsIgnoreCase("Economy"))
		{
			double amount = 20000 * seatQty;
			return amount;
		}
		
		else if(slot == 3 && seatType.equalsIgnoreCase("Business"))
		{
			double amount = 50000 * seatQty;
			return amount;
		}
		
		else if(slot == 4 && seatType.equalsIgnoreCase("Economy"))
		{
			double amount = 20000 * seatQty;
			return amount;
		}
		
		else if(slot == 4 && seatType.equalsIgnoreCase("Business"))
		{
			double amount = 50000 * seatQty;
			return amount;
		}
		return 0;	
	}
	
	//--confirm reservation--//
	public boolean confirmReservation(int slot, String arrivalAirport, String departureAirport, String departureDate, int seatQty, String isFlightLate, String flightType, String seatType, double amount, String name, String cnic) throws IOException
	{
		int random_int_for_Ticket = (int) Math.floor(Math.random() *(max-min+1)+min);
		int random_int_for_Flight = (int) Math.floor(Math.random() *(max-min+34)+min);
		
		this.ticketID = random_int_for_Ticket;
		this.flightID = random_int_for_Flight;
		this.name = name;
		this.cnic = cnic;
		this.reason = "-";
		this.price = amount;
		this.status = isFlightLate;
		Booking booking = new Booking (ticketID, flightID, flightType , seatType, seatQty, price, reason, status, name, cnic);
		boolean flag = ad.confirmReservation(slot, ticketID, flightID, arrivalAirport, departureAirport, departureDate, seatQty, isFlightLate, booking);
		bookingInfo(cnic);
		return flag;
	}
	
	// -- booking info -- DONE//
	public Booking bookingInfo(String cnic)
	{
		for(int i=0; i<ad.b.size(); i++)
		{
			if(ad.b.get(i).getCnic().equalsIgnoreCase(cnic))
			{
				return ad.b.get(i);
			}
		}
		return null;
	}
	
	// -- get flight information -- DONE//
	public Booking getFlightInformation(int ticketID)
	{
		for(int i=0; i<ad.b.size(); i++)
		{
			if(ad.b.get(i).getTicketID()==ticketID)
			{
				return ad.b.get(i);
			}
		}
		return null;
	}
	
	// -- get flight information- via flight- DONE//
	public Booking getFlightInformationFlight(int flightCode)
	{
		for(int i=0; i<ad.b.size(); i++)
		{
			if(ad.b.get(i).getFlightID()==flightCode)
			{
				return ad.b.get(i);
			}
		}
		return null;
	}
	
	// -- update Book Ticket -- DONE//
		public double updateReserveSeat(int slot, int seatQty, String seatType) throws IOException
		{
			double amount = 0;
			if(slot == 1 && seatType.equalsIgnoreCase("Economy"))
			{
				 amount = 12000 * seatQty;
				return amount;
			}
			
			else if(slot == 1 && seatType.equalsIgnoreCase("Business"))
			{
				 amount = 36000 * seatQty;
				return amount;
			}
			
			else if(slot == 2 && seatType.equalsIgnoreCase("Economy"))
			{
				amount = 20000 * seatQty;
				return amount;
			}
			
			else if(slot == 2 && seatType.equalsIgnoreCase("Business"))
			{
				amount = 50000 * seatQty;
				return amount;
			}
			return 0;	
		}
		
		
		//-- cancel Ticket--DONE//
		public boolean cancelTicket(int ticketID) throws IOException
		{
			for(int i=0; i<ad.b.size(); i++)
			{
				if(ad.b.get(i).getTicketID() == ticketID)
				{
					ad.bookingS = ad.b.get(i);
					ad.b.remove(i);
					ad.flag = true;
				}
			}
			
			for(int i=0; i<ad.fs.size(); i++)
			{
				if(ad.fs.get(i).getTicketID() == ticketID)
				{
					ad.flightS = ad.fs.get(i);
					ad.fs.remove(i);
				}
			}
			
			ad.updateCancelledFlightsAndTickets();
			
			return ad.flag;
		}
		
		// -- Reschedule Flight -- DONE//
		public Booking rescheduleFlight(int ticketID, String reason, String date) throws IOException 
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
					ad.b.get(i).setReason(reason);;
					
					ad.bookingS = ad.b.get(i);
				}
			}
			
			// -- update file in Database-- //
			ad.updateRescheduleFlightInformation(ticketID, reason, date);
			
			if(ad.bookingS == null)
			{
				return null;
			}
			
			return ad.bookingS;
		}
		
		// -- Update Fare -- DONE//
		public Booking updateReservationFare(int ticketID, String date, String seatType) throws IOException 
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
			
			// update file in database
			ad.updateFareInfoInFile(ticketID, amount);
			
			if(ad.bookingS == null)
			{
				return null;
			}
			
			return ad.bookingS;
		}

}
