package com.vicious.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vicious.UserService.Entity.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long>{

}
