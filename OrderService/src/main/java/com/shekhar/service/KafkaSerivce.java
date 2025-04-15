/**
 * 
 */
package com.shekhar.service;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.shekhar.dto.OrderEvent;

/**
 * @author shekhar
 */

@Service
public class KafkaSerivce {

	private NewTopic topics;

	private KafkaTemplate<String, OrderEvent> template;

	public KafkaSerivce(NewTopic topics, KafkaTemplate<String, OrderEvent> template) {

		this.topics = topics;
		this.template = template;
	}

	public void sendMessage(OrderEvent event) {
		Message<OrderEvent> message = MessageBuilder.withPayload(event)
				.setHeader(KafkaHeaders.TOPIC, topics.name()).build();

		template.send(message);

	}

}
