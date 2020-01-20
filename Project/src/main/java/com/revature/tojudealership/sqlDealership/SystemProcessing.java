package com.revature.tojudealership.sqlDealership;

import java.util.Scanner;

public class SystemProcessing {
	public static void calculateMonthlyPayment() {
		Scanner kb = new Scanner(System.in);
		System.out.println("What is the price of the offer?");
		int price = kb.nextInt();
		System.out.println("What is the loan term in months?");
		int months = kb.nextInt();
		int monthlyPayment = price / months;
		System.out.println("The monthly payment is " + monthlyPayment);
	}
	public static void main(String[] args) {
		//calculateMonthlyPayment();
	}
}
