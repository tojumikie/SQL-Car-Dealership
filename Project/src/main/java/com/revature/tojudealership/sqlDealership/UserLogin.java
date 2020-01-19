package com.revature.tojudealership.sqlDealership;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserLogin {
	//public String username;
	//public String password;
	
	public static void UserMenu() {
		String u;
		String p;
		Scanner kb = new Scanner(System.in);
		System.out.println("Would you like to register or log in?");
		String response = kb.nextLine();
		if(response.equalsIgnoreCase("register")) {
			System.out.println("Enter the username you would like to use");
			u = kb.nextLine();
			System.out.println("Enter the password you would like to use");
			p = kb.nextLine();
			String sql = "insert into login (username, password) values ('" + u + "'" + "," + "'" + p + "');";
			try (Connection conn = DriverManager.getConnection(DriverClass.URL, DriverClass.USERNAME, DriverClass.PASSWORD)) {
				if(conn != null) {
					//System.out.println("Connected to the database 2");
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(sql);
				} else {
					System.out.println("not connected");
				}
				conn.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		else if(response.equalsIgnoreCase("log in")) {
			boolean tf;
			System.out.println("Enter the username");
			u = kb.nextLine();
			System.out.println("Enter the password");
			p = kb.nextLine();
			String sql = "SELECT * FROM login WHERE username = '" + u + "' and \"password\" = '" + p + "';";
			try (Connection conn = DriverManager.getConnection(DriverClass.URL, DriverClass.USERNAME, DriverClass.PASSWORD)) {
				if(conn != null) {
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					tf = rs.next();
					if(tf == true) {
						System.out.println("Account found. Logging in.");
						System.out.println("Welcome, " + u);
					}
					else {
						System.out.println("Unable to log in. Username or password "
								+ "is incorrect");
					}
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
	}
	
	public static void main(String[] args) {
//		String u = "tojumikie";
//		String p = "12345678";
//		String sql = "insert into login (username, password) values ('" + u + "'" + "," + "'" + p + "');";
//		System.out.println(sql);
//		String u = "max";
//		String p = "1234";
//		String sql = "SELECT * FROM login WHERE username = '" + u + "' and \"password\" = '" + p + "';";
//		System.out.println(sql);
		
	}
}

