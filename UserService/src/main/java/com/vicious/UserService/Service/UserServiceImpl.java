package com.vicious.UserService.Service;



import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vicious.UserService.Entity.UserRegistration;
import com.vicious.UserService.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserRegistration saveUser(UserRegistration userRegistration,MultipartFile profilePicture) throws IOException {
	
		userRegistration.setProfilePicture(profilePicture.getBytes());
		LocalDate date=LocalDate.now();
		Integer age1= Period.between(userRegistration.getDob(), date).getYears();
		userRegistration.setAge(age1);
		return userRepository.save(userRegistration);
	}

	

}
