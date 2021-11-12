package com.bitoasis.javadevelopertask.service;

import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.bitoasis.javadevelopertask.entity.Ticker;
import com.bitoasis.javadevelopertask.exception.NoTickerFound;
import com.bitoasis.javadevelopertask.repository.TickerRepository;

/**
 * Implementation of Ticker Service, does all the CRUD operations
 * 
 * @author debjyoti
 *
 */

@Service
public class TickerServiceImpl implements TickerService {

	@Autowired
	TickerRepository tickerRepository;

	Logger logger = LoggerFactory.getLogger(TickerServiceImpl.class);

	/**
	 * Returns a list of all the tickers
	 * 
	 * @return List<Ticker>
	 */
	public List<Ticker> getAllTickers() {
		return tickerRepository.findAll();
	}

	/**
	 * Returns Ticker by id
	 * 
	 * @param int
	 * @return Ticker
	 * @throws NoTickerFound
	 */
	public Ticker getTickerById(int id) throws NoTickerFound {

		Optional<Ticker> ticker = tickerRepository.findById(id);

		if (ticker.isPresent()) {
			return ticker.get();
		} else {
			throw new NoTickerFound("Could not find ticker with id: " + id);
		}

	}

	/**
	 * Delete ticker by id
	 * 
	 * @param int
	 * @throws EmptyResultDataAccessException
	 */
	public void deleteTickerById(int id) throws EmptyResultDataAccessException {

		tickerRepository.deleteById(id);

	}

	/**
	 * Delete all ticker
	 * 
	 */
	public void deleteAllTicker() {

		tickerRepository.deleteAll();

	}

	/**
	 * Update a ticker
	 * 
	 * @param Ticker
	 * @return Ticker
	 */
	public Ticker updateTicker(Ticker ticker) {

		return tickerRepository.save(ticker);
	}

	/**
	 * Finds List of Tickers by date
	 * 
	 * @param Date
	 * @return List<Ticker>
	 */
	public List<Ticker> findAllTickerByDate(Date date) {

		return tickerRepository.findAllByDate(date);
	}

}
