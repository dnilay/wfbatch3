package com.example.demo.rest;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Instructor;
import com.example.demo.repo.InstructorRepo;

@RestController
@RequestMapping("/instructors")

public class InstructorController {

	private final InstructorRepo instructorRepo;

	// constructor injection
	public InstructorController(InstructorRepo instructorRepo) {
		super();
		this.instructorRepo = instructorRepo;

	}

	@PostMapping
	public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
		Instructor i = instructorRepo.save(instructor);
		return new ResponseEntity<Instructor>(i, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Instructor>> findInstructorById(@PathVariable("id") int id) {

		Optional<Instructor> inOptional=instructorRepo.findById(id);
		System.out.println(inOptional);
		return ResponseEntity.ok(inOptional);
	}
	@GetMapping("/find/{email}")
	public ResponseEntity<Optional<Instructor>> findInstructorByEmail(@PathVariable("email") String email) {

		Optional<Instructor> inOptional=instructorRepo.findByEmail(email);
		System.out.println(inOptional);
		return ResponseEntity.ok(inOptional);
	}
}
