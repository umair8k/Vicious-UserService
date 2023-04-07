package com.vicious.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vicious.UserService.Entity.TrancsactionLine;

public interface TransactionlineRepository extends JpaRepository<TrancsactionLine,Long>{

}
