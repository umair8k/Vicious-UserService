package com.vicious.UserService.FiengCient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vicious.UserService.DTO.HotelNamesDTO;

@FeignClient(name = "HOTEL-SERVICE",url="http://10.81.4.222:1996")
public interface HotelClient {

	@GetMapping("/getByHotelNamesId/{id}")
	public ResponseEntity<HotelNamesDTO> getByHotelNamesId(@PathVariable Long id);

}
