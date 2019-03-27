package com.vedantu.dao;

import com.vedantu.entities.Inventory;

public interface InventoryDao {

	int getProductStatus(int productId);

	Inventory getProductById(int productId);

	void updateProductStatusById(int productId);

	void updateRecord(Inventory product);

}
