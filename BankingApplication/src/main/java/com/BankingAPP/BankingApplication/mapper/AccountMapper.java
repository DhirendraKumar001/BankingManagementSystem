package com.BankingAPP.BankingApplication.mapper;

import com.BankingAPP.BankingApplication.dto.AccountDto;
import com.BankingAPP.BankingApplication.entity.Accounts;

public class AccountMapper {
	public static Accounts mapToAccount(AccountDto accountDto) {
		Accounts account = new Accounts(
			accountDto.getAccNo(),
			accountDto.getAccHolderName(),
			accountDto.getAccBalance()
		);
	
		return account;
		}
	
	public static AccountDto mapToAccountDto(Accounts accounts) {
		
		AccountDto accountDto = new AccountDto(
				accounts.getAccNo(),
				accounts.getAccHolderName(),
				accounts.getAccBalance()
				);
		return accountDto;
	}
	

}
