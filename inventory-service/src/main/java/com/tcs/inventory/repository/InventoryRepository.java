package com.tcs.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.tcs.inventory.model.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory,Integer> {

}
