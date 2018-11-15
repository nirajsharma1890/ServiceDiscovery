package com.tcs.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.inventory.model.Inventory;
import com.tcs.inventory.service.InventoryService;

@RestController
@RequestMapping("/")
public class InventoryContoller {
	
	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping(value = "/item")
	public ResponseEntity<List<Inventory>> getAllInventories() throws Exception {
		List<Inventory> inventoryList = this.inventoryService.getAllInventories();
		if(inventoryList.size()==0)
			return new ResponseEntity<List<Inventory>>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Inventory>>(inventoryList,HttpStatus.OK);
		
    }
	
	@GetMapping(value = "/item/{id}")
	public ResponseEntity<Inventory> getInventory(@PathVariable("id") long id ) throws Exception {
		Inventory inventory = this.inventoryService.getInventory(id);
		if(inventory==null)
			return new ResponseEntity<Inventory>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Inventory>(inventory,HttpStatus.OK);
	}
	
	@PostMapping("/item")
	public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {
		Inventory checkInventory = this.inventoryService.getInventory(inventory.getSkuId());
		if(checkInventory==null) {
			Inventory createdInventory = this.inventoryService.addInventory(inventory);
			return new ResponseEntity<Inventory>(createdInventory,HttpStatus.CREATED);
		}else
			return new ResponseEntity<Inventory>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/item/{id}")
	public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventory, @PathVariable("id") long id){
		Inventory checkInventory = this.inventoryService.getInventory(id);
		if(checkInventory!=null)
		{
			this.inventoryService.deleteInventory(checkInventory);
			return new ResponseEntity<Inventory>(this.inventoryService.addInventory(inventory),HttpStatus.OK);
		}
		else
			return new ResponseEntity<Inventory>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/item/{id}")
	public ResponseEntity<Inventory> deleteInventory(@PathVariable("id") long id) {
		Inventory checkInventory = this.inventoryService.getInventory(id);
	    if(checkInventory!=null) {
	    	this.inventoryService.deleteInventory(checkInventory);
	    	return new ResponseEntity<Inventory>(HttpStatus.OK);
	    }
	    else
	    	return new ResponseEntity<Inventory>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/item/")
	public ResponseEntity<Inventory> deleteAllInventory() {
		if(this.inventoryService.getAllInventories().size()!=0) {
			this.inventoryService.deleteAllInventory();
			return new ResponseEntity<Inventory>(HttpStatus.OK);
		}else
			return new ResponseEntity<Inventory>(HttpStatus.NOT_FOUND);
		
	}
}
