/**
 * 
 */
package com.shekhar;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.shekhar.dto.OrderEvent;

/**
 * @author shekhar
 */
@Service
public class KafkaConsumerService {

	@KafkaListener(topics = "${spring.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consumeMessage(OrderEvent event) {
		System.out.println("Order consumed in service Email:" + event);
	}

}
