package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Employee {
	@Id
	@Column(name = "id")
	private int employeeId;
	@NotNull
	@Length(min = 8, max = 16)
	@Column(name = "first_name")
	private String firstName;
	@NotNull
	@Length(min = 2, max = 8)
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	@Email
	private String email;

}
