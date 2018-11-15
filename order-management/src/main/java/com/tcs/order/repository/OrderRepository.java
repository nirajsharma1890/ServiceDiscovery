package com.tcs.order.repository;
import org.springframework.data.repository.CrudRepository;
import com.tcs.order.model.Order;

public interface OrderRepository extends CrudRepository<Order,Integer> {

}
