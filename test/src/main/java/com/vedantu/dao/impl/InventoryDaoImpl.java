package com.vedantu.dao.impl;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vedantu.dao.InventoryDao;
import com.vedantu.entities.Account;
import com.vedantu.entities.Inventory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class InventoryDaoImpl implements InventoryDao {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	@Transactional
	public int getProductStatus(int productId) {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		session.beginTransaction();
		log.info("Fetching product with id {}", productId);
		Inventory product = session.get(Inventory.class, productId);
		session.getTransaction().commit();
		session.close();
		if(product.getAvailable() == 1) {
			return 1;
		}
		return 0;
	}

	@Override
	@Transactional
	public Inventory getProductById(int productId) {
		
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		session.beginTransaction();
		Inventory product = session.get(Inventory.class, productId);
		session.getTransaction().commit();
		session.close();
		return product;
	}

	@Override
	@Transactional
	public void updateProductStatusById(int productId) {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		session.beginTransaction();
		Inventory product = session.get(Inventory.class, productId);
		product.decreaseProductQuantity();
		session.getTransaction().commit();
		session.close();
		
		
	}

	
	@Override
	@Transactional
	public void updateRecord(Inventory product) {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		session.beginTransaction();
		Inventory updateModel = session.get(Inventory.class, product.getId());
		updateModel.setOrders(product.getOrders());
		session.getTransaction().commit();
		session.close();
		
	}

}
