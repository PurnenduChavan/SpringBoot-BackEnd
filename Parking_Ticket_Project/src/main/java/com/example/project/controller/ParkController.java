package com.example.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.exception.ResourceNotFoundException;
import com.example.project.model.Park;
import com.example.project.repository.ParkRepository;

@RestController
@RequestMapping("api/v1/")
public class ParkController {

	@Autowired
	private ParkRepository parkRepository;
	
	
	//get all parking vehicle list
	@CrossOrigin(origins={"http://localhost:4200/"})
	@GetMapping("/park")
	public List<Park> getAllParking(){
		return parkRepository.findAll();
	}
	
	@CrossOrigin(origins="http://localhost:4200/")
	@PostMapping("/park")
	public Park createPark(@RequestBody Park park) {
		return parkRepository.save(park);
	}
	
	@CrossOrigin(origins="http://localhost:4200/")
	@GetMapping("/park/{id}")
	public ResponseEntity<Park>  getParkbyId(@PathVariable Long id) {
		Park park=parkRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Vehicle not found"+id));
		return ResponseEntity.ok(park);
	}

	@CrossOrigin(origins="http://localhost:4200/")
	@PutMapping("/park/{id}")
	public ResponseEntity<Park> updatePark(@PathVariable Long id, @RequestBody Park parkDetails){
		Park park=parkRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Vehicle not found"+id));
		
		park.setVehiclenumber(parkDetails.getVehiclenumber());
		park.setType(parkDetails.getType());
		park.setIntime(parkDetails.getIntime());
		park.setOuttime(parkDetails.getOuttime());
		
		Park updatePark= parkRepository.save(park);
		return ResponseEntity.ok(updatePark);
		
	}
	@CrossOrigin(origins="http://localhost:4200/")
	@DeleteMapping("/park/{id}")
	public ResponseEntity<Map<String,Boolean>> deletePark(@PathVariable Long id){
		Park park=parkRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Vehicle not found"+id));

		parkRepository.delete(park);
		Map<String ,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	
	
}
