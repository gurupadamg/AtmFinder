package com.atmfinder.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import com.atmfinder.exception.AtmDetailsConversionException;
import com.atmfinder.exception.AtmDetailsNotFoundException;
import com.atmfinder.model.AtmDetails;
import com.atmfinder.service.LookUpService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class INGLookUpServiceImpl implements LookUpService<List<AtmDetails>> {

	private static final String url = "https://www.ing.nl/api/locator/atms/";

	@Override
	public List<AtmDetails> fetchDataFromAPI() {
		List<AtmDetails> atmDetails = null;
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(url, String.class);
		if (!ObjectUtils.isEmpty(response) && response.length() > 6
				&& !ObjectUtils.isEmpty(response.substring(6, response.length()))) {
			try {
				atmDetails = mapToAtmDetails(response.substring(6, response.length()));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				throw new AtmDetailsConversionException("Unable to get Atm Detals");
			} catch (Exception e) {
				e.printStackTrace();
				throw new AtmDetailsConversionException("Unable to get Atm Detals");
			}
		}
		if (ObjectUtils.isEmpty(atmDetails))
			throw new AtmDetailsNotFoundException("AtmDetails Not Found");
		return atmDetails;
	}

	private List<AtmDetails> mapToAtmDetails(String str) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		AtmDetails[] atmDetails = mapper.readValue(str, AtmDetails[].class);
		return Arrays.asList(atmDetails);
	}

}
