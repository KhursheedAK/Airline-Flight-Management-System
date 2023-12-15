package dataBase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import businessLogic.Administrator;
import businessLogic.Booking;
import businessLogic.Customer;
import businessLogic.FlightDetails;
import businessLogic.FlightSchedule;

public class AirlineData 
{
	public boolean flag;
	public BufferedWriter bw;
	
	public FlightSchedule flightS;
	public Booking bookingS;
	
	public static ArrayList<FlightDetails> fd = new ArrayList<FlightDetails>(100);
	public static ArrayList<FlightDetails> fdLocal = new ArrayList<FlightDetails>(100);
	public static ArrayList<FlightDetails> fdInter = new ArrayList<FlightDetails>(100);
	public static ArrayList<Customer> c = new ArrayList<Customer>(100);
	public static ArrayList<Administrator> a = new ArrayList<Administrator>(100);
	public static ArrayList<FlightSchedule> fs = new ArrayList<FlightSchedule>(100);
	public static ArrayList<Booking> b = new ArrayList<Booking>(100);
	
	public File dataFlight = new File("C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\availableFlights.txt");
	public File customerCredentials = new File("C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\customerCredentials.txt");
	public File bookedFlights = new File("C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\bookedFlights.txt");
	public File flightsScheduled = new File("C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\flightsScheduled.txt");
	public File localFlights = new File("C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\localFlights.txt");
	public File internationalFlights = new File("C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\internationalFlights.txt");
	
	public File adminCredentials = new File("C:\\Users\\survi\\Desktop\\Java Codes\\AirlineProjectGUI\\src\\adminCredentials.txt");
	
	// -- avaialableFlights file loader -- DONE//
	public void availableFlights() throws IOException
	{	
		try 
		{
		// reading and storing
		Scanner s = new Scanner(dataFlight);

		while(s.hasNextLine())
		{
			String data = s.nextLine();
			String[] info = data.split(" ");
			int foo = Integer.parseInt(info[0]);
			int id = foo;
			String departureAirport = info[1];
			String arrivalAirport = info[2];
			String flightHours = info[3];
			double foo2 = Double.parseDouble(info[4]);
			double costOfTravel = foo2;
			double foo3 = Double.parseDouble(info[5]);
			double distance = foo3;
		
			FlightDetails newFd = new FlightDetails(id, departureAirport, arrivalAirport, flightHours, costOfTravel, distance);
			fd.add(newFd);
		}

		s.close();
		// completed
		
		System.out.println("Successfully stored Flight Details from flightDetails.txt!!!");
		System.out.println();
	}
		catch(NullPointerException e)
		{
			System.out.println(e);
		}
	}
	
	// --avaialableLocalFlights file loader-- DONE//
		public void availableLocalFlights() throws IOException
		{	
			try 
			{
			// reading and storing
			Scanner s = new Scanner(localFlights);

			while(s.hasNextLine())
			{
				String data = s.nextLine();
				String[] info = data.split(" ");
				int foo = Integer.parseInt(info[0]);
				int id = foo;
				String departureAirport = info[1];
				String arrivalAirport = info[2];
				String flightHours = info[3];
				double foo2 = Double.parseDouble(info[4]);
				double costOfTravel = foo2;
				double foo3 = Double.parseDouble(info[5]);
				double distance = foo3;
			
				FlightDetails newFd = new FlightDetails(id, departureAirport, arrivalAirport, flightHours, costOfTravel, distance);
				fdLocal.add(newFd);
			}
			
			s.close();
			// completed
			
			System.out.println("Successfully stored Flight Details from localFlight.txt!!!");
			System.out.println();
		}
			catch(NullPointerException e)
			{
				System.out.println(e);
			}
		}
		
