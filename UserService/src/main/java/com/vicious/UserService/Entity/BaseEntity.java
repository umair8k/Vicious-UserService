package com.vicious.UserService.Entity;


import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
@MappedSuperclass
@IdClass(BaseEntity.class)
public abstract class BaseEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",updatable = false, nullable = false,precision = 18)
	protected Long id;

	@Column(name="CreatedAt")
	protected LocalDateTime createdAt;

	@Column(name="CreatedLoginId")
	protected Long createdLoginId;

	@Column(name="UpdatedAt")
	protected LocalDateTime updatedAt;

	@Column(name="UpdatedLoginId")
	protected Long updatedLoginId;

}
