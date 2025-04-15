/**
 * 
 */
package com.shekhar.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shekhar.dto.Order;
import com.shekhar.dto.OrderEvent;
import com.shekhar.service.KafkaSerivce;

/**
 * @author shekhar
 */

@RestController
public class KafkaController {

	@Autowired
	private KafkaSerivce kafkaService;

	@PostMapping("/order")
	public ResponseEntity<String> sendEvent(@RequestBody Order order) {
		String orderId = UUID.randomUUID().toString();

		OrderEvent event = new OrderEvent();
		order.setOrderId(orderId);
		event.setOrder(order);
		event.setMessage("order is in pending state");
		event.setStatus("PENDING");

		kafkaService.sendMessage(event);

		return new ResponseEntity<String>("Order send to Broker Event is generted", HttpStatus.OK);
	}

}