		// -- avaialableInternationalFlights file loader -- DONE//
				public void availableInternationalFlights() throws IOException
				{	
					try 
					{
					// reading and storing
					Scanner s = new Scanner(internationalFlights);

					while(s.hasNextLine())
					{
						String data = s.nextLine();
						String[] info = data.split(" ");
						int foo = Integer.parseInt(info[0]);
						int id = foo;
						String departureAirport = info[1];
						String arrivalAirport = info[2];
						String flightHours = info[3];
						double foo2 = Double.parseDouble(info[4]);
						double costOfTravel = foo2;
						double foo3 = Double.parseDouble(info[5]);
						double distance = foo3;
					
						FlightDetails newFd = new FlightDetails(id, departureAirport, arrivalAirport, flightHours, costOfTravel, distance);
						fdInter.add(newFd);
					}
					
					s.close();
					// completed
					
					System.out.println("Successfully stored Flight Details from internationalFlight.txt!!!");
					System.out.println();
				}
					catch(NullPointerException e)
					{
						System.out.println(e);
					}
				}
	
	//--confirm ticket reservation and storing to file--//
	public boolean confirmReservation(int slot, int ticketID, int flightID, String arrivalAirport, String departureAirport, String departureDate, int seatQty, String isFlightLate, Booking booking) throws IOException
	{
		FlightSchedule newfs = new FlightSchedule(slot, ticketID, flightID, arrivalAirport, departureAirport, departureDate, seatQty, isFlightLate);
		fs.add(newfs);
		b.add(booking);
		
		// saving booked flights to file
		bw = new BufferedWriter(new FileWriter(bookedFlights, true));
		
			try {
			//ticketID, flightID, flightType , seatType, seatQty, price, reason, status, name, cnic
				bw.write(booking.getTicketID()+" ");
				bw.write(booking.getFlightID()+" ");
				bw.write(booking.getFlightType()+" ");
				bw.write(booking.getSeatClass()+" ");
				bw.write(booking.getSeatQty()+" ");
				bw.write(booking.getPrice()+" ");
				bw.write(booking.getReason()+" ");
				bw.write(booking.getStatus()+" ");
				bw.write(booking.getName()+" ");
				bw.write(booking.getCnic()+" ");
				bw.newLine();
				
				bw.flush();
				bw.close();
				
			}catch(NullPointerException e)
			{
				System.out.println("Error !!");
			}
		bw.close();
		
		
		// saving flights scheduled to files
		// saving to file
				bw = new BufferedWriter(new FileWriter(flightsScheduled, true));
				
					try {
					//slot, ticketID, flightID, arrivalAirport, departureAirport, departureDate, seatQty, isFlightLate
						bw.write(newfs.getSlot()+" ");
						bw.write(newfs.getTicketID()+" ");
						bw.write(newfs.getFlightID()+" ");
						bw.write(newfs.getArrival_Airport()+" ");
						bw.write(newfs.getDeparture_Airport()+" ");
						bw.write(newfs.getDeparture_Date()+" ");
						bw.write(newfs.getSeatQty()+" ");
						bw.write(newfs.isIs_Flight_Late()+" ");
						bw.newLine();
						
						bw.flush();
						bw.close();
						
					}catch(NullPointerException e)
					{
						System.out.println("Error !!");
					}
				bw.close();
				
				
		
		for(int i=0; i<fs.size(); i++)
		{
			if(fs.get(i).getSlot() == slot)
			{
				flag = true;
				return flag;
			}
		}
		
		return flag;	
	}
	
