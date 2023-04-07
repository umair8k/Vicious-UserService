package com.vicious.UserService.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.vicious.UserService.DTO.RoomDetailsDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrancsactionLine extends BaseEntity{

	
	//private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private Boolean isCancelled;
	private String cancelledReason;
	
	@Transient
	private RoomDetailsDTO roomDetailsDTO;
	
	@ManyToOne
	private UserRegistration regUserRegistration;

	@ManyToOne
	private Transaction transaction;

}
