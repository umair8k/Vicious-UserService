package com.vicious.UserService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vicious.UserService.Entity.FoodOrder;
import com.vicious.UserService.Entity.RoomBooking;
import com.vicious.UserService.Entity.Transaction;
import com.vicious.UserService.Entity.UserRegistration;
import com.vicious.UserService.Repository.RoomBookingRepository;
import com.vicious.UserService.Repository.UserRepository;

@RestController
public class TransactionController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoomBookingRepository roomBookingRepository;
	
@GetMapping("/transactionAmount")
public Transaction getTransactionetails(@RequestParam Long id,@RequestParam String username) {
	Transaction transaction = new Transaction();
	RoomBooking booking = new RoomBooking();
	//FoodOrder foodOrder = new FoodOrder();
	UserRegistration registration = new UserRegistration();
	
	booking=roomBookingRepository.findById(id).get();
	//username=registration.getUsername();
	registration = this.userRepository.findByusername(username);
	
	transaction.setUserRegistration(registration);
	Double transactionAmount=(booking.getTotalPrice());
	
	transaction.setTransactionAmount(transactionAmount);
	
	
	return transaction;
}

}
