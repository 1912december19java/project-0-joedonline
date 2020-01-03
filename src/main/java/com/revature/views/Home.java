package com.revature.views;

public class Home extends Page {
	
	public Home(String bodyMessage) {
		super(bodyMessage);
		
		super.footer();
	}

	@Override
	public void body() {
		System.out.println();
		System.out.println("[1] Open a new account");
		System.out.println("[2] Login (Existing customers)");
		System.out.println("[or type 'exit']");
	}
	
}