	// store all booked information to program
	public void getAllBookedTickets() throws FileNotFoundException
	{
		// booked tickets
		try 
		{
		// reading and storing
		Scanner s = new Scanner(bookedFlights);

		while(s.hasNextLine())
		{	//ticketID, flightID, flightType , seatType, seatQty, price, reason, status, name, cnic
			String data = s.nextLine();
			String[] info = data.split(" ");
			
			int ticketID = Integer.parseInt(info[0]);
			int flightID = Integer.parseInt(info[1]);
			String flightType = info[2];
			String seatType = info[3];
			int seatQty = Integer.parseInt(info[4]);
			double price = Double.parseDouble(info[5]);
			String reason = info[6];
			String status = info[7];
			String name = info[8];
			String cnic = info[9];
		
			Booking oldBook = new Booking(ticketID, flightID, flightType , seatType, seatQty, price, reason, status, name, cnic);
			b.add(oldBook);
		}

		s.close();
		// completed
		
		System.out.println("Successfully stored booked flights from bookedFlights.txt!!!");
		System.out.println();
	}
		catch(NullPointerException e)
		{
			System.out.println("");
		}
		
		
		// flights scheduled
		try 
		{
		// reading and storing
		Scanner s = new Scanner(flightsScheduled);

		while(s.hasNextLine())
		{//slot, ticketID, flightID, arrivalAirport, departureAirport, departureDate, seatQty, isFlightLate
			String data = s.nextLine();
			String[] info = data.split(" ");
			
			int slot = Integer.parseInt(info[0]);
			int ticketID = Integer.parseInt(info[1]);
			int flightID = Integer.parseInt(info[2]);
			String arrivalAirport = info[3];
			String departureAirport = info[4];
			String departureDate = info[5];
			int seatQty = Integer.parseInt(info[6]);
			String isFlightLate = info[7];
		
			FlightSchedule oldFlight = new FlightSchedule(slot, ticketID, flightID, arrivalAirport , departureAirport, departureDate, seatQty, isFlightLate);
			fs.add(oldFlight);
		}

		s.close();
		// completed
		
		System.out.println("Successfully stored Flight Details from flightScheduled.txt!!!");
		System.out.println();
	}
		catch(NullPointerException e)
		{
			System.out.println("");
		}
	}
	
	//-- Update Reservation File--//
	public void saveUpdatedReservation(int ticketID, String date, String seatType) throws IOException 
	{
		
		for(int i=0; i<fs.size(); i++)
		{
			if(fs.get(i).getTicketID() == ticketID)
			{	
				flightS = fs.get(i);
				flightS.setDeparture_Date(date);
			}
		}
		
		for(int i=0; i<b.size(); i++)
		{
			if(b.get(i).getTicketID()==ticketID)
			{	
				bookingS = b.get(i);
				bookingS.setSeatClass(seatType);
			}
		}
		
		// updating flights scheduled file
		
		FileWriter writer = new FileWriter(flightsScheduled);
		
		BufferedWriter br = new BufferedWriter(writer);
		PrintWriter pr = new PrintWriter(br);
		
			
		
			for(int i =0; i<fs.size();i++)
			{
				
				 if(fs.get(i)==null)
				{
					// do nothing
				}
				 
				else if(fs.get(i)!=null)
				{	
					if(fs.get(i).getTicketID() == ticketID)
					{		//slot, ticketID, flightID, arrivalAirport, departureAirport, departureDate, seatQty, isFlightLate
						pr.print(fs.get(i).getSlot()+" ");
						pr.print(fs.get(i).getTicketID()+" ");
						pr.print(fs.get(i).getFlightID()+" ");
						pr.print(fs.get(i).getArrival_Airport()+" ");
						pr.print(fs.get(i).getDeparture_Airport()+" ");
						pr.print(fs.get(i).getDeparture_Date()+" ");
						pr.print(fs.get(i).getSeatQty()+" ");
						pr.println(fs.get(i).isIs_Flight_Late());
				
					}
				} 
			}
			br.close();
			pr.close();
			writer.close();
			
			
			// updating booked flights file
			
			FileWriter writer2 = new FileWriter(bookedFlights);
			
			BufferedWriter br2 = new BufferedWriter(writer2);
			PrintWriter pr2 = new PrintWriter(br2);
			
				
			
				for(int i =0; i<b.size();i++)
				{
					
					 if(b.get(i)==null)
					{
						// do nothing
					}
					 
					else if(b.get(i)!=null)
					{	
						if(b.get(i).getTicketID() == ticketID)
						{		//ticketID, flightID, flightType , seatType, seatQty, price, reason, status, name, cnic
							pr2.print(b.get(i).getTicketID()+" ");
							pr2.print(fs.get(i).getFlightID()+" ");
							pr2.print(b.get(i).getFlightType()+" ");
							pr2.print(b.get(i).getSeatClass()+" ");
							pr2.print(b.get(i).getSeatQty()+" ");
							pr2.print(b.get(i).getPrice()+" ");
							pr2.print(b.get(i).getReason()+" ");
							pr2.print(b.get(i).getStatus()+" ");
							pr2.print(b.get(i).getName()+" ");
							pr2.println(b.get(i).getCnic()+" ");
					
						}
					} 
				}
				br2.close();
				pr2.close();
				writer2.close();
			
			System.out.println(" Information Updated !!!");
		//
	}
		
