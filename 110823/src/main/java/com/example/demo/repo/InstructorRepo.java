package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Instructor;

public interface InstructorRepo extends JpaRepository<Instructor, Integer> {

}
