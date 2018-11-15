package com.tcs.inventory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.inventory.model.Inventory;
import com.tcs.inventory.repository.InventoryRepository;

@Service
public class InventoryService {
	
	@Autowired
	 private InventoryRepository inventoryRepository;
	
	public List<Inventory> getAllInventories(){
		List<Inventory> inventoryList= new ArrayList<Inventory>();
		inventoryRepository.findAll().forEach(inventoryList::add);
		return inventoryList;
	}
	public Inventory getInventory(long id){
	    List<Inventory> inventoryList= new ArrayList<Inventory>();
	    Inventory inventory = null;
	    inventoryRepository.findAll().forEach(inventoryList::add);
		try {
			inventory = inventoryList.stream().filter(c->c.getSkuId()==(id)).findFirst().get();
		}catch(Exception e)
		{
			System.out.println(e);
			inventory=null;
		}
		return inventory;
	}
	
	public Inventory addInventory(Inventory inventory){
		inventoryRepository.save(inventory);
		return inventory;
	}
	public void deleteInventory(Inventory inventory) {
		inventoryRepository.delete(inventory);
	}
	public void deleteAllInventory() {
		inventoryRepository.deleteAll();
	}
	
	
}