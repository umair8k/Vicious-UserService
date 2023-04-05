package com.vicious.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vicious.UserService.Entity.RoomBooking;

public interface RoomBookingRepository extends JpaRepository<RoomBooking,Long>{

}
