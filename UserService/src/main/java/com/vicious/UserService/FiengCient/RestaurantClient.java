package com.vicious.UserService.FiengCient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.vicious.UserService.DTO.FoodMenuDTO;
import com.vicious.UserService.DTO.RoomDetailsDTO;


@FeignClient(name="RESTAURANT-SERVICE",url="http://10.81.4.236:1991")
public interface RestaurantClient {
	
	
	@GetMapping("/getAllFoodMenu")
	public ResponseEntity<List<FoodMenuDTO>> allFoodMenu();
	
	@GetMapping("/getByFoodMenuId/{id}")
	public ResponseEntity<FoodMenuDTO> getByFoodMenuId(@PathVariable Long id);
}
