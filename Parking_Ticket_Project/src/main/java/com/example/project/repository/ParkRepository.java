package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.model.Park;

@Repository
public interface ParkRepository extends JpaRepository<Park, Long>{
	
	

}
