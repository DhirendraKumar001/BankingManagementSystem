package com.BankingAPP.BankingApplication.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.BankingAPP.BankingApplication.dto.AccountDto;
import com.BankingAPP.BankingApplication.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    
    private final AccountService accountService;
    
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> addAccounts(@RequestBody AccountDto accountDto) {
        AccountDto createdAccount = accountService.createAccount(accountDto);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }
    @GetMapping("/{accNo}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long accNo) {
        AccountDto accountDto = accountService.getAccountById(accNo);
        return ResponseEntity.ok(accountDto);
    }
    @PutMapping("/{accNo}/deposite") 
    public ResponseEntity<AccountDto> deposit(@PathVariable Long accNo, @RequestBody Map<String, Double> request) {

        Double amount = request.get("amount");
        
        AccountDto accountDto = accountService.deposite(accNo, amount);
		return ResponseEntity.ok(accountDto); 
    }
    
    @PutMapping("/{accNo}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long accNo, @RequestBody Map<String, Double> request) {
    	
    	Double amount = request.get("amount");
    	AccountDto accountDto = accountService.withdraw(accNo, amount);
    	
    	return ResponseEntity.ok(accountDto);
    }
    
    @GetMapping
    public ResponseEntity<List<AccountDto>>getAllAccounts(){
    	List<AccountDto> accountDto = accountService.getAllAccounts();
		return ResponseEntity.ok(accountDto);
    	
    }
    
    @DeleteMapping("/{accNo}/delete")
    public ResponseEntity<String>deleteAccount(@PathVariable Long accNo){
    	
    	accountService.deleteAccount(accNo);
    	
    	return ResponseEntity.ok("Account deleted succesfully");
    	
    	
    }
}
