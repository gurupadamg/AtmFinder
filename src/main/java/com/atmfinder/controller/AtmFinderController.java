package com.atmfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.atmfinder.model.AtmDetails;
import com.atmfinder.service.AtmFinderService;

@RestController
public class AtmFinderController {
	
	
	@Autowired
	private AtmFinderService atmFinderService;

	
	@GetMapping("/api/v1/atms")
	public ResponseEntity<List<AtmDetails>> getAtmDetails(){
		List<AtmDetails> atmDetails = atmFinderService.getAtmDetails();
		return new ResponseEntity<List<AtmDetails>>(atmDetails, HttpStatus.OK);
	}
	
	@GetMapping("/api/v1/atms/{cityName}")
	public ResponseEntity<List<AtmDetails>> getAtmDetailsByCityName(@PathVariable("cityName") String cityName){
		List<AtmDetails> atmDetails = atmFinderService.getAtmDetailsByCityName(cityName);
		return new ResponseEntity<List<AtmDetails>>(atmDetails, HttpStatus.OK);
	}
}
