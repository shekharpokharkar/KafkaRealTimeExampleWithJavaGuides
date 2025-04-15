/**
 * 
 */
package com.shekhar.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author shekhar
 */

@Configuration
public class KafkaConfigurationTest {

	@Value("${spring.topic.name}")
	private String topicName;

	@Bean
	public NewTopic topic1() {
		return TopicBuilder.name(topicName)

				.build();
	}
}
