package com.BankingAPP.BankingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.BankingAPP.BankingApplication.entity.Accounts;

public interface AccountRepository extends JpaRepository <Accounts, Long>{
	

}
