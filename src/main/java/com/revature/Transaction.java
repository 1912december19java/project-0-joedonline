package com.revature;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
	
	private String transactionId;
	private String accountType;
	private String transactionDate;
	private String transactionTime;
	private Double transactionAmount;
	private String customerId;
	
	
	public String getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public void setTransactionDate() {
		DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		this.transactionDate = sdf.format(now);
	}

	public String getTransactionDate() {
		return transactionDate;
	}
	
	public void setTransactionTime() {
		DateTimeFormatter sdf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		this.transactionTime = sdf.format(now);
	}
	
	public String getTransactionTime() {
		return transactionTime;
	}
	
	public Double getTransactionAmount() {
		return transactionAmount;
	}
	
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", accountType=" + accountType + ", transactionDate="
				+ transactionDate + ", transactionTime=" + transactionTime + ", transactionAmount=" + transactionAmount
				+ ", customerId=" + customerId + "]";
	}
	
}
