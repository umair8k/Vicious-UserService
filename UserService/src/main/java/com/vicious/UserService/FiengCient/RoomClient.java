package com.vicious.UserService.FiengCient;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.vicious.UserService.DTO.RoomDetailsDTO;

@FeignClient(name="ROOM-SERVICE",url="http://10.81.4.222:1996" )
public interface RoomClient {
	
	@GetMapping("/getByRoomDetailsId/{id}")
	public ResponseEntity<RoomDetailsDTO> getByRoomDetailsId(@PathVariable Long id);

	@PostMapping("/saveroomdetails")
	public RoomDetailsDTO save(@RequestBody RoomDetailsDTO  details);
	
//	@PutMapping("/updateRoomDetails/{id}")
//	public ResponseEntity<Map<String, Boolean>> updateRoomDetails(@PathVariable Long id,
//	                                               @Valid @RequestBody RoomDetailsDTO roomDetails);
	
	@GetMapping("/saveroometails")
	public boolean saveRoomDetails(@RequestParam Long roomId);
}
