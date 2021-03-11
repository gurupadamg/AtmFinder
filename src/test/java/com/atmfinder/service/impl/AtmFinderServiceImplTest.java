package com.atmfinder.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.atmfinder.exception.AtmDetailsNotFoundException;
import com.atmfinder.model.Address;
import com.atmfinder.model.AtmDetails;
import com.atmfinder.service.LookUpService;

@ExtendWith(MockitoExtension.class)
public class AtmFinderServiceImplTest {

	@InjectMocks
	private AtmFinderServiceImpl atmFinderServiceImpl;

	@Mock
	private LookUpService<List<AtmDetails>> apiService;

	private List<AtmDetails> atmDetails = new ArrayList<>();

	@BeforeEach
	public void init() {
		Address address = new Address();
		address.setCity("Hyderabad");
		AtmDetails atm = new AtmDetails();
		atmDetails.add(atm);
	}

	@Test()
	public void givenAtmDetails_whenNoAtmDetails_thenReturnAtmDetails() {
		when(apiService.fetchDataFromAPI()).thenReturn(atmDetails);
		List<AtmDetails> actualResponse = atmFinderServiceImpl.getAtmDetails();
		assertEquals(1, actualResponse.size());
	}

	@Test()
	public void givenAtmDetailsByCityName_whenNoAtmDetailsMatched_thenThrowsNPE() {
		String cityName = "test";
		assertThrows(NullPointerException.class, () -> {
			atmFinderServiceImpl.getAtmDetailsByCityName(cityName);
		});
	}

	@Test()
	public void givenAtmDetailsByCityName_whenAtmDetailsMatched_thenReturnAtmDetails() {
		String cityName = "Hyderabad";
		when(apiService.fetchDataFromAPI()).thenReturn(atmDetails);
		assertThrows(AtmDetailsNotFoundException.class, () -> {
			atmFinderServiceImpl.getAtmDetailsByCityName(cityName);
		});
	}

	@Test()
	public void givenAtmDetails_whenNoAtmDetails_thenThrowsAtmDetailsNotFoundException() {
		when(apiService.fetchDataFromAPI()).thenThrow(AtmDetailsNotFoundException.class);

		assertThrows(AtmDetailsNotFoundException.class, () -> {
			atmFinderServiceImpl.getAtmDetails();
		});
	}

	@Test()
	public void givenAtmDetailsByCityName_whenNoAtmDetails_thenThrowsAtmDetailsNotFoundException() {
		String cityName = "test";
		when(apiService.fetchDataFromAPI()).thenThrow(AtmDetailsNotFoundException.class);
		assertThrows(AtmDetailsNotFoundException.class, () -> {
			atmFinderServiceImpl.getAtmDetailsByCityName(cityName);
		});
	}
}
