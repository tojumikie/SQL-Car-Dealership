package com.revature.tojudealership.sqlDealership;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeLogin {
	
	public static void EmployeeMenu() {
		Scanner kb = new Scanner(System.in);
		int selection = 0;
		do {
			System.out.println("EMPLOYEE MENU");
			System.out.println("select an option.");
			System.out.println("1. add or remove vehicles on the lot");
			System.out.println("2. view offers");
			System.out.println("3. view payments made by customers");
			System.out.println("4. exit employee menu");
			selection = kb.nextInt();
			switch(selection) {
			case 1:
				addOrRemoveCars();
				break;
			case 2:
				viewOffers();
				break;
			case 3:
				break;
			case 4:
				break;
			}
		} while(selection != 4);
	}
	
	public static void addOrRemoveCars() {
		displayCars();
		String decision;
		String carName;
		int carPrice;
		String sql;
		Scanner kb = new Scanner(System.in);
		System.out.println("Do you wish to add or remove a car to the lot?");
		decision = kb.nextLine();
		if(decision.equals("add")) {
			//System.out.println("add");
			System.out.println("Type in the name of the car that you would like to add.");
			carName = kb.nextLine();
			System.out.println("Type in the price of the car that you would like to add.");
			carPrice = kb.nextInt();
			sql = "insert into cars (name, price) values ('" + carName + "'" + "," + "'" + carPrice + "');";
			//System.out.println(sql);
			try (Connection conn = DriverManager.getConnection(DriverClass.URL, DriverClass.USERNAME, DriverClass.PASSWORD)) {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(decision.equals("remove")) {
			//System.out.println("remove");
			System.out.println("Type in the name of the car that you would like to remove.");
			carName = kb.nextLine();
			sql = "delete from cars where name = ('" + carName + "');";
			try (Connection conn = DriverManager.getConnection(DriverClass.URL, DriverClass.USERNAME, DriverClass.PASSWORD)) {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void viewOffers() {
		String offerDecision;
		Scanner kb = new Scanner(System.in);
		DriverClass.SQLConnect();
		try (Connection conn = DriverManager.getConnection(DriverClass.URL, DriverClass.USERNAME, DriverClass.PASSWORD)) {
			String sql = "select * from offers";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				//System.out.println(rs.getString("name") + "\t" + rs.getString("price"));
				System.out.printf("%30s: %10d%n", rs.getString("name"), rs.getInt("price"));
			}
			String sql2 = "insert into carsowned (name, value) select name, price from offers";
			String sql3 = "delete from offers";
			System.out.println();
			System.out.println("Do you want to accept the offer");
			offerDecision = kb.nextLine();
			if (offerDecision.equals("yes")) {
				System.out.println("Offer Accepted, vehicle has been sold.");
				// DriverClass.SQLConnect();
				// System.out.println(sql);
				stmt.executeUpdate(sql2);
				stmt.executeUpdate(sql3);
			}
				//Customers.paymentLeft = Customers.offerPrice;
			else if (offerDecision.equals("no")) {
				System.out.println("The offer has not been accepted");
				stmt.executeUpdate(sql3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void viewPayments() {
		
	}
	
	
	public static void displayCars() {
		//addOrRemoveCars();
//		String carName = "2007 Mercedes-Benz S-Class V12";
//		String sql = "delete from cars where name = ('" + carName + "');";
//		System.out.println(sql);
		DriverClass.SQLConnect();
		try (Connection conn = DriverManager.getConnection(DriverClass.URL, DriverClass.USERNAME, DriverClass.PASSWORD)) {
			String sql = "select * from cars";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				//System.out.println(rs.getString("name") + "\t" + rs.getString("price"));
				System.out.printf("%30s: %10d%n", rs.getString("name"), rs.getInt("price"));
			}
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public static void main(String[] args) {
		//addOrRemoveCars();
//		String carName = "2007 Mercedes-Benz S-Class V12";
//		String sql = "delete from cars where name = ('" + carName + "');";
//		System.out.println(sql);
//		DriverClass.SQLConnect();
//		try (Connection conn = DriverManager.getConnection(DriverClass.URL, DriverClass.USERNAME, DriverClass.PASSWORD)) {
//			String sql = "select * from cars";
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(sql);
//			while(rs.next()) {
//				//System.out.println(rs.getString("name") + "\t" + rs.getString("price"));
//				System.out.printf("%30s: %10d%n", rs.getString("name"), rs.getInt("price"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		EmployeeMenu();
//		}

	}
}
