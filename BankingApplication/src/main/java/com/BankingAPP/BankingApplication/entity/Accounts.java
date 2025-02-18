package com.BankingAPP.BankingApplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "accounts")
public class Accounts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long accNo;
	
	@Column(name = "account_holder_name")
	private String accHolderName;
	
	@Column(name = "acc_balance")
	private double accBalance;
	
	public Accounts() {
    }
	
	public Accounts(long accNo, String accHolderName, double accBalance) {
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
