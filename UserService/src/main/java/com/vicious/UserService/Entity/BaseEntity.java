package com.vicious.UserService.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public abstract class BaseEntity {

	@Id
	private Long id;

	@Column(name="CreatedAt")
	private LocalDateTime createdAt;

	@Column(name="CreatedLoginId")
	private Long createdLoginId;

	@Column(name="UpdatedAt")
	private LocalDateTime updatedAt;

	@Column(name="UpdatedLoginId")
	private Long updatedLoginId;

}
