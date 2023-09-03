package com.vaccinemanagement.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaccinemanagement.entity.Citizen;
import com.vaccinemanagement.exceptions.CitizenErrorResponse;
import com.vaccinemanagement.exceptions.CitizenNotFoundException;
import com.vaccinemanagement.service.VaccineService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class VaccinemanagementRestController{
	
	@Autowired
	private VaccineService vaccineService;

	@GetMapping(value="/citizens")
	public List<Citizen> getCitizens() {
		return vaccineService.getCitizens();
	}
	
	@PostMapping(value="/citizens")
	public Citizen addCitizens(@RequestBody Citizen theCitizen) {
		vaccineService.saveCitizen(theCitizen);
		return theCitizen;
	}
	
	@PutMapping(value="/citizens")
	public Citizen updateCitizens(@RequestBody Citizen theCitizen) {
		Citizen citizen = vaccineService.getCitizen(theCitizen.getRefid());
		if(citizen != null) {
			vaccineService.saveCitizen(theCitizen);
		}		
		else {
			throw new CitizenNotFoundException("Citizen ID not found - " + theCitizen.getRefid());
		}			
		return citizen;
	}
	
	@GetMapping(value="/citizens/{id}")
	public Citizen getCitizens(@PathVariable("id") long id)  {
		Citizen citizen = vaccineService.getCitizen(id);
		if(citizen != null) {
			return citizen;
		}		
		else {
			throw new CitizenNotFoundException("Citizen ID not found - " + id);
		}
	}
	
	@DeleteMapping(value="/citizens/{id}")
	public Citizen deleteCitizens(@PathVariable("id") long id) {
		Citizen citizen = vaccineService.getCitizen(id);
		if(citizen != null) {
			vaccineService.deleteCitizen(id);
		}		
		else {
			throw new CitizenNotFoundException("Citizen ID not found - " + id);
		}			
		return citizen;
	}
	
	
	// Handling Exceptions using @ExceptionHandler Annotation
	
	
	
	@ExceptionHandler
	public ResponseEntity<CitizenErrorResponse> handleException(CitizenNotFoundException E) {
		
		CitizenErrorResponse error = new CitizenErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(E.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	 }
	
	@ExceptionHandler
	public ResponseEntity<CitizenErrorResponse> handleException(Exception E) {
		
		CitizenErrorResponse error = new CitizenErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(E.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	 }
}