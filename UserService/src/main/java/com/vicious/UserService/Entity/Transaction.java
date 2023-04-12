package com.vicious.UserService.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
//@EqualsAndHashCode(callSuper=false)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction extends BaseEntity{
	
	@Id
	private Long transactionId;
	private Double transactionAmount;
	private Double refundedAmount;
	
	@OneToOne
	private UserRegistration userRegistration;
	
	@OneToMany(mappedBy = "transaction")
	//@JoinTable(name="transac_transacline", joinColumns = @JoinColumn(name="transaction_Id"), inverseJoinColumns = @JoinColumn(name="transactionline_id"))
	private List<TrancsactionLine> trancsactionLine;
	

}
