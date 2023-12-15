package businessLogic;

import java.io.IOException;
import java.util.Scanner;

import dataBase.AirlineData;

public class Administrator 
{
	AirlineData ad = new AirlineData();
	
	private int employee_id;
	private String employee_name;
	private String cnic;
	private String gender;
	private int age;
	private String password;
	
	public Administrator(int employee_id, String employee_name, String cnic, String gender, int age, String password )
	{
		this.employee_id=employee_id;
		this.employee_name=employee_name;
		this.cnic=cnic;
		this.gender=gender;
		this.age=age;
		this.password=password;
	}
	
	Administrator(){};
	
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getCnic() {
		return cnic;
	}

	public void setCnic(String cnic) {
		this.cnic = cnic;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//--Add Passenger DONE--//
	public boolean addPassenger(String name, String password, String cnic, String email, int age, String gender) throws IOException
	{
		
		Customer customer = new Customer (name, password, cnic, email, age, gender);
		
		ad.c.add(customer);
		
		for(int i=0; i<ad.c.size(); i++)
		{
			if(ad.c.get(i).getName().equalsIgnoreCase(customer.getName()))
			{
				ad.flag = true;
			}
		}
		
		ad.saveAddedPassenger(customer);
		
		return ad.flag;
	}
	
	// -- Administrator Login -- DONE//
		public boolean loginAdmin(int empId, String password)
		{
			for(int i=0; i<ad.a.size(); i++)
			{
				if(ad.a.get(i).getEmployee_id() == (empId) && ad.a.get(i).getPassword().equals(password))
				{
					ad.flag = true;
					break;
				}
			}
			return ad.flag;
		}
		
		//--administrator sign up--//
		public boolean signupAdmin(int id, String name, String cnic, String gender, int age, String password) throws IOException
		{
			Administrator admin = new Administrator(id, name, cnic, gender, age, password);

			ad.a.add(admin);

			for(int i=0; i<ad.a.size(); i++)
			{
				if(ad.a.get(i).getEmployee_name().equalsIgnoreCase(name))
				{
					ad.flag = true;
				}
			}
			
			ad.saveAdminCredentials(admin);
			
			return ad.flag;
		}
	
}
