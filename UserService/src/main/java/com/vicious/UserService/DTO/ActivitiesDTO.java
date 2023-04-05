package com.vicious.UserService.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivitiesDTO {
	
	
	private Long activityId;
    private String activityName;
    private Double price; 

}
