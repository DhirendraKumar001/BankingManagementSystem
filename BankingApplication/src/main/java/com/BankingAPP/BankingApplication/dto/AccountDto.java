package com.BankingAPP.BankingApplication.dto;

public class AccountDto {
	
	
	private long accNo;
	
	private String accHolderName;
	
	private double accBalance;
	
	public AccountDto(long accNo, String accHolderName, double accBalance) {
		super();
		
		this.accNo = accNo;
		this.accHolderName = accHolderName;
		this.accBalance = accBalance;
		
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}
	
	
	

}



