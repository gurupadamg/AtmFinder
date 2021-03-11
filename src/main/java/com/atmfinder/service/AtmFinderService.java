package com.atmfinder.service;

import java.util.List;

import com.atmfinder.model.AtmDetails;

public interface AtmFinderService {

	List<AtmDetails> getAtmDetails();
	List<AtmDetails> getAtmDetailsByCityName(String cityName);
}
