package com.atmfinder.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.atmfinder.exception.AtmDetailsNotFoundException;
import com.atmfinder.model.AtmDetails;
import com.atmfinder.service.AtmFinderService;
import com.atmfinder.service.LookUpService;

@Service
public class AtmFinderServiceImpl implements AtmFinderService {

	@Autowired
	private LookUpService<List<AtmDetails>> apiService;

	@Override
	public List<AtmDetails> getAtmDetails() {
		List<AtmDetails> atmDetails = apiService.fetchDataFromAPI();
		if (ObjectUtils.isEmpty(atmDetails))
			throw new AtmDetailsNotFoundException("AtmDetails Not Found");
		return atmDetails;
	}

	@Override
	public List<AtmDetails> getAtmDetailsByCityName(String cityName) {
		List<AtmDetails> atmDetails = apiService.fetchDataFromAPI();
		atmDetails = atmDetails.stream().filter(
				ad -> ad != null && ad.getAddress() != null && cityName.equalsIgnoreCase(ad.getAddress().getCity()))
				.collect(Collectors.toList());
		if (ObjectUtils.isEmpty(atmDetails))
			throw new AtmDetailsNotFoundException("AtmDetails Not Found for given city" + cityName);
		return atmDetails;
	}
}
