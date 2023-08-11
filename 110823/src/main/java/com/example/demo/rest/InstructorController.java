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
import com.example.demo.model.InstructorDetail;
import com.example.demo.repo.InstructorDetailRepo;
import com.example.demo.repo.InstructorRepo;

@RestController
@RequestMapping("/instructors")

public class InstructorController {

	private final InstructorRepo instructorRepo;
	private final InstructorDetailRepo instructorDetailRepo;
	// constructor injection
	public InstructorController(InstructorRepo instructorRepo, InstructorDetailRepo instructorDetailRepo) {
		super();
		this.instructorRepo = instructorRepo;
		this.instructorDetailRepo = instructorDetailRepo;
	}
	@PostMapping
	public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
		Instructor i = instructorRepo.save(instructor);
		return new ResponseEntity<Instructor>(i, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findInstructorDetailById(@PathVariable("id") int id)
	{
		Optional<InstructorDetail> o=instructorDetailRepo.findById(id);
		
		return ResponseEntity.ok(o);
	
	}

}
