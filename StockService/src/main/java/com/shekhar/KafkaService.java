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
public class KafkaService {

	@KafkaListener(topics = "${spring.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consumeEvent(OrderEvent event) {
		System.out.println("Event Consumed Successfully in stock SERVICE" + event);
	}

}
