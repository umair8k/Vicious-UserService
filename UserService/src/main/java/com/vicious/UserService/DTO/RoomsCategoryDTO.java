package com.vicious.UserService.DTO;






import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomsCategoryDTO {
	     
	    private String roomType;
	    private Boolean ac;
	    
//	    @ManyToOne
//	    @JoinColumn(name = "hotel_id")
//	    private HotelNames hotelnames;
	    
}
