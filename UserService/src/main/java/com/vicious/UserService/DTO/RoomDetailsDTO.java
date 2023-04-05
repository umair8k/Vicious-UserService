package com.vicious.UserService.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDetailsDTO {
	
	
	
	private Long id;
	private Double roomPrice;
	private Integer roomNo;
	private String description;
	private Boolean roomStatus;
	
//	@OneToOne
//	private RoomsCategory roomsCategory;
//	
//	@OneToOne
//	private HotelNames hotelNames;

}
