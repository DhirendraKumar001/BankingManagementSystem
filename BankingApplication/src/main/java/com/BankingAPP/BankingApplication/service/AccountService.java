package com.BankingAPP.BankingApplication.service;

import java.util.List;

import com.BankingAPP.BankingApplication.dto.AccountDto;

public interface AccountService {

	AccountDto createAccount(AccountDto accounts);

	AccountDto getAccountById(Long accNo);
	
	AccountDto deposite(Long accNo ,double amount);
	
	AccountDto withdraw(Long accNo ,double amount);
	
	List<AccountDto> getAllAccounts();

	void deleteAccount(Long accNo);
	


}
