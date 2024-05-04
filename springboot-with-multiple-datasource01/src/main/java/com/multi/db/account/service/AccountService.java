package com.multi.db.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.db.account.entity.Account;
import com.multi.db.account.repo.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}
	
	public Account getAccountById(Long id) {
		return accountRepository.findById(id).orElse(null);
	}
	
	public List<Account> getAllAccounts(){
		return accountRepository.findAll();
	}
}
