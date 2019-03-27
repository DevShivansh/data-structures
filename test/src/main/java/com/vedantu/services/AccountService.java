package com.vedantu.services;

import com.vedantu.entities.Account;

public interface AccountService {

	public Account getAccount(int accountId);

	public void updateOrder(Account account);
}
