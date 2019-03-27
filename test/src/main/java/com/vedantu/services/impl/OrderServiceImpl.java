package com.vedantu.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedantu.dao.OrderDao;
import com.vedantu.entities.Account;
import com.vedantu.entities.Inventory;
import com.vedantu.entities.Order;
import com.vedantu.services.AccountService;
import com.vedantu.services.InventoryService;
import com.vedantu.services.OrderService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private AccountService accountService;

	@Autowired
	private InventoryService inventoryService;
	
	
	@Override
	public Order placeOrder(int accountId, int productId) {
		// Check for product availability
		boolean productAvailability = inventoryService.isProductAvailable(productId);
		
		log.info("Product available : {}", productAvailability);
		
		if(productAvailability) {
			Order order = orderDao.createRecord(accountId,productId);
			// Place the order
			//Order order = new Order();
			//order.setId(Order.idVal++);
		//	Account account = accountService.getAccount(accountId);
			//account.addOrder(order);
			//accountService.updateOrder(account);
			//order.setAccount(account);
			//Inventory product = inventoryService.getProduct(productId);
			//product.addOrder(order);
			//inventoryService.updateOrder(product);
			//order.setProduct(product);
			//Order placedOrder = orderDao.createRecord(order);
		//	log.info("Order place : {}", order);
			
			// Update the product availability in Inventory
			inventoryService.updateProductAvailStatus(productId);
			
			log.info("Updated Product status");
			//return order details
			return order;
			
		}else {
			// product not available , return null
			return null;
		}
	}

}
