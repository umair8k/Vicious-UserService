package com.vicious.UserService.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.vicious.UserService.DTO.RoomDetailsDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrancsactionLine extends BaseEntity{

	@Id
	private Long id;
	private Boolean isCancelled;
	private String cancelledReason;
	
	
	private RoomDetailsDTO roomDetailsDTO;
	
	@ManyToOne
	private UserRegistration regUserRegistration;

	@ManyToOne
	private Transaction transaction;

}
