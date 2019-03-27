package com.vedantu.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedantu.dao.AccountDao;
import com.vedantu.entities.Account;
import com.vedantu.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao AccountDao;

	@Override
	public Account getAccount(int accountId) {
		// TODO Auto-generated method stub
		return AccountDao.getAccountById(accountId);
	}

	@Override
	public void updateOrder(Account account) {
		// TODO Auto-generated method stub
		AccountDao.updateRecord(account);
		
	}

}
