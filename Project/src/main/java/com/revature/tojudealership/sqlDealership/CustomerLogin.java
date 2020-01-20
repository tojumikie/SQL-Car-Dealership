package com.revature.tojudealership.sqlDealership;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CustomerLogin {
	
	public static void CustomerMenu() {
		Scanner kb = new Scanner(System.in);
		int selection = 0;
		do {
			System.out.println("CUSTOMER MENU");
			System.out.println("select an option.");
			System.out.println("1. view the cars on the lot");
			System.out.println("2. make an offer for a car");
			System.out.println("3. view owned cars");
			System.out.println("4. view remaining payments for a car");
			System.out.println("5. exit customer menu");
			selection = kb.nextInt();
			switch(selection) {
			case 1:
				viewCarsOnLot();
				break;
			case 2:
				makeOffer();
				break;
			}
		} while(selection != 5);
	}
	
	public static void viewCarsOnLot() {
		EmployeeLogin.displayCars();
	}
	
	public static void makeOffer() {
		Scanner kb = new Scanner(System.in);
		//CustomerMenu();
		viewCarsOnLot();
		String carName;
		int offerPrice;
		System.out.println("Type the name of the vehicle");
		carName = kb.nextLine();
		System.out.println("Type the offer price as an integer");
		offerPrice = kb.nextInt();
		String sql = "insert into offers (name, price) values ('" + carName + "'" + "," + "'" + offerPrice + "');";
		//String sql2 = "SELECT * FROM cars WHERE name = '" + u + "' and \"password\" = '" + p + "';";
		//System.out.println(sql);
		try (Connection conn = DriverManager.getConnection(DriverClass.URL, DriverClass.USERNAME, DriverClass.PASSWORD)) {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		String test = "2007 Mercedes-Benz S-Class V12";
		//CustomerMenu();
		String sql2 = "SELECT * FROM cars WHERE name = '" + test + ";'";
		System.out.println(sql2);
	}
}
