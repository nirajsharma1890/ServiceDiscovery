package com.tcs.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.order.model.Order;
import com.tcs.order.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	 private OrderRepository orderRepository;
	
	public List<Order> getAllOrders(){
		List<Order> orderList= new ArrayList<Order>();
		orderRepository.findAll().forEach(orderList::add);
		return orderList;
	}
	public Order getOrder(long id){
	    List<Order> orderList= new ArrayList<Order>();
	    Order order = null;
	    orderRepository.findAll().forEach(orderList::add);
		try {
			order = orderList.stream().filter(c->c.getOrderId()==(id)).findFirst().get();
		}catch(Exception e)
		{
			System.out.println(e);
			order=null;
		}
		return order;
	}
	
	public Order addOrder(Order order){
		orderRepository.save(order);
		return order;
	}
	public void deleteOrder(Order order) {
		orderRepository.delete(order);
	}
	public void deleteAllOrder() {
		orderRepository.deleteAll();
	}
	
	
}