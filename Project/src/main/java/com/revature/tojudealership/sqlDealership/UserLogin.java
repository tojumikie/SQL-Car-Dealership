package com.revature.tojudealership.sqlDealership;

import java.sql.Connection;
import java.sql.DriverManager;
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
			
		}
	}
	
	public static void main(String[] args) {
//		String u = "tojumikie";
//		String p = "12345678";
//		String sql = "insert into login (username, password) values ('" + u + "'" + "," + "'" + p + "');";
//		System.out.println(sql);
	}
}

