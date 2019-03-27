package com.vedantu.services;

import com.vedantu.entities.Inventory;

public interface InventoryService {

	public boolean isProductAvailable(int productId);
	
	public Inventory getProduct(int productId);
	
	public void updateProductAvailStatus(int productId);

	public void updateOrder(Inventory product);
}
