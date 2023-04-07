package com.vicious.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vicious.UserService.Entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
