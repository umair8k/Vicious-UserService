package com.vicious.UserService.FiengCient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vicious.UserService.DTO.RoomDetailsDTO;

@FeignClient(name="ROOM-SERVICE",url="http://10.81.4.222:1996")
public interface RoomClient {
	
	@GetMapping("/getByRoomDetailsId/{id}")
	public ResponseEntity<RoomDetailsDTO> getByRoomDetailsId(@PathVariable Long id);

	@PostMapping("/saveroomdetails")
	public RoomDetailsDTO save(@RequestBody RoomDetailsDTO  details);
}
