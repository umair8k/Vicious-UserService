package com.vicious.UserService.Entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	
	private Long transactionId;
	private Long userId;
	private Double transactionAmount;
	private Double refundedAmount;
	

}
