
package com.shekhar.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shekhar
 */
@Data
@NoArgsConstructor
public class OrderEvent {

	private String message;
	private String status;
	private Order order;

}
