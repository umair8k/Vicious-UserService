package com.vicious.UserService.Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import com.vicious.UserService.DTO.FoodMenuDTO;
import com.vicious.UserService.DTO.HotelNamesDTO;
import com.vicious.UserService.DTO.RoomDetailsDTO;
import com.vicious.UserService.Entity.FoodOrder;
import com.vicious.UserService.Entity.RoomBooking;
import com.vicious.UserService.Entity.UserRegistration;
import com.vicious.UserService.FiengCient.HotelClient;
import com.vicious.UserService.FiengCient.RestaurantClient;
import com.vicious.UserService.FiengCient.RoomClient;
import com.vicious.UserService.Repository.FoodOrderRepository;
import com.vicious.UserService.Repository.RoomBookingRepository;
import com.vicious.UserService.Repository.UserRepository;
import com.vicious.UserService.Service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	HotelClient client;

	@Autowired
	RestaurantClient client1;

	@Autowired
	RoomClient roomClient;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoomBookingRepository roomBookingRepository;

	@PostMapping(value = "/createRegistration", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public UserRegistration postString(@RequestParam String userRegistration,
			@RequestParam MultipartFile profilePicture) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		UserRegistration registration = objectMapper.readValue(userRegistration, UserRegistration.class);
		return service.saveUser(registration, profilePicture);
	}

	@GetMapping("/getByHotelNamesId/{id}")
	public ResponseEntity<HotelNamesDTO> gethotelNames(@PathVariable Long id) {
		return client.getByHotelNamesId(id);
	}

	@GetMapping("/getAllFoodMenu")
	public ResponseEntity<List<FoodMenuDTO>> allFoodMenu() {
		return client1.allFoodMenu();
	}

	@PostMapping("/createBooking")
	public ResponseEntity<?> createBooking(@RequestBody RoomBooking roomBooking, @RequestParam Long Id,
			RoomDetailsDTO roomDetails, @RequestParam String username) {
		roomDetails = roomClient.getByRoomDetailsId(Id).getBody();
		// String username = roomBooking.getUserRegistration().getUsername();

		UserRegistration user = this.userRepository.findByUsername(username);

		roomBooking.setUserRegistration(user);

		RoomDetailsDTO rooms = roomClient.getByRoomDetailsId(Id).getBody();

		roomBooking.setRoomDetails(rooms);
		// return roomBooking;

		Double roomPrice = roomDetails.getRoomPrice();
		if (roomBooking.getCheckIn() != null && roomBooking.getCheckOut() != null) {
			// this.roomBookingRepository.save(roomBooking);
		}

		LocalDate date = LocalDate.now();
		if (roomBooking.getCheckIn().isBefore(date))// ||booking.getCheckOut().isBefore(booking.getCheckIn()))
		{
			System.out.println("CANNOT BOOK BEFORE TODAY");
			return new ResponseEntity<>("cannot book", HttpStatus.BAD_REQUEST);
		}

		else if (roomBooking.getRoomDetails().getRoomStatus() == true) {

			return new ResponseEntity<>("Already Booked", HttpStatus.BAD_REQUEST);

		} else {
			Long days = ChronoUnit.DAYS.between(roomBooking.getCheckIn(), roomBooking.getCheckOut());

			roomBooking.setTotal(roomPrice * days);
			roomBooking.setTotalDays(days);
			roomBooking.setGstTax((roomBooking.getTotal() * 18 / 100));
			roomBooking.setTotalPrice(roomBooking.getTotal() + roomBooking.getGstTax());
			System.out.println("==========" + days);
			
			//RoomDetailsDTO details1= new RoomDetailsDTO();
			//details1.setRoomStatus(true);

//			roomDetails.setRoomStatus(true);
			//RoomDetailsDTO rooms1 = roomClient.save(details1);

			boolean r=roomClient.saveRoomDetails(Id);
			roomDetails.setRoomStatus(r);
			//roomBooking.setRoomDetails(roomDetails);
//			rooms1.setRoomStatus(true);
		roomBookingRepository.save(roomBooking);

			return new ResponseEntity<RoomBooking>(roomBooking, HttpStatus.OK);

		}

	}

	@Autowired
	FoodOrderRepository foodOrderRepository;

	@PostMapping("/FoodOrder")
	public ResponseEntity<?> saveFoodOrder(@RequestBody FoodOrder foodOrder, @RequestParam String username,
			RoomDetailsDTO roomDetails, RoomBooking roomBooking,@RequestParam Long id) {

		// String username = principal.getName();

		UserRegistration user = this.userRepository.findByUsername(username);

		roomBooking.setUserRegistration(user);

		roomDetails = roomClient.getByRoomDetailsId(id).getBody();

		if (foodOrder.getRoomDetails().getRoomStatus() == true) {
			System.out.println("Save FoodOrder>>>>>>>>>>>>>>>>>>>>>>");
			Double total = 0d;

			for (FoodMenuDTO foodmenu : foodOrder.getFoodMenu()) {
				foodmenu = client1.getByFoodMenuId(foodmenu.getId()).getBody();
				total += foodmenu.getPrice();
			}

			foodOrder.setTotal(total);

			return new ResponseEntity<>(foodOrderRepository.save(foodOrder), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("can order only after booking the room", HttpStatus.BAD_REQUEST);

		}

	}

}
