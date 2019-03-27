package com.vedantu.dao;

import com.vedantu.entities.Account;

public interface AccountDao {

	Account getAccountById(int accountId);

	void updateRecord(Account account);

}
