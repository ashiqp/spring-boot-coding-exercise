package com.telstra.codechallenge.userSearch;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccountController {

	private UserAccountService userAccountService;

	public UserAccountController(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}

	@GetMapping("/accounts")
	public List<Account> getOldNoFollowersAccounts(@RequestParam(required = false) Long count) {

		return Arrays.asList(userAccountService.getOldNoFollowersAccounts(count));

	}

}
