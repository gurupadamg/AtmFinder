package com.atmfinder.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AtmFinderGlobalExceptionHandler {
	
	
	@ExceptionHandler(AtmDetailsConversionException.class)
	public ResponseEntity<AtmFinderException> handleAtmDetailsConversionException(AtmDetailsConversionException e){
		AtmFinderException afe = new AtmFinderException(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getMessage(), LocalDate.now());
		return new ResponseEntity<AtmFinderException>(afe, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(AtmDetailsNotFoundException.class)
	public ResponseEntity<AtmFinderException> handleAtmDetailsNotFoundException(AtmDetailsNotFoundException e){
		AtmFinderException afe = new AtmFinderException(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getMessage(), LocalDate.now());
		return new ResponseEntity<AtmFinderException>(afe, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<AtmFinderException> handleException(Exception e){
		AtmFinderException afe = new AtmFinderException(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getMessage(), LocalDate.now());
		return new ResponseEntity<AtmFinderException>(afe, HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
