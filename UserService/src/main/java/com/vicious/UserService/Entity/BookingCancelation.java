package com.vicious.UserService.Entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class BookingCancelation {
	
	@Id
	private Long id;
	private Double refundAmt;
	private LocalDate cancelDate;
	private Long cancelDays;
	private Double netRefundAmt;
	 private Double total;
	 private Double amtBalance;

	
	@OneToOne
	private RoomBooking roomBooking;

}
