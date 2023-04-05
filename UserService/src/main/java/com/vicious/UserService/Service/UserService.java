package com.vicious.UserService.Service;



import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.vicious.UserService.Entity.UserRegistration;



public interface UserService {
	
	
	public UserRegistration saveUser (UserRegistration userRegistration,MultipartFile profilePicture)throws IOException;

}