	//--Saving Added Passengers to File by Admin-- DONE//
	public boolean saveAddedPassenger(Customer customer) throws IOException
	{	
		// saving to file
		bw = new BufferedWriter(new FileWriter(customerCredentials, true));
		
			try {
			
				bw.write(customer.getName()+" ");
				bw.write(customer.getPassword()+" ");
				bw.write(customer.getCnic()+" ");
				bw.write(customer.getEmail()+" ");
				bw.write(customer.getAge()+" ");
				bw.write(customer.getGender()+" ");
				bw.newLine();
				
				bw.flush();
				bw.close();
				
			}catch(NullPointerException e)
			{
				System.out.println("Error !!");
			}
		bw.close();
		
		
		return flag;
	}
	
												// CUSTOMER FUNCTIONS
	
	//--Saving Registered Customer Credentials to File--//
	public boolean saveCustomerCredentials(Customer customer) throws IOException
	{
		
		// saving to file
		bw = new BufferedWriter(new FileWriter(customerCredentials, true));
		
			try {
			
				bw.write(customer.getName()+" ");
				bw.write(customer.getPassword()+" ");
				bw.write(customer.getCnic()+" ");
				bw.write(customer.getEmail()+" ");
				bw.write(customer.getAge()+" ");
				bw.write(customer.getGender()+" ");
				bw.newLine();
				
				bw.flush();
				bw.close();
				
			}catch(NullPointerException e)
			{
				System.out.println("Error !!");
			}
		bw.close();
		
		return flag;
	}
	
	//-- get all registered customers--//
	public void getAllUsers() throws FileNotFoundException
	{
		
		//reading and storing pre-existing data
		try 
		{
		// reading and storing
		Scanner s = new Scanner(customerCredentials);

		while(s.hasNextLine())
		{
			String data = s.nextLine();
			String[] info = data.split(" ");
			String name1 = info[0];
			String password1 = info[1];
			String cnic = info[2];
			String email = info[3];
			int foo = Integer.parseInt(info[4]);
			int age = foo;
			String gender = info[5];
		
			Customer newCustomer = new Customer(name1, password1, cnic, email, age, gender);
			c.add(newCustomer);
		}

		s.close();
		// completed
		
		System.out.println("Successfully stored registered Customers from customerCredentials.txt!!!");
		System.out.println();
	}
		catch(NullPointerException e)
		{
			System.out.println("");
		}
	}
	
											// ADMINISTRATOR FUNCTIONS
	
	//--Saving Administrator Signup Credentials--//
	public boolean saveAdminCredentials(Administrator admin) throws IOException
	{
		// saving to file
		bw = new BufferedWriter(new FileWriter(adminCredentials, true));
		
			try {
			
				bw.write(admin.getEmployee_id()+" ");
				bw.write(admin.getEmployee_name()+" ");
				bw.write(admin.getCnic()+" ");
				bw.write(admin.getGender()+" ");
				bw.write(admin.getAge()+" ");
				bw.write(admin.getPassword()+" ");
				bw.newLine();
				
				bw.flush();
				bw.close();
				
			}catch(NullPointerException e)
			{
				System.out.println("Error !!");
			}
		bw.close();
		
		return flag;
	}
	
