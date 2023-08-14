package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Instructor;

public interface InstructorRepo extends JpaRepository<Instructor, Integer> {

	@Query
	public Optional<Instructor> findByEmail(String email);

	@Query
	public List<Instructor> findByFirstNameOrLastName(String firstName, String lastName);

}
