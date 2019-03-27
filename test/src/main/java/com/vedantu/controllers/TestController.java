package com.vedantu.controllers;

import java.util.ArrayList;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vedantu.dao.OrderDao;
import com.vedantu.entities.Account;
import com.vedantu.entities.Inventory;
import com.vedantu.entities.Order;

@Controller
public class TestController {
	
	@Autowired
	private OrderDao orderDao;
	
	@RequestMapping(value = "/testAdd" , method = RequestMethod.GET )
	public ResponseEntity<Object> createRecord()
	{	System.out.println("Enter in save");
		Order order = new Order();
		//order.setId(id);
		order.setAccount(new Account(1, "name", "email", "phoneNo", "password", new ArrayList<>()));
		order.setProduct(new Inventory(1, "product", "product", 10, 1, new ArrayList<>()));
		orderDao.createRecord(order);
		return new ResponseEntity<>(org.springframework.http.HttpStatus.OK);
	}

}
