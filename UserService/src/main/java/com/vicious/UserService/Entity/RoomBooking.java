package com.vicious.UserService.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.vicious.UserService.DTO.RoomDetailsDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomBooking {
	 @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
  //  @NotNull(message = "Please enter start date")
    private LocalDate checkIn;
    
    @NotNull(message = "Please enter end date")
    private LocalDate checkOut;
    
    private Double total;
    
    private Double gstTax;
    
    private Long totalDays;
    private Double totalPrice;
    
    private Double CancelPrice;
	@Transient
    @ManyToOne()
	//@JoinColumn(name="room_fk")
	private RoomDetailsDTO roomDetails;

	@ManyToOne()
	//@JoinColumn(name="user_id_fk")
	private UserRegistration userRegistration;
}
