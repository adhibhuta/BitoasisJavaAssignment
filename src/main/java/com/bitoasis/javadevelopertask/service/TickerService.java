package com.bitoasis.javadevelopertask.service;

import java.util.Date;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.bitoasis.javadevelopertask.entity.Ticker;
import com.bitoasis.javadevelopertask.exception.NoTickerFound;

/**
 * Ticker Service Interface
 * 
 * @author debjyoti
 *
 */
public interface TickerService {

	/**
	 * Returns a list of all the tickers
	 * 
	 * @return List<Ticker>
	 */
	public List<Ticker> getAllTickers();

	/**
	 * Returns Ticker by id
	 * 
	 * @param int
	 * @return Ticker
	 * @throws NoTickerFound
	 */
	public Ticker getTickerById(int id) throws NoTickerFound;

	/**
	 * Delete ticker by id
	 * 
	 * @param int
	 * @throws @throws EmptyResultDataAccessException
	 */
	public void deleteTickerById(int id) throws EmptyResultDataAccessException;

	/**
	 * Delete all ticker
	 * 
	 */
	public void deleteAllTicker();

	/**
	 * Update a ticker
	 * 
	 * @param Ticker
	 * @return Ticker
	 */
	public Ticker updateTicker(Ticker ticker);

	/**
	 * Finds List of Tickers by date
	 * 
	 * @param Date
	 * @return List<Ticker>
	 */
	public List<Ticker> findAllTickerByDate(Date d);

}
