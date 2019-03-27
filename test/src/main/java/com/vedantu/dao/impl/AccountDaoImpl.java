package com.vedantu.dao.impl;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vedantu.dao.AccountDao;
import com.vedantu.entities.Account;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	@Transactional
	public Account getAccountById(int accountId) {
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		session.beginTransaction();
		Account account = session.get(Account.class, accountId);
		session.close();
		return account;
	}

	@Override
	@Transactional
	public void updateRecord(Account account) {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		session.beginTransaction();
		Account updateModel = session.get(Account.class, account.getId());
		updateModel.setOrders(account.getOrders());
		session.getTransaction().commit();
		session.close();
		
	}

}