	//-- Get all Registered Administrators--//
	public void getAllAdmins() throws FileNotFoundException
	{
		//reading and storing pre-existing data
		try 
		{
		// reading and storing
		Scanner s = new Scanner(adminCredentials);

		while(s.hasNextLine())
		{
			String data = s.nextLine();
			String[] info = data.split(" ");
			
			int id = Integer.parseInt(info[0]);
			String name = info[1];
			String cnic = info[2];
			String gender = info[3];
			int age = Integer.parseInt(info[4]);
			String password = info[5];
		
			Administrator oldAdmin = new Administrator(id, name, cnic, gender, age, password);
			a.add(oldAdmin);
		}

		s.close();
		// completed
		
		System.out.println("Successfully stored registered Admins from adminCredentials.txt!!!");
		System.out.println();
	}
		catch(NullPointerException e)
		{
			System.out.println("");
		}
	}

	// -- Update Database for Reschedule Flight Information -- DONE//
	public Booking updateRescheduleFlightInformation(int ticketID, String reason, String date) throws IOException 
	{	
		
		for(int i=0; i<fs.size(); i++)
		{
			if(fs.get(i).getTicketID() == ticketID)
			{	
				flightS = fs.get(i);
				flightS.setIs_Flight_Late("Post-Poned");
				flightS.setDeparture_Date(date);
				
				fs.get(i).setIs_Flight_Late("Post-Poned");
				fs.get(i).setDeparture_Date(date);
			}
		}
		
		for(int i=0; i<b.size(); i++)
		{
			if(b.get(i).getTicketID()==ticketID)
			{	
				bookingS = b.get(i);
				bookingS.setReason(reason);
				bookingS.setStatus("Post-Poned");
				
				b.get(i).setReason(reason);
				b.get(i).setStatus("Post-Poned");
			}
		}
		
		
		// updating flights scheduled file
		
		FileWriter writer = new FileWriter(flightsScheduled);
		
		BufferedWriter br = new BufferedWriter(writer);
		PrintWriter pr = new PrintWriter(br);
		
			
		
			for(int i =0; i<fs.size();i++)
			{
				
				 if(fs.get(i)==null)
				{
					// do nothing
				}
				 
				else if(fs.get(i)!=null)
				{	
					if(fs.get(i).getTicketID() == ticketID)
					{		//slot, ticketID, flightID, arrivalAirport, departureAirport, departureDate, seatQty, isFlightLate
						pr.print(fs.get(i).getSlot()+" ");
						pr.print(fs.get(i).getTicketID()+" ");
						pr.print(fs.get(i).getFlightID()+" ");
						pr.print(fs.get(i).getArrival_Airport()+" ");
						pr.print(fs.get(i).getDeparture_Airport()+" ");
						pr.print(fs.get(i).getDeparture_Date()+" ");
						pr.print(fs.get(i).getSeatQty()+" ");
						pr.println(fs.get(i).isIs_Flight_Late());
				
					}
				} 
			}
			br.close();
			pr.close();
			writer.close();
			
			
			// updating booked flights file
			
			FileWriter writer2 = new FileWriter(bookedFlights);
			
			BufferedWriter br2 = new BufferedWriter(writer2);
			PrintWriter pr2 = new PrintWriter(br2);
			
				
			
				for(int i =0; i<b.size();i++)
				{
					
					 if(b.get(i)==null)
					{
						// do nothing
					}
					 
					else if(b.get(i)!=null)
					{	
						if(b.get(i).getTicketID() == ticketID)
						{		//ticketID, flightID, flightType , seatType, seatQty, price, reason, status, name, cnic
							pr2.print(b.get(i).getTicketID()+" ");
							pr2.print(fs.get(i).getFlightID()+" ");
							pr2.print(b.get(i).getFlightType()+" ");
							pr2.print(b.get(i).getSeatClass()+" ");
							pr2.print(b.get(i).getSeatQty()+" ");
							pr2.print(b.get(i).getPrice()+" ");
							pr2.print(b.get(i).getReason()+" ");
							pr2.print(b.get(i).getStatus()+" ");
							pr2.print(b.get(i).getName()+" ");
							pr2.println(b.get(i).getCnic()+" ");
					
						}
					} 
				}
				br2.close();
				pr2.close();
				writer2.close();
			
			System.out.println(" Information Updated !!!");
		
		return bookingS;
	}
	
	
	public void updateCancelledFlightsAndTickets() throws IOException
	{
		// updating flights scheduled file
		
		FileWriter writer = new FileWriter(flightsScheduled);
		
		BufferedWriter br = new BufferedWriter(writer);
		PrintWriter pr = new PrintWriter(br);
		
			
		
			for(int i =0; i<fs.size();i++)
			{
				
				 if(fs.get(i)==null)
				{
					// do nothing
				}
				 
				else if(fs.get(i)!=null)
				{	
					
					//slot, ticketID, flightID, arrivalAirport, departureAirport, departureDate, seatQty, isFlightLate
					pr.print(fs.get(i).getSlot()+" ");
					pr.print(fs.get(i).getTicketID()+" ");
					pr.print(fs.get(i).getFlightID()+" ");
					pr.print(fs.get(i).getArrival_Airport()+" ");
					pr.print(fs.get(i).getDeparture_Airport()+" ");
					pr.print(fs.get(i).getDeparture_Date()+" ");
					pr.print(fs.get(i).getSeatQty()+" ");
					pr.println(fs.get(i).isIs_Flight_Late());
				
					
				} 
			}
			br.close();
			pr.close();
			writer.close();
			
			
			// updating booked flights file
			
			FileWriter writer2 = new FileWriter(bookedFlights);
			
			BufferedWriter br2 = new BufferedWriter(writer2);
			PrintWriter pr2 = new PrintWriter(br2);
			
				
			
				for(int i =0; i<b.size();i++)
				{
					
					 if(b.get(i)==null)
					{
						// do nothing
					}
					 
					else if(b.get(i)!=null)
					{	

						//ticketID, flightID, flightType , seatType, seatQty, price, reason, status, name, cnic
						pr2.print(b.get(i).getTicketID()+" ");
						pr2.print(fs.get(i).getFlightID()+" ");
						pr2.print(b.get(i).getFlightType()+" ");
						pr2.print(b.get(i).getSeatClass()+" ");
						pr2.print(b.get(i).getSeatQty()+" ");
						pr2.print(b.get(i).getPrice()+" ");
						pr2.print(b.get(i).getReason()+" ");
						pr2.print(b.get(i).getStatus()+" ");
						pr2.print(b.get(i).getName()+" ");
						pr2.println(b.get(i).getCnic()+" ");
					
						
					} 
				}
				br2.close();
				pr2.close();
				writer2.close();
			
			System.out.println(" Information Updated !!!");
	}
	
	
	// -- Update Database for Reschedule Flight Information -- DONE//
		public void updateFareInfoInFile(int ticketID, double amount) throws IOException 
		{	
			for(int i=0; i<b.size(); i++)
			{
				if(b.get(i).getTicketID()==ticketID)
				{			
					b.get(i).setPrice(amount);;
				}
			}
				// updating booked flights file
				
				FileWriter writer2 = new FileWriter(bookedFlights);
				
				BufferedWriter br2 = new BufferedWriter(writer2);
				PrintWriter pr2 = new PrintWriter(br2);
				
					
				
					for(int i =0; i<b.size();i++)
					{
						
						 if(b.get(i)==null)
						{
							// do nothing
						}
						 
						else if(b.get(i)!=null)
						{	
							if(b.get(i).getTicketID() == ticketID)
							{		//ticketID, flightID, flightType , seatType, seatQty, price, reason, status, name, cnic
								pr2.print(b.get(i).getTicketID()+" ");
								pr2.print(fs.get(i).getFlightID()+" ");
								pr2.print(b.get(i).getFlightType()+" ");
								pr2.print(b.get(i).getSeatClass()+" ");
								pr2.print(b.get(i).getSeatQty()+" ");
								pr2.print(b.get(i).getPrice()+" ");
								pr2.print(b.get(i).getReason()+" ");
								pr2.print(b.get(i).getStatus()+" ");
								pr2.print(b.get(i).getName()+" ");
								pr2.println(b.get(i).getCnic()+" ");
						
							}
						} 
					}
					br2.close();
					pr2.close();
					writer2.close();
				
				System.out.println(" Information Updated !!!");
	
		}
}
