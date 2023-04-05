package com.vicious.UserService.DTO;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCategoryDTO {

	
	private Long id;
    private String foodCategory;
    private LocalTime startTime;
    private LocalTime endTime;
}
