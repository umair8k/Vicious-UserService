package com.vicious.UserService.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.vicious.UserService.DTO.FoodMenuDTO;
import com.vicious.UserService.DTO.RoomDetailsDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Double total;
		
		@ManyToMany(fetch = FetchType.EAGER)
		@Transient
		private List<FoodMenuDTO> foodMenu;
		
		@OneToOne
		@Transient
		private RoomDetailsDTO roomDetails;

}
