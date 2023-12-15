package businessLogic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import dataBase.AirlineData;

public class Customer 
{
	AirlineData ad = new AirlineData();
	
	private String name;
	private int age;
	private String cnic;
	private String gender;
	private String email;
	private String password;

	// constructor
	public Customer(String name, String password, String cnic, String email, int age, String gender)
	{
		this.name = name;
		this.password = password;
		this.cnic = cnic;
		this.email = email;
		this.age = age;
		this.gender = gender;
	}

	public Customer(){};
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	// -- Customer Sign up Function -- DONE//
	public boolean signupCustomer(String name, String password, String cnic, String email, int age, String gender) throws IOException
	{
		Customer customer = new Customer(name, password, cnic, email, age, gender);
		
		ad.c.add(customer);
		
		for(int i=0; i<ad.c.size(); i++)
		{
			if(ad.c.get(i).getName().equalsIgnoreCase(name))
			{
				ad.flag = true;
			}
		}
		
		ad.saveCustomerCredentials(customer);
		
		return ad.flag;
	}
	
	// -- Customer Login Function -- DONE//
		public boolean loginCustomer(String name, String password) throws FileNotFoundException
		{	
			for(int i=0; i<ad.c.size(); i++)
			{
				if(ad.c.get(i).getName().equalsIgnoreCase(name) && ad.c.get(i).getPassword().equals(password))
				{
					ad.flag = true;
					break;
				}
			}
			return ad.flag;
		}
}
