package com.revature.views;

public class AdminPage extends Page {

	public AdminPage(String bodyMessage) {
		super(bodyMessage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void body() {
		System.out.println("ADMIN PAGE");
		System.out.println();
		System.out.println("How can we help you?");
		System.out.println("[1] View Balance");
		System.out.println("[2] Withdraw Money");
		System.out.println("[3] Deposit Money");
		System.out.println("[4] View Transactions");
		System.out.println("[5] Transfer Money");
		System.out.println("[or type 'logout']");
	}
	
}
