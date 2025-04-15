/**
 * 
 */
package com.shekhar.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shekhar
 */
@Data
@NoArgsConstructor
public class Order {

	private String orderId;
	private String orderName;
	private Double orderPrice;
	private Integer orderQuantity;

}
