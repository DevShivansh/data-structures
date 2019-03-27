package com.vedantu.dao;

import com.vedantu.entities.Order;

public interface OrderDao {

	public Order createRecord(int accountId,int productId); 
}
