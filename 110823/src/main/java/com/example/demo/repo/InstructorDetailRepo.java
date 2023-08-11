package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.InstructorDetail;

public interface InstructorDetailRepo extends JpaRepository<InstructorDetail, Integer> {

}
