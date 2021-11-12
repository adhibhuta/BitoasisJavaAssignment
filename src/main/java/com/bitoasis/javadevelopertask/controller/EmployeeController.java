package com.bitoasis.javadevelopertask.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitoasis.javadevelopertask.entity.Ticker;
import com.bitoasis.javadevelopertask.exception.NoTickerFound;
import com.bitoasis.javadevelopertask.service.TickerService;

/**
 * Controller class to perform CRUD operations
 * 
 * @author debjyoti
 *
 */
@RestController
public class EmployeeController {

	@Autowired
	TickerService tickerService;

	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	/**
	 * Get all the tickers saved
	 * 
	 * @return ResponseEntity<List<Ticker>>
	 */
	@GetMapping("/tickers")
	public ResponseEntity<List<Ticker>> getAllTickers() {

		logger.info("Called getAllTickers method");

		List<Ticker> tickers = tickerService.getAllTickers();

		return new ResponseEntity<List<Ticker>>(tickers, HttpStatus.OK);
	}

	/**
	 * Get a ticker by id
	 * 
	 * @param int
	 * @return ResponseEntity<Ticker>
	 * @throws NoTickerFound
	 */
	@GetMapping("/ticker/{id}")
	public ResponseEntity<Ticker> getTickerById(@PathVariable("id") int id) throws NoTickerFound {

		logger.info("Called getTickerById method");
		Ticker ticker = null;
		ticker = tickerService.getTickerById(id);
		return new ResponseEntity<Ticker>(ticker, HttpStatus.OK);

	}

	/**
	 * Delete a ticker by id
	 * 
	 * @param int
	 * @return ResponseEntity<Void>
	 * @throws EmptyResultDataAccessException
	 */
	@DeleteMapping("/ticker/{id}")
	public ResponseEntity<Void> deleteTickerById(@PathVariable("id") int id) throws EmptyResultDataAccessException {

		logger.info("Called deleteTickerById method");

		tickerService.deleteTickerById(id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * Delete all saved tickers
	 * 
	 * @return ResponseEntity<Void>
	 */
	@DeleteMapping("/tickers")
	public ResponseEntity<Void> deleteAllTicker() {

		logger.info("Called deleteAllTicker method");

		tickerService.deleteAllTicker();

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * Update a ticker
	 * 
	 * @param Ticker
	 * @return ResponseEntity<Ticker>
	 */
	@PutMapping("/ticker")
	public ResponseEntity<Ticker> updateTicker(@RequestBody Ticker ticker) {

		logger.info("Called updateTicker method");

		Ticker tickerSaved = tickerService.updateTicker(ticker);

		return new ResponseEntity<Ticker>(tickerSaved, HttpStatus.OK);
	}

	/**
	 * Get a list of a tickers on given date
	 * 
	 * @param String
	 * @return ResponseEntity<List<Ticker>>
	 * @throws ParseException
	 */
	@GetMapping("/tickerbydate")
	public ResponseEntity<List<Ticker>> findAllTickerByDate(@RequestParam String date) throws ParseException {

		logger.info("Called findAllTickerByDate method");

		Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);

		List<Ticker> tickers = tickerService.findAllTickerByDate(d);

		return new ResponseEntity<List<Ticker>>(tickers, HttpStatus.OK);

	}

}
