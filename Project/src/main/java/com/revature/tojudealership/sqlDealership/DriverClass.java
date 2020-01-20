package com.revature.tojudealership.sqlDealership;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class DriverClass 
{
	static String URL = "";
    static String USERNAME = "";
	static String PASSWORD = "";
	
	public static void menu() {
		Scanner kb = new Scanner(System.in);
		int selection = 0;
		do {
			System.out.println("WELCOME TO THE CAR LOT");
			System.out.println("select an option.");
			System.out.println("");
			System.out.println("MENU");
			System.out.println("1. customers");
			System.out.println("2. users");
			System.out.println("3. employees");
			System.out.println("4. system");
			System.out.println("5. exit program");
			selection = kb.nextInt();
			runUserSelection(selection);
		} while(selection != 5);
	}
	
	public static void runUserSelection(int selection) {
		switch(selection) {
		case 1:
			CustomerLogin CustomerLogin = new CustomerLogin();
			CustomerLogin.CustomerMenu();
			break;
		case 2:
			UserLogin UserLogin = new UserLogin();
			UserLogin.UserMenu();
			break;
		case 3:
			EmployeeLogin EmployeeLogin = new EmployeeLogin();
			EmployeeLogin.addOrRemoveCars();
			break;
		case 4:
			SystemLogin SystemLogin = new SystemLogin();
			SystemLogin.calculateMonthlyPayment();
			break;
		case 5:
			//System.out.println("The program has terminated.");
			break;
		}
	}
	
	public static void SQLConnect() {
		try {
			List<String> ls = Files.readAllLines(Paths.get("sql.properties"));
			URL = ls.get(0);
			USERNAME = ls.get(1);
			PASSWORD = ls.get(2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			if(conn != null) {
				//System.out.println("Connected to the database");
			}
			else {
				System.out.println("not connected");
			}
			conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void createLoginTable() {
		String sql ="create table login(username varchar(30), password varchar(30));";
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			if(conn != null) {
				System.out.println("connected");
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
			}
			else {
				System.out.println("not connected");
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createOfferTable() {
		SQLConnect();
		String sql = "create table offers(name varchar(255), price int);";
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			if(conn != null) {
				System.out.println("connected");
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
			}
			else {
				System.out.println("not connected");
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createOwnedCarsTable() {
		SQLConnect();
		String sql = "create table carsOwned(name varchar(255), value int);";
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			if(conn != null) {
				System.out.println("connected");
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
			}
			else {
				System.out.println("not connected");
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
    public static void main( String[] args ) {
    	//SQLConnect();
    	//menu();
    	//createLoginTable();
    	//menu();
    	//String sql ="create table login(username varchar(30), password varchar(30);";
    	//createOfferTable();
    	//createOwnedCarsTable();
    }
}

/************************************************************************************
 * OLD MAIN METHOD
//    	String line;
//    	try {
//			BufferedReader br = new BufferedReader(new FileReader("sql.properties"));
//			try {
//					
////				while((line = br.readLine()) != null) {
////					System.out.println(line);
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//        //System.out.println( "Hello World!" );
**************************************************************************************/
/****************************************************************************************
 * TO INITIALIZE THE ORIGINAL CARS TABLE
//        	String sqlCarTable = "create table cars(name varchar(255), price int);";
//        	Statement stmt = conn.createStatement();
//        	stmt.executeUpdate(sqlCarTable);
//        	
//        	String initialCars = "insert into cars(name, price) values " +
//        		"('2009 Jaguar XF Supercharged', 8499)," +
//        		"('2010 Ford Mustang GT', 8500)," +
//        		"('2011 Ford F-150 SuperCab', 7500)";
//        	stmt.executeUpdate(initialCars);
//        }
 *************************************************************************************/










