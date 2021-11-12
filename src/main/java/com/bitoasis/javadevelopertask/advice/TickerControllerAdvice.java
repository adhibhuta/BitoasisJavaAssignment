package com.bitoasis.javadevelopertask.advice;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bitoasis.javadevelopertask.exception.NoTickerFound;

/**
 * Manage global exceptions for controllers
 * 
 * @author debjyoti
 *
 */
@ControllerAdvice
public class TickerControllerAdvice {
	
	Logger logger = LoggerFactory.getLogger(TickerControllerAdvice.class);
	
	/**
	 * Handle exceptions when something can't be parsed
	 * 
	 * @param ParseException
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler(ParseException.class)
	public ResponseEntity<String> handleParseExceptions(ParseException parseExcepttion){
		
		logger.debug(parseExcepttion.getMessage());
		
		return new ResponseEntity<String>("Date could not be parse, has to be in YYYY-mm-dd format", HttpStatus.BAD_REQUEST);
	}
	
	
	/**
	 * Handles NoTicketFoundExceptions
	 * 
	 * @param NoTickerFound
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler(NoTickerFound.class)
	public ResponseEntity<String> handleNoTickerFound(NoTickerFound noTickerFound){
		
		logger.debug(noTickerFound.getMessage());
		
		return new ResponseEntity<String>("The ticker is not available", HttpStatus.NOT_FOUND);
		
	}
	
	/**
	 * 
	 * @param EmptyResultDataAccessException
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<String> handleEmptyResultDataAccessException(EmptyResultDataAccessException emptyResultDataAccessException){
		
		logger.debug(emptyResultDataAccessException.getMessage());
		
		return new ResponseEntity<String>("The ticker is not available", HttpStatus.BAD_REQUEST);
	}

}
