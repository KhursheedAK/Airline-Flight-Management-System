package businessLogic;

import java.util.ArrayList;
import java.util.Scanner;

import dataBase.AirlineData;

public class FlightDetails 
{
	
	AirlineData ad = new AirlineData();
	
	private int slotId;
	private String departure_Airport;
	private String arrival_Airport;
	private String flight_hours;
	private double cost_of_travel;
	private double distance;
	
	public FlightDetails(int slotId, String departure_Airport, String arrival_Airport, String flight_hours, double cost_of_travel,double distance)
	{
		this.slotId = slotId;
		this.flight_hours=flight_hours;
		this.cost_of_travel=cost_of_travel;
		this.distance=distance;
		this.departure_Airport=departure_Airport;
		this.arrival_Airport=arrival_Airport;
	}
	
	public FlightDetails(){}
	
	public int getSlotId()
	{
		return slotId;
	}
	
	public void setSlotId(int slotId)
	{
		this.slotId = slotId;
	}
	
	public String getFlight_hours() 
	{
		return flight_hours;
	}

	public void setFlight_hours(String flight_hours) 
	{
		this.flight_hours = flight_hours;
	}

	public double getCost_of_travel() 
	{
		return cost_of_travel;
	}

	public void setCost_of_travel(double cost_of_travel) 
	{
		this.cost_of_travel = cost_of_travel;
	}

	public double getDistance() 
	{
		return distance;
	}

	public void setDistance(double distance) 
	{
		this.distance = distance;
	}
	
	public String getDeparture_Airport() 
	{
		return departure_Airport;
	}

	public void setDeparture_Airport(String departure_Airport) 
	{
		this.departure_Airport = departure_Airport;
	}

	public String getArrival_Airport() 
	{
		return arrival_Airport;
	}

	public void setArrival_Airport(String arrival_Airport) 
	{
		this.arrival_Airport = arrival_Airport;
	}

	
	public String toString()
	{
		return "Slot ID: "+this.slotId+" | Departure Airport: "+this.departure_Airport+" | Arrival Airport: "+this.arrival_Airport+" | Flight Hours: "+this.flight_hours+
				" | Cost of Travel: "+this.cost_of_travel+" | Distance: "+this.distance;
	}
	
	// -- show flight information -- DONE//
	public FlightDetails flightInformation(String da, String aa)
	{
		for(int i=0; i<ad.fd.size(); i++)
		{
			if(ad.fd.get(i).getDeparture_Airport().equalsIgnoreCase(da) && ad.fd.get(i).getArrival_Airport().equalsIgnoreCase(aa))
			{
				return ad.fd.get(i);
			}
		}
		return null;
	}
	
	// -- show Local flight information -- DONE//
	public FlightDetails localFlightInformation(String da, String aa)
	{
		for(int i=0; i<ad.fdLocal.size(); i++)
		{
			if(ad.fdLocal.get(i).getDeparture_Airport().equalsIgnoreCase(da) && ad.fdLocal.get(i).getArrival_Airport().equalsIgnoreCase(aa))
			{
				return ad.fdLocal.get(i);
			}
		}
		return null;
	}
	
	// -- show flight information -- DONE//
	public FlightDetails internationalFlightInformation(String da, String aa)
	{
		for(int i=0; i<ad.fdInter.size(); i++)
		{
			if(ad.fdInter.get(i).getDeparture_Airport().equalsIgnoreCase(da) && ad.fdInter.get(i).getArrival_Airport().equalsIgnoreCase(aa))
			{
				return ad.fdInter.get(i);
			}
		}
		return null;
	}
}
