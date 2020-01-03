package com.revature.views;

public abstract class Page {
	
	public Page(String bodyMessage) {
		super();
		this.header();
	}
	
	public void header() {
		System.out.println("Welcome! We are JD Morgan & Chaze Bank");
	}
	
	public abstract void body();
	
	public void footer() {
		System.out.println("======================================");
	}

	public void body(String bodyMessage) {
		// TODO Auto-generated method stub
		
	}
	
}
