package com.vedantu.services;

import com.vedantu.entities.Order;

public interface OrderService {

	public Order placeOrder(int accountId, int productId);
}
