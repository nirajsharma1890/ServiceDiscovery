package com.tcs.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.order.model.Order;
import com.tcs.order.model.OrderBean;
import com.tcs.order.service.OrderService;

@RestController
@RequestMapping("/")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order")
	public ResponseEntity<Order> newOrder(@RequestBody OrderBean orderBean) {
		Boolean isCod=false;
		if(orderBean.getPaymentChannel().equalsIgnoreCase("cod")) {
			isCod=true;
		}
		String orderStatus="New";
		long orderCreatedOn = new java.util.Date().getTime();
		Order order = new Order(orderBean.getOrderId(), orderBean.getCustomerId(), orderBean.getPaymentChannel(), isCod, orderStatus,
				orderCreatedOn, orderBean.getTotalAmount(),orderBean.getShippingAddress());
		
		Order checkOrder = this.orderService.getOrder(order.getOrderId());
		if(checkOrder==null) {
			Order createdOrder = this.orderService.addOrder(order);
			return new ResponseEntity<Order>(createdOrder,HttpStatus.CREATED);
		}else
			return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
		
	}
}
