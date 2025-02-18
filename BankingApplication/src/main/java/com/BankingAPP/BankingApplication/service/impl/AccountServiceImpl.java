package com.BankingAPP.BankingApplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.BankingAPP.BankingApplication.dto.AccountDto;
import com.BankingAPP.BankingApplication.entity.Accounts;
import com.BankingAPP.BankingApplication.mapper.AccountMapper;
import com.BankingAPP.BankingApplication.repository.AccountRepository;
import com.BankingAPP.BankingApplication.service.AccountService;




@Service
public class AccountServiceImpl implements AccountService {
    
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Accounts account = AccountMapper.mapToAccount(accountDto);
        Accounts savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long accNo) {
        Accounts account = accountRepository.findById(accNo)
                .orElseThrow(() -> new RuntimeException("Account not found with ID: " + accNo));

        return AccountMapper.mapToAccountDto(account);
    }

	@Override
	public AccountDto deposite(Long accNo, double amount) {
		
		Accounts account = accountRepository.findById(accNo)
                .orElseThrow(() -> new RuntimeException("Account not found with ID: " + accNo));
		
		double totalBal = account.getAccBalance()+amount;
		account.setAccBalance(totalBal);
		Accounts savedAccount=accountRepository.save(account);
		
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}
    
	@Override
	public AccountDto withdraw(Long accNo, double amount) {
        Accounts account = accountRepository.findById(accNo)
                .orElseThrow(() -> new RuntimeException("Account not found with ID: " + accNo));

        if (account.getAccBalance()<amount) {
            throw new RuntimeException("Insufficient balance in account ID: " + accNo);
        }

        double updatedBalance = account.getAccBalance() - amount;
        account.setAccBalance(updatedBalance);
        Accounts savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    
    }
	
	@Override
	public List<AccountDto> getAllAccounts() {
	    return accountRepository.findAll().stream()
	            .map(AccountMapper::mapToAccountDto) // Corrected method call
	            .collect(Collectors.toList());
	}

	@Override
	public void deleteAccount(Long accNo) {
		
		Accounts account = accountRepository.findById(accNo)
                .orElseThrow(() -> new RuntimeException("Account not found with ID: " + accNo));
		
		accountRepository.delete(account);
		
	}
	
	

    
}
