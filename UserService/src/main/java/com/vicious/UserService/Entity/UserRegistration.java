package com.vicious.UserService.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistration {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotBlank(message="This field should not be blank")
	private String firstName;
    @NotBlank(message="This field should not be blank")
	private String lastName;
    @NotBlank(message="This field should not be blank")
	private String username;
   
    @NotBlank(message = "Password can't be blank")
    private String password;
	@Email
	private String email;
	@Min(value=18, message="must be equal or greater than 18")  
	private int age;
	

	private LocalDate dob;
	private String address1;
	private String address2;
	@Lob
	private byte[] profilePicture;
	
	//@Pattern(regexp = "[89][0-9]{10}", message = "Invalid mobile number entered")
   	private String phoneNo;
}
