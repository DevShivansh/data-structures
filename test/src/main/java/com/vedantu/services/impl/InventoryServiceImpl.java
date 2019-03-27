package com.vedantu.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedantu.dao.InventoryDao;
import com.vedantu.entities.Inventory;
import com.vedantu.services.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryDao inventoryDao;

	@Override
	public boolean isProductAvailable(int productId) {
		// TODO Auto-generated method stub
		int status = inventoryDao.getProductStatus(productId);
		return status == 1 ? true : false;
	}

	@Override
	public Inventory getProduct(int productId) {
		// TODO Auto-generated method stub
		return inventoryDao.getProductById(productId);
	}

	@Override
	public void updateProductAvailStatus(int productId) {
		// TODO Auto-generated method stub
		inventoryDao.updateProductStatusById(productId);

	}

	@Override
	public void updateOrder(Inventory product) {
		// TODO Auto-generated method stub
		inventoryDao.updateRecord(product);
		
	}

}
