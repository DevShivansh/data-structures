package com.vedantu.dao.impl;


import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vedantu.dao.OrderDao;
import com.vedantu.entities.Account;
import com.vedantu.entities.Inventory;
import com.vedantu.entities.Order;

@Repository
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	@Transactional
	public Order createRecord(int accountId, int productId) {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		session.beginTransaction();
		Order order = new Order();
		Account account = session.get(Account.class, accountId);
		account.addOrder(order);
		session.save(account);
		
		/*Inventory product = session.get(Inventory.class, productId);
		product.addOrder(order);
		session.save(product);*/
		return order;
	}
	
	/*@Override
	@Transactional
	public Order createRecord(Order order) {
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		session.beginTransaction();
		
		List<Order> orders =  session.createQuery("from Order desc", Order.class).getResultList();
		if(orders.isEmpty()) {
			order.setId(1);
		}else {
			order.setId(orders.get(0).getId() + 1);
		}
		
		session.save(order);
		session.getTransaction().commit();
		session.close();
		return order;
	}*/

}
