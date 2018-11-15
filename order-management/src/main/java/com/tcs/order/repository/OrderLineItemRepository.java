package com.tcs.order.repository;
import org.springframework.data.repository.CrudRepository;
import com.tcs.order.model.OrderLineItem;

public interface OrderLineItemRepository extends CrudRepository<OrderLineItem,Integer> {

}
