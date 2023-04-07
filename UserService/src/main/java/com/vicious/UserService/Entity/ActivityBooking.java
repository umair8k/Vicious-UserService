package com.vicious.UserService.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.vicious.UserService.DTO.ActivitiesDTO;
import com.vicious.UserService.DTO.RoomDetailsDTO;

import lombok.Data;

@Data
@Entity
public class ActivityBooking extends BaseEntity {

	
	@Transient
	@OneToMany
	private List<ActivitiesDTO> activities;
	@Transient
	@OneToOne
	private RoomDetailsDTO roomDetails;
	
	 private double total;


}
