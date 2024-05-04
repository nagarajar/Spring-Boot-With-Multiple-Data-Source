package com.multi.db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.db.account.entity.Account;
import com.multi.db.account.service.AccountService;
import com.multi.db.user.entity.User;
import com.multi.db.user.service.UserService;

@RestController
@RequestMapping("/api/v1/")
public class AccountAndUserController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("account/create")
	public Account createAccount(@RequestBody Account account) {
		return accountService.createAccount(account);
	}
	
	@GetMapping("account/{id}")
	public Account getAccountById(@PathVariable Long id) {
		return accountService.getAccountById(id);
	}
	
	@GetMapping("accounts")
	public List<Account> getAccountById() {
		return accountService.getAllAccounts();
	}
	
	@PostMapping("user/create")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@GetMapping("user/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("users")
	public List<User> getUserById() {
		return userService.getAllUsers();
	}
}
